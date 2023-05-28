package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ImagenDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    @Override
    // Método que permite crear un producto
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
        Map<String, String> imagenes = productoDTO.getImagenes().stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getUrl()));

        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(productoDTO.getNombre());
        nuevoProducto.setDescripcion(productoDTO.getDescripcion());
        nuevoProducto.setEstado(Estado.INACTIVO);
        nuevoProducto.setPrecio(productoDTO.getPrecio());
        nuevoProducto.setDisponibilidad(productoDTO.getDisponibilidad());
        nuevoProducto.setVendedor(usuarioServicio.obtenerUsuarioBDCorreo(productoDTO.getVendedor()));
        nuevoProducto.setLstImages(imagenes);
        nuevoProducto.setLstCategorias(productoDTO.getCategorias());
        nuevoProducto.setFechaPublicacion(LocalDate.now());
        nuevoProducto.setFechaLimite(LocalDate.now().plusDays(30));

        return productoRepo.save(nuevoProducto).getCodigo();
    }
    @Override
    // Método que permite eliminar un producto de la base de datos dado su código
    public int eliminarProducto(int codigoProducto) throws Exception {
        Producto producto = null;

        if (confirmarExistenciaProducto(codigoProducto)) {
            producto = obtenerProductoBD(codigoProducto);
            producto.setEstado(Estado.INACTIVO);
            return productoRepo.save(producto).getCodigo();
        }

        return 0;
    }
    @Override
    // Método que permite actualizar un registro de un producto de la base de datos
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {
        Producto producto = null;
        Map<String, String> imagenes = productoDTO.getImagenes().stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getUrl()));

        if (confirmarExistenciaProducto(codigoProducto)) {
            producto = obtenerProductoBD(codigoProducto);
            producto.setCodigo(codigoProducto);
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setLstImages(imagenes);
            producto.setLstCategorias(productoDTO.getCategorias());
            producto.setDisponibilidad(productoDTO.getDisponibilidad());
            return productoRepo.save(producto).getCodigo();
        }

        return 0;
    }
    @Override
    // Método que permite actualizar el estado de un producto
    public int actualizarPorEstado(int codigoProducto, Estado estado) throws Exception {
        Producto producto = null;

        if (confirmarExistenciaProducto(codigoProducto)) {
            producto = obtenerProductoBD(codigoProducto);
            producto.setEstado(estado);
            return productoRepo.save(producto).getCodigo();
        }

        return 0;
    }
    // Método que permite obtener un producto mediante su codigo
    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {
        ProductoGetDTO productoGetDTO = transformarProducto(obtenerProductoBD(codigoProducto));

        return productoGetDTO;
    }
    @Override
    // Método que permite obtener de la base de datos un producto dado su código sin transformar
    public Producto obtenerProductoBD(int codigoProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if (producto.isEmpty()) {
            throw new Exception("El producto con el código " + codigoProducto + " no existe en la base de datos");
        }

        return producto.get();
    }
    @Override
    // Método que permite obtener una lista de productos por una categoria
    public List<ProductoGetDTO> listarProductosPorCategoria(Categoria categoria) {
        List<ProductoGetDTO> lstRespuesta = new ArrayList<>();
        List<Producto> lstProductos = productoRepo.getProductosPorCategoria(categoria);

        if (lstProductos != null && lstProductos.size() > 0) {
            lstProductos.forEach(producto -> {
                lstRespuesta.add(transformarProducto(producto));
            });
        }

        return lstRespuesta;
    }
    @Override
    // Método que permite obtener una lista de productos por vendedor
    public List<ProductoGetDTO> listarProductoUsuario(String cedulaUsuario) throws Exception{
        List<ProductoGetDTO> lstRespuestaProductos = new ArrayList<>();
        List<Producto> lstProductos = productoRepo.getProductosPorUsuario(cedulaUsuario);

        if (lstProductos != null && lstProductos.size() > 0) {
            lstProductos.forEach(producto -> {
                lstRespuestaProductos.add(transformarProducto(producto));
            });
        }

        return lstRespuestaProductos;
    }
    @Override
    // Método que permite obtener los productos favoritos de un usuario
    public List<ProductoGetDTO> listarProductoFavUsuario(String cedulaUsuario) throws Exception {
        List<ProductoGetDTO> lstRespuestaProducto = new ArrayList<>();
        Usuario usuario = usuarioServicio.obtenerUsuarioBD(cedulaUsuario);
        List<Producto> lstProductos = productoRepo.getProductosFavoritos(usuario);

        if (lstProductos != null && lstProductos.size() > 0) {
            lstProductos.forEach(producto -> {
                lstRespuestaProducto.add(transformarProducto(producto));
            });
        }

        return lstRespuestaProducto;
    }
    @Override
    // Método que permite obtener una lista de productos dado un rango de precios
    public List<ProductoGetDTO> listarProductoPrecios(double precioMin, double precioMax) {
        List<ProductoGetDTO> lstRespuestaProducto = new ArrayList<>();
        List<Producto> lstProductos = productoRepo.getProductosPorRangoPrecio(precioMin, precioMax);

        if (lstProductos != null && lstProductos.size() > 0) {
            lstProductos.forEach(producto -> {
                lstRespuestaProducto.add(transformarProducto(producto));
            });
        }

        return lstRespuestaProducto;
    }

    @Override
    // Método que permite obtener una lista de productos dado su nombre
    public List<ProductoGetDTO> listarProductosPorNombre(String nombre) {
        List<ProductoGetDTO> lstRespuestaProducto = new ArrayList<>();
        List<Producto> lstProductos = productoRepo.getProductosPorNombre(nombre);

        if (lstProductos != null && lstProductos.size() > 0) {
            lstProductos.forEach(producto -> {
                lstRespuestaProducto.add(transformarProducto(producto));
            });
        }

        return lstRespuestaProducto;
    }

    @Override
    // Método que permite transformar una lista de productos a una lista de productos get dto
    public List<ProductoGetDTO> transformarListaProductos(List<Producto> productos) {
        List<ProductoGetDTO> lstRespuestaProductos = new ArrayList<>();
        productos.forEach(producto -> {
            lstRespuestaProductos.add(transformarProducto(producto));
        });

        return lstRespuestaProductos;
    }

    @Override
    public int obtenerDisponibilidadProducto(int codigo) {
        return 0;
    }

    @Override
    public List<ProductoGetDTO> listarTodosLosProductos() {
        List<Producto> lstProductos = productoRepo.obtenerTodosLosProductos();
        List<ProductoGetDTO> lstRespuesta = new ArrayList<>();

        lstRespuesta = transformarListaProductos(lstProductos);

        return  lstRespuesta;
    }

    @Override
    public List<Categoria> obtenerListaCategorias() {
        List<Categoria> lstCategorias = new ArrayList<>();
        lstCategorias.add(Categoria.Juegos);
        lstCategorias.add(Categoria.Belleza);
        lstCategorias.add(Categoria.Moda);
        lstCategorias.add(Categoria.Vehiculos);
        lstCategorias.add(Categoria.Tecnologia);
        lstCategorias.add(Categoria.Electrodomesticos);

        return lstCategorias;
    }

    @Override
    public List<ProductoGetDTO> obtenereProductosModerador() {
        List<Producto> lstProductos = productoRepo.obetenerProductosModerador();
        List<ProductoGetDTO> lstRespuesta = new ArrayList<>();

        lstRespuesta = transformarListaProductos(lstProductos);

        return  lstRespuesta;
    }

    // Método que permite saber si el producto existe en la base de datos, dado su código
    private boolean confirmarExistenciaProducto(int codigoProducto) throws Exception {
        boolean existe = productoRepo.existsById(codigoProducto);

        if (!existe) {
            throw new Exception("El código " + codigoProducto + " no esta asociado a ningún producto");
        }

        return existe;
    }

    // Método que permite transformar un producto en un producto get dto
    private ProductoGetDTO transformarProducto(Producto producto) {
        List<ImagenDTO> lstImagenes = producto.getLstImages().entrySet().stream().map(x -> {
            return new ImagenDTO(x.getKey(), x.getValue());
        }).collect(Collectors.toList());

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getDisponibilidad(),
                producto.getFechaLimite(),
                producto.getFechaPublicacion(),
                producto.getVendedor().getCedula(),
                producto.getVendedor().getNombreCompleto(),
                lstImagenes,
                producto.getLstCategorias(),
                producto.getEstado()
        );

        return productoGetDTO;
    }

}
