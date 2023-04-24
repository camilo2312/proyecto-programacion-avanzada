package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.entidades.Estado;

public interface ModeradorServicio {
    // Método que le permite al moderador actualizar o rechazar un producto, actualizando su estado
    boolean aprobarRechazarProducto(int codigoProducto, Estado estadoProducto) throws Exception;
}
