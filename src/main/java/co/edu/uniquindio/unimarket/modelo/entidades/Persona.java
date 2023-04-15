package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
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
    @Column(length = 100, unique = true)
    private String email;
    @Column(length = 20, nullable = false, unique = true)
    private String nombreUsuario;
    @Column(length = 50, nullable = false, unique = true)
    private String contrasena;
    @Column(length = 20)
    private String estado;
}
