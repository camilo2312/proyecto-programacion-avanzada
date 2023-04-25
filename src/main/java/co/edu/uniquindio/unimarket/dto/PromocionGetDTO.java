package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class PromocionGetDTO {
    private int codigo;
    private String nombre;
    private double porcentajeDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<ProductoGetDTO> lstProductos;
}
