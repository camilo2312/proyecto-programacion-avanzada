package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.*;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    private final DetalleCompraServicio detalleCompraServicio;
    private final ProductoServicio productoServicio;
    private final DireccionServicio direccionServicio;
    private final EmailServicio emailServicio;

    @Override
    // Método que permite crear una compra en la base de datos
    public int      crearCompra(CompraDTO compraDTO) throws Exception {
        Compra nuevaCompra = new Compra();
        Usuario usuarioCompra = new Usuario();
        Usuario vendedor = new Usuario();
        Producto producto = new Producto();
        EmailMensajeDTO emailMensajeDTO = new EmailMensajeDTO();
        int resultadosDetalles = 0;
        String mensajeUsuario = emailMensajeDTO.mensajeCompra;
        String mensajeProductos = emailMensajeDTO.tabla;
        String mensajeTabla = "";
        List<String> correosVendedores = new ArrayList<>();

        usuarioCompra = usuarioServicio.obtenerUsuarioBD(compraDTO.getCodigoUsuario());
        nuevaCompra.setMedioPago(compraDTO.getMedioPago());
        nuevaCompra.setUsuario(usuarioCompra);
        nuevaCompra.setFechaCreacion(LocalDate.now());
        nuevaCompra.setEstado(EstadoCompra.APROBADA);
        nuevaCompra.setPrecioTotal(compraDTO.getTotal());
        nuevaCompra.setDireccion(usuarioCompra.getDirecciones().get(0));

        nuevaCompra = compraRepo.save(nuevaCompra);


        if (nuevaCompra != null) {
            for(DetalleCompraDTO detalleCompraDTO : compraDTO.getDetalleComprasDTO()) {
                if (detalleCompraServicio.crearDetalleCompra(nuevaCompra, detalleCompraDTO) > 0) {
                    resultadosDetalles += 1;

                    producto = productoServicio.obtenerProductoBD(detalleCompraDTO.getCodigoProducto());
                    vendedor = usuarioServicio.obtenerUsuarioBD(producto.getVendedor().getCedula());
                    mensajeTabla +=
                            "<tr>\n" +
                               "<td>" + producto.getNombre() + "</td>\n" +
                               "<td style=\"text-align:right\">" + detalleCompraDTO.getUnidades() + "</td>\n" +
                               "<td style=\"text-align:right\">" + "$" + detalleCompraDTO.getPrecioProducto() + "</td>\n" +
                            "</tr>\n";
                    correosVendedores.add(vendedor.getEmail());
                }
            }

            mensajeProductos = mensajeProductos.replace("{0}", mensajeTabla);
            mensajeUsuario = mensajeUsuario.replace("{0}", emailMensajeDTO.mensajeVendedor).replace("{0}", usuarioCompra.getNombreCompleto())
                    .replace("{1}", mensajeProductos)
                    .replace("{2}", "$" + nuevaCompra.getPrecioTotal());

            emailServicio.enviarEmail(new EmailDTO(
                    "Compra de productos en tienda Unimarket",
                    mensajeUsuario,
                    String.join(",", correosVendedores)
            ));

            mensajeUsuario = emailMensajeDTO.mensajeCompra;
            mensajeUsuario = mensajeUsuario.replace("{0}", emailMensajeDTO.mensajeUsuario).replace("{0}", usuarioCompra.getNombreCompleto())
                    .replace("{1}", mensajeProductos)
                    .replace("{2}", "$" + nuevaCompra.getPrecioTotal());

            emailServicio.enviarEmail(new EmailDTO(
                    "Compra de productos en tienda Unimarket",
                    mensajeUsuario,
                    usuarioCompra.getEmail()
            ));

        }

        return resultadosDetalles > 0 ? nuevaCompra.getCodigo() : 0;
    }

    @Override
    // Método que permite obtener una compra dado su código
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception{
        return transformarCompra(obtenerCompraBD(codigoCompra));
    }

    @Override
    /* Método que permite obtener una compra directamente de la base de dato dado
       su código
    */
    public Compra obtenerCompraBD(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);
        if (compra.isEmpty()) {
            throw new Exception("La compra asociada al código " + codigoCompra + " no existe");
        }

        return compra.get();
    }

    @Override
    // Método que permite listar las compras de un usuario mediante su cédula
    public List<CompraGetDTO> listarCompraUsuario(String cedulaUsuario) {
        List<CompraGetDTO> lstComprasRespuesta = new ArrayList<>();
        List<Compra> lstCompras = compraRepo.obtenerListaComprasPorUsuario(cedulaUsuario);
        if (lstCompras != null && lstCompras.size() > 0) {
            lstCompras.forEach(compra -> {
                lstComprasRespuesta.add(transformarCompra(compra));
            });
        }

        return lstComprasRespuesta;
    }

    @Override
    // Método que permite listar las compras por un estado en especifico
    public List<CompraGetDTO> listarComprasPorEstado(EstadoCompra estadoCompra) throws Exception {
        List<CompraGetDTO> lstComprasRespuesta = new ArrayList<>();
        List<Compra> lstCompras = compraRepo.obtenerListaComprasPorEstado(estadoCompra);

        if (lstCompras != null && lstCompras.size() > 0) {
            lstCompras.forEach(compra -> {
                lstComprasRespuesta.add(transformarCompra(compra));
            });
        }

        return lstComprasRespuesta;
    }

    // Método que permite transformar una compra en su respectivo DTO
    private CompraGetDTO transformarCompra(Compra compra) {
        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFechaCreacion(),
                compra.getMedioPago(),
                compra.getUsuario().getCedula(),
                compra.getPrecioTotal(),
                compra.getEstado(),
                detalleCompraServicio.trasnformarLista(compra.getDetallesCompra()),
                direccionServicio.transformarDireccion(compra.getDireccion())
        );

        return compraGetDTO;
    }
}
