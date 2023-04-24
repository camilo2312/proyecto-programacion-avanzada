package co.edu.uniquindio.unimarket.servicios.implementacion;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    @Override
    // Método que permite crear un producto
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(productoDTO.getNombre());
        nuevoProducto.setDescripcion(productoDTO.getDescripcion());
        nuevoProducto.setEstado(Estado.SIN_REVISAR);
        nuevoProducto.setPrecio(productoDTO.getPrecio());
        nuevoProducto.setVendedor(usuarioServicio.obtenerUsuarioBD(productoDTO.getVendedor()));
        nuevoProducto.setLstImages(productoDTO.getImagenes());
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

        if (confirmarExistenciaProducto(codigoProducto)) {
            producto = obtenerProductoBD(codigoProducto);
            producto.setCodigo(codigoProducto);
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setLstImages(productoDTO.getImagenes());
            producto.setLstCategorias(productoDTO.getCategorias());
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
    // Método que permite obtener una lista de categorias por vendedor
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
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getDisponibilidad(),
                producto.getFechaLimite(),
                producto.getFechaPublicacion(),
                producto.getVendedor().getCedula(),
                producto.getLstImages(),
                producto.getLstCategorias()
        );

        return productoGetDTO;
    }

}
