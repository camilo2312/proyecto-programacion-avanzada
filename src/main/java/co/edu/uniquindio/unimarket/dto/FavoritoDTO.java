package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FavoritoDTO {
    @NotNull(message = "La cédula del usuario no puede ser nula")
    @NotBlank
    private String cedulaUsuario;
    @NotNull(message = "El codigo del producto no debe ser nulo")
    private int codigoProducto;
}
