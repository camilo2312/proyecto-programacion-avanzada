package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int disponibilidad;
    private LocalDate fechaLimite;
    private LocalDate fechaPublicacion;
    private String vendedor;
    private String nombreVendedor;
    private List<ImagenDTO> imagenes;
    private List<Categoria> categorias;
    private Estado estado;
}
