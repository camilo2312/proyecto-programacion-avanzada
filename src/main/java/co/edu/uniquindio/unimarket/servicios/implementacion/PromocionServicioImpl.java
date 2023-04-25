package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.PromocionDTO;
import co.edu.uniquindio.unimarket.dto.PromocionGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Promocion;
import co.edu.uniquindio.unimarket.repositorios.PromocionRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.PromocionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PromocionServicioImpl implements PromocionServicio {
    private final PromocionRepo promocionRepo;
    private final ProductoServicio productoServicio;
    @Override
    // Método que permite crear una promoción
    public int crearPromocion(PromocionDTO promocionDTO) throws Exception {
        List<Producto> lstProductos = new ArrayList<>();
        Producto producto = new Producto();
        Promocion promocion = new Promocion();
        promocion.setNombrePromocion(promocionDTO.getNombrePromocion());
        promocion.setPorcentajeDescuento(promocionDTO.getPorcentajeDescuento());
        promocion.setFechaInicio(promocionDTO.getFechaInicio());
        promocion.setFechaFin(promocionDTO.getFechaFin());

        for (ProductoGetDTO productoGetDTO : promocionDTO.getLstProductos()) {
            producto = productoServicio.obtenerProductoBD(productoGetDTO.getCodigo());
            if (producto != null) {
                if (!validarProductoPromocion(productoGetDTO.getCodigo())) {
                    lstProductos.add(producto);
                } else {
                    throw new Exception("El producto con el código " + productoGetDTO.getCodigo() + " ya tiene una promoción asociada, por favor eliminelo de la lista");
                }
            } else {
                throw new Exception("El producto identidicado con el código " + productoGetDTO.getCodigo() + " no existe en la base de datos," +
                        "por favor cree el producto e intente nuevamente");
            }
        }

        promocion.setProductos(lstProductos);
        return promocionRepo.save(promocion).getCodigo();
    }

    @Override
    // Método que permite actualizar una promoción
    public int actualizarPromocion(int codigo, PromocionDTO promocionDTO) throws Exception {
        List<Producto> lstProductos = new ArrayList<>();
        Promocion promocion = obtenerPromocionBD(codigo);
        promocion.setNombrePromocion(promocionDTO.getNombrePromocion());
        promocion.setPorcentajeDescuento(promocionDTO.getPorcentajeDescuento());
        promocion.setFechaInicio(promocionDTO.getFechaInicio());
        promocion.setFechaFin(promocionDTO.getFechaFin());

        for (ProductoGetDTO productoGetDTO : promocionDTO.getLstProductos()) {
            lstProductos.add(productoServicio.obtenerProductoBD(productoGetDTO.getCodigo()));
        }

        promocion.setProductos(lstProductos);
        return promocionRepo.save(promocion).getCodigo();
    }

    @Override
    // Método que permite eliminar una promoción
    public boolean eliminarPromocion(int codigoPromocion) throws Exception {
        Promocion promocion =  obtenerPromocionBD(codigoPromocion);

        if (promocion != null) {
            promocionRepo.delete(promocion);

            return promocionRepo.count() > 0;
        }

        throw new Exception("La promoción ingresada con el código " +codigoPromocion + " no existe en la base de datos");
    }

    @Override
    // Método que permite obtener una promoción
    public PromocionGetDTO obtenerPromocion(int codigoPromocion) throws Exception {
        return transformarPromocion(obtenerPromocionBD(codigoPromocion));
    }

    // Método que permite validar si el producto ya esta asociado a una promoción
    private boolean validarProductoPromocion(int codigoProducto) throws Exception{
        boolean respuesta = false;

        Producto producto = productoServicio.obtenerProductoBD(codigoProducto);
        Promocion promocion = promocionRepo.obtenerPromocionPorProducto(producto);

        if (promocion != null) {
            respuesta = true;
        }

        return respuesta;
    }

    // Método que permite obtener una promoción directamente de la base de datos
    private Promocion obtenerPromocionBD(int codigoPromocion) throws Exception {
        Promocion promocion = promocionRepo.obtenerPromocion(codigoPromocion);

        if (promocion != null) {
            throw new Exception("La promoción asociada al código " + codigoPromocion + " no existe");
        }

        return promocion;
    }

    // Método que permite transformar una promoción en una promoción get DTO
    private PromocionGetDTO transformarPromocion(Promocion promocion) {
        PromocionGetDTO promocionGetDTO = new PromocionGetDTO(
                promocion.getCodigo(),
                promocion.getNombrePromocion(),
                promocion.getPorcentajeDescuento(),
                promocion.getFechaInicio(),
                promocion.getFechaFin(),
                productoServicio.transformarListaProductos(promocion.getProductos())
        );

        return promocionGetDTO;
    }
}
