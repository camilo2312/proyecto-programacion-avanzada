package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.Column;
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
public class Compra {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private int codigo;
    private Date fechaCreacion;
    private double precioTotal;
    @Column(length = 50)
    private String medioPago;
}
