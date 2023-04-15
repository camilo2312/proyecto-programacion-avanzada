package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Direccion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int codigoPostal;
    @ManyToOne
    @ToString.Exclude
    private Usuario usuario;
    @ManyToOne
    @ToString.Exclude
    private Moderador moderador;
    @OneToMany(mappedBy = "direccion")
    @ToString.Exclude
    private List<Compra> compras;
}
