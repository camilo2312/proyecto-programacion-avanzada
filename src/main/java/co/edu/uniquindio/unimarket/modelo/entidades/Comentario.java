package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @ManyToOne
    @ToString.Exclude
    private Usuario usuario;
    @ManyToOne
    @ToString.Exclude
    private Producto producto;
}
