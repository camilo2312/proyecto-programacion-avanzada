package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
public class PromocionGetDTO {
    private int codigo;
    private double porcentajeDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<ProductoGetDTO> lstProductos;
}
