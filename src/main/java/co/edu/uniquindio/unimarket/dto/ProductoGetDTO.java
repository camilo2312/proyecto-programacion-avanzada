package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.Promocion;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

public class ProductoGetDTO {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int disponibilidad;
    private LocalDate fechaLimite;
    private LocalDate fechaPublicacion;
    private String vendedor;

    // Lista de imagenes
    // Lista categorias
}
