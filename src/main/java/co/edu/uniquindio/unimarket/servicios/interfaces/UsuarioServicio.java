package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;

public interface UsuarioServicio {
    String registrarUsuario(UsuarioDTO usuarioDTO) throws  Exception;
    String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception;
//    String  eliminarUsuario(String cedula) throws  Exception;
    UsuarioGetDTO obtenerUsuario(String cedula) throws Exception;

 //   Lista<Usuario> listarUsuarios();
}
