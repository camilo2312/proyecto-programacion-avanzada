package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.DireccionDTO;
import co.edu.uniquindio.unimarket.dto.DireccionGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Direccion;

import java.util.List;

public interface DireccionServicio {
    // Método que permite crear una dirección en la base de datos
    int crearDireccion(DireccionDTO direccionDTO)  throws Exception;
    // Método que permite actualizar una dirección por medio de su código
    int actualizarDireccion(int codigoDireccion, DireccionDTO direccionDTO) throws Exception;
    // Método que permite eliminar una dirección de la base de datos por medio de se código
    boolean eliminarDireccion(int codigoDireccion) throws Exception;
    // Método que permite obtener las direcciones de un usuario por medio de su código
    List<DireccionGetDTO> obtenerDireccionUsuario(String cedulaUsuario) throws Exception;
    Direccion obtenerDireccionBD(int codigoDireccion) throws Exception;
    DireccionGetDTO transformarDireccion(Direccion direccion);
}
