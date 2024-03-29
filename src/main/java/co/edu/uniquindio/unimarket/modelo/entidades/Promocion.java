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
public class Promocion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private String nombrePromocion;
    @Column(nullable = false)
    private double porcentajeDescuento;
    @Column(nullable = false)
    private LocalDate fechaInicio;
    @Column( nullable = false)
    private LocalDate fechaFin;
    @OneToMany(mappedBy = "promocion")
    private List<Producto> productos;
}
