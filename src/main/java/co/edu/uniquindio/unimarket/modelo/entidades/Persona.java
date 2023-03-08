package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10, nullable = false)
    private String cedula;
    private String nombreCompleto;
    @Column(length = 20)
    private String numeroTelefono;
    private String email;
    private String nombreUsuario;
    private String contrasena;
    private String estado;
}
