package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10, nullable = false)
    private String cedula;
    @Column(length = 100, nullable = false)
    private String nombreCompleto;
    @Column(length = 20)
    private String numeroTelefono;
    @Column(length = 50, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String nombreUsuario;
    @Column(length = 50, nullable = false, unique = true)
    private String contrasena;
    @Column(length = 20)
    private String estado;
}
