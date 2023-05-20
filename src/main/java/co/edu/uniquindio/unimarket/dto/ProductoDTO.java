package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDTO {
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100, message = "El producto debe tener mínimo 1 caracter y máximo 100")
    private String nombre;
    @Length(max = 200, message = "La descripción debe contener máximo 200 caracteres")
    private String descripcion;
    @NotNull(message = "El precio del producto no puede ser nulo")
    @Positive(message = "El precio del producto debe ser mayor a 0")
    private double precio;
    @NotNull
    @Min(value = 1,message = "La disponibilidad el producto debe ser mayor a 1")
    private int disponibilidad;
    @NotNull(message = "El correo del vendedor no puede ser nulo")
    @NotBlank
    private String vendedor;
    @NotNull
    @Size(min = 1, message = "El producto debe contener por lo menos una imagen")
    private List<ImagenDTO> imagenes;
    @NotNull
    @Size(min = 1, message = "El producto debe estar asociado por lo menos a 1 categoria")
    private List<Categoria> categorias;
}
