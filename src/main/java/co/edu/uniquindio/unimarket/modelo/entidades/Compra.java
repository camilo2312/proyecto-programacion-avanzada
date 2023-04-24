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
public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private double precioTotal;
    @Column(length = 50)
    @Enumerated(value = EnumType.STRING)
    private MedioPago medioPago;
    @Column
    @Enumerated(EnumType.STRING)
    private EstadoCompra estado;
    @ManyToOne
    @ToString.Exclude
    private Usuario usuario;
    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<DetalleCompra> detallesCompra;
    @ManyToOne
    @ToString.Exclude
    private Direccion direccion;
}
