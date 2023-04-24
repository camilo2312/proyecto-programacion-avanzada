package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
import lombok.AllArgsConstructor;
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
    private final DireccionServicio direccionServicio;

    @Override
    // Método que permite crear una compra en la base de datos
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra nuevaCompra = new Compra();
        int resultadosDetalles = 0;

        nuevaCompra.setMedioPago(compraDTO.getMedioPago());
        nuevaCompra.setUsuario(usuarioServicio.obtenerUsuarioBD(compraDTO.getCodigoUsuario()));
        nuevaCompra.setFechaCreacion(LocalDate.now());
        nuevaCompra.setEstado(EstadoCompra.APROBADA);
        nuevaCompra.setPrecioTotal(compraDTO.getTotal());

//        for(DetalleCompraDTO detalleCompraDTO : compraDTO.getDetalleComprasDTO()) {
//            total += (detalleCompraDTO.getPrecioProducto() * detalleCompraDTO.getUnidades());
//        }

        nuevaCompra = compraRepo.save(nuevaCompra);

        if (nuevaCompra != null) {
            for(DetalleCompraDTO detalleCompraDTO : compraDTO.getDetalleComprasDTO()) {
                if (detalleCompraServicio.crearDetalleCompra(nuevaCompra.getCodigo(), detalleCompraDTO) > 0) {
                    resultadosDetalles += 1;
                }
            }
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
