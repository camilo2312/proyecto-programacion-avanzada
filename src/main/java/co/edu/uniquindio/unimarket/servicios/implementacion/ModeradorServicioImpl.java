package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {
    private final ProductoServicio productoServicio;
    private final EmailServicio emailServicio;
    @Override
    // Método que le permite al moderador actualizar el estado de un producto
    public boolean aprobarRechazarProducto(int codigoProducto, Estado estadoProducto) throws Exception{
        boolean respuesta = false;
        Producto producto = new Producto();
        if (productoServicio.actualizarPorEstado(codigoProducto, estadoProducto) > 0) {
            producto = productoServicio.obtenerProductoBD(codigoProducto);
            emailServicio.enviarEmail(new EmailDTO(
                    "Estado de producto",
                    "Su producto " + producto.getNombre() + " fue " + estadoProducto,
                    producto.getVendedor().getEmail()
            ));
            respuesta = true;
        }
        return respuesta;
    }
}
