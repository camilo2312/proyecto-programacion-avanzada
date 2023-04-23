package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {
    String registrarUsuario(UsuarioDTO usuarioDTO) throws  Exception;
    String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception;
    UsuarioGetDTO obtenerUsuario(String cedula) throws Exception;
    Usuario obtenerUsuarioBD(String cedula) throws Exception;
    List<UsuarioGetDTO> obtenerUsuarios() throws Exception;

}
