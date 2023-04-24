package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class DetalleCompraDTO {
    @NotNull(message = "Las unidades no pueden ser nula")
    @Min(value = 1, message = "Debe contener por lo menos 1 unidad")
    private int unidades;
    @NotNull(message = "El precio del producto no puede ser nulo")
    @Positive(message = "El precio unitario del producto deber ser mayor a 0")
    private double precioProducto;
    @NotNull(message = "El código del producto no puede ser nulo")
    private int codigoProducto;
}
