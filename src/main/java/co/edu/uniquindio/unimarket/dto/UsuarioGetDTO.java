package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioGetDTO {
    private String cedula;
    private String nombreCompleto;
    private String email;
    private String numeroTelefono;
    private String contrasena;
}
