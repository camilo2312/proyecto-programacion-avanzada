package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraServicioImpl implements DetalleCompraServicio {
    private final DetalleCompraRepo detalleCompraRepo;
    private final CompraServicio compraServicio;
    private final ProductoServicio productoServicio;

    @Override
    // Método que permite crear un detalle de compra en la base de datos
    public int crearDetalleCompra(int codigoCompra, DetalleCompraDTO detalleCompraDTO) throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCompra(compraServicio.obtenerCompraBD(codigoCompra));
        detalleCompra.setUnidades(detalleCompraDTO.getUnidades());
        detalleCompra.setPrecioProducto(detalleCompraDTO.getPrecioProducto());
        detalleCompra.setProducto(productoServicio.obtenerProductoBD(detalleCompraDTO.getCodigoProducto()));

        return detalleCompraRepo.save(detalleCompra).getCodigo();
    }

    // Método que permite obtener la lista de detalles asociada a una compra
    @Override
    public List<DetalleCompraGetDTO> obtenerDetallesPorCompra(int codigoCompra) throws Exception {
        List<DetalleCompraGetDTO> lstRespuestaDetalle = new ArrayList<>();
        List<DetalleCompra> lstDetalleCompra = detalleCompraRepo.obtenerDetalleCompraPorCompra(codigoCompra);
        if (lstDetalleCompra != null && lstDetalleCompra.size() > 0) {
            lstDetalleCompra.forEach(detalleCompra -> {
                lstRespuestaDetalle.add(transformarDetalleCompra(detalleCompra));
            });
        }

        return lstRespuestaDetalle;
    }

    @Override
    // Método que permite transformar una lista de detalle compra en una lista de dto's
    public List<DetalleCompraGetDTO> trasnformarLista(List<DetalleCompra> lstDetallesCompra) {
        List<DetalleCompraGetDTO> lstDetalleRespuesta = new ArrayList<>();
        if (lstDetallesCompra != null && lstDetallesCompra.size() > 0) {
            lstDetallesCompra.forEach(detalleCompra -> {
                lstDetalleRespuesta.add(transformarDetalleCompra(detalleCompra));
            });
        }

        return lstDetalleRespuesta;
    }

    // Método que permite convertir un detalle compra en un detalle compra DTO
    private DetalleCompraGetDTO transformarDetalleCompra(DetalleCompra detalleCompra) {
        DetalleCompraGetDTO detalleCompraGetDTO = new DetalleCompraGetDTO(
                detalleCompra.getCodigo(),
                detalleCompra.getUnidades(),
                detalleCompra.getPrecioProducto(),
                detalleCompra.getCompra().getCodigo(),
                detalleCompra.getProducto().getCodigo()
        );

        return detalleCompraGetDTO;
    }
}
