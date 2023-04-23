package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {
    @NotNull(message = "Debe existir un medio de pago")
    private MedioPago medioPago;
    @NotNull(message = "El código del usuario no puede ser nulo")
    private String codigoUsuario;
    @Positive(message = "EL precio total de la compra debe ser mayor a 0")
    private double total;
    @NotNull(message = "Los detalles de compra no pueden ser nulos")
    @Size(message = "Debe contener por lo menos 1 detalle de compra")
    private List<DetalleCompraDTO> detalleComprasDTO;
}
