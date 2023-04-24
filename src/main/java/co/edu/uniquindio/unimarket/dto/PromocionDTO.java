package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class PromocionDTO {
    @NotNull(message = "El porcentaje de descuento no puede ser nulo")
    @Positive(message = "El porcentaje deber ser mayor a 0")
    private double porcentajeDescuento;
    @NotNull(message = "El nombre de la promoción no puede ser nula")
    @NotBlank
    private String nombrePromocion;
    @NotNull(message = "La fecha de inicio de la promoción no debe ser nula")
    private LocalDate fechaInicio;
    @NotNull(message = "La fecha fin de la promoción no debe ser nula")
    private LocalDate fechaFin;
    @Size(min = 1, message = "Debe contener por lo meno 1 producto")
    private List<ProductoGetDTO> lstProductos;
}
