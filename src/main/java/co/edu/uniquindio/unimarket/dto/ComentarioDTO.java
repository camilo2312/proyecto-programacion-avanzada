package co.edu.uniquindio.unimarket.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {
    @Length(max = 300, message = "La descripción del comentario debe tener máximo de 300 caracteres")
    private String descripcion;
    @NotNull(message = "En el comentario el código del producto no puede ser nulo")
    private int codigoProducto;
    @NotNull(message = "La cédula del usuario no puede ser nula")
    private String cedulaUsuario;
}
