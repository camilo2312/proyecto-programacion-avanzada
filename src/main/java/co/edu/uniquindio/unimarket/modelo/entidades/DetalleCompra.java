package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleCompra {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private int codigo;
    private int unidades;
    private double precioProducto;
}
