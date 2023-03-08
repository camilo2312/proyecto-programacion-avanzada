package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int disponibilidad;
    private Date fechaLimite;
    private Date fechaPublicacion;
    private String estado;
}
