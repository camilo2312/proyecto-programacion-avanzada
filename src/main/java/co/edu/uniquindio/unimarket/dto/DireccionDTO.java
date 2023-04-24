package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.Moderador;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class DireccionDTO {
    @NotNull
    @NotBlank
    @Length(max = 200, message = "El campo descripción debe tener como máximo 200 caracteres")
    private String descripcion;
    @NotNull
    private int codigoPostal;
    @NotNull
    private String cedulaUsuario;
}
