package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(length = 100)
    private String nombre;
    private String descripcion;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private int disponibilidad;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @Column(nullable = false)
    private LocalDate fechaPublicacion;
    @Column(length = 20)
    private String estado;
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;
    @ManyToOne
    private Usuario vendedor;
    @ManyToOne
    private Promocion promocion;
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detallesCompra;

}
