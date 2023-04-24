package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class DetalleCompraGetDTO {
    private int codigo;
    private int unidades;
    private double precioProducto;
    private int codigoCompra;
    private int codigoProducto;
}
