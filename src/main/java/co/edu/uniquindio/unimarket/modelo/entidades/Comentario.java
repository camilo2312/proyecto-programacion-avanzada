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
public class Comentario {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private int codigo;
    private String descripcion;
    private Date fechaCreacion;
    private String estado;
}
