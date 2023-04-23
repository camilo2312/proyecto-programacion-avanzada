package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CompraGetDTO {
    private int codigoCompra;
    private LocalDate fechaCreacion;
    private MedioPago medioPago;
    private String codigoUsuario;
    private double precioTotal;
    private EstadoCompra estadoCompra;
    private List<DetalleCompraGetDTO> detalleCompraGetDTO;
    private DireccionGetDTO direccion;
}
