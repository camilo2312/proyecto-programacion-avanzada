package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;

import java.util.List;

public class CompraDTO {
    private MedioPago medioPago;
    private String codigoUsuario;
    private List<DetalleCompraDTO> detalleComprasDTO;
}
