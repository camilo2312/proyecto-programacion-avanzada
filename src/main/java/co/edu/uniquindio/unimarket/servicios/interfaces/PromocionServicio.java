package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.PromocionDTO;
import co.edu.uniquindio.unimarket.dto.PromocionGetDTO;

public interface PromocionServicio {
    // Método que permite crear una promoción
    int crearPromocion(PromocionDTO promocionDTO) throws Exception;
    // Método que permite actualizar una promoción
    int actualizarPromocion(PromocionDTO promocionDTO) throws Exception;
    // Método que permite eliminar una promoción
    boolean eliminarPromocion(int codigoPromocion) throws Exception;
    // Método que permite obtener una promoción
    PromocionGetDTO obtenerPromocion(int codigoPromocion) throws Exception;
}
