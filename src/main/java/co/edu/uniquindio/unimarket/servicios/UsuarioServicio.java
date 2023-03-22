package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;

public interface UsuarioServicio {
    int registrarUsuario(UsuarioDTO usuarioDTO);
    int actualizarUsuario(String cedula);
    UsuarioGetDTO obtenerUsuario(String cedula);
}
