package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    @Length(max = 10, message = "La cedula debe tener máximo 10 caracteres")
    private String cedula;
    @Length(max = 100, message = "El nombre debe contener máximo 100 caracteres")
    private String nombreCompleto;
    @NotNull
    @NotBlank
    @Length(max = 100, message = "EL correo debe tener máximo 100 caracteres")
    private String email;
    @Length(max = 20, message = "El número de telefono debe tener máximo 20 caracteres")
    private String numeroTelefono;
    @NotNull
    @NotBlank
    @Length(max = 20, message = "El nombre de usuario debe tener máximo 20 caracteres")
    private String nombreUsuario;
    @NotNull
    @NotBlank
    @Length(min = 8, max = 50, message = "La contraseña debe tener minimo 8 caracteres y maximo 50 caracteres")
    private String contrasena;
    private Estado estado;
}
