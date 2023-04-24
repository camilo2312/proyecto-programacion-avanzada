package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductoDTO {
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100, message = "El producto debe tener mínimo 1 caracter y máximo 100")
    private String nombre;
    @Length(max = 200, message = "La descripción debe contener máximo 200 caracteres")
    private String descripcion;
    @NotNull
    private double precio;
    @NotNull
    private int disponibilidad;
    @NotNull
    private String vendedor;
    @NotNull
    private Map<String, String> imagenes;
    @NotNull
    private List<Categoria> categorias;
}
