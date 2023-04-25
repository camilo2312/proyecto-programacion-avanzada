package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;


import java.util.List;


public interface UsuarioServicio {
    // Método que permite registrar un usuario en la base de datos
    String registrarUsuario(UsuarioDTO usuarioDTO) throws  Exception;
    // Método que permite actualizar el registro de un usuario
    String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception;
    // Método que permite obtener un usuario por medio de su cédula
    UsuarioGetDTO obtenerUsuario(String cedula) throws Exception;
    // Método que permite obtener un usuario directamente de la base de datos por medio de su cédula
    Usuario obtenerUsuarioBD(String cedula) throws Exception;
    // Método que permite obtener la lista de usuarios
    List<UsuarioGetDTO> obtenerUsuarios() throws Exception;
    // Método que permite agregar un producto a la lista de favoritos del usuario
    boolean crearProductoFavoritoUsuario(Usuario usuario) throws Exception;
    // Método que permite cambiar la contraseña de acceso del usuario
    boolean cambiarContrasena(String identificacion, String nuevaContrasena) throws Exception;

}
