package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;

public interface UsuarioServicio {
    String registrarUsuario(UsuarioDTO usuarioDTO) throws  Exception;
    String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception;
    UsuarioGetDTO obtenerUsuario(String cedula) throws Exception;
}
