package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioGetDTO {
    private String cedula;
    private String nombreCompleto;
    private String email;
    private String numeroTelefono;
    private String contrasena;
    private String nombreUsuario;
    private Estado estado;
    private List<ProductoGetDTO> lstFavoritos;
}
