package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {
    private final ProductoServicio productoServicio;
    @Override
    // Método que le permite al moderador actualizar el estado de un producto
    public boolean aprobarRechazarProducto(int codigoProducto, Estado estadoProducto) throws Exception{
        boolean respuesta = false;
        if (productoServicio.actualizarPorEstado(codigoProducto, estadoProducto) > 0) {
            respuesta = true;
        }
        return respuesta;
    }
}
