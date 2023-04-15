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
public class Usuario extends Persona implements Serializable {
    @Column
    private int puntosAcumulados;
    @OneToMany(mappedBy = "usuario")
    private List<Direccion> direcciones;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "vendedor")
    private List<Producto> productos;
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;
    @ManyToMany(mappedBy = "lstUsuariosProductosFavoritos")
    private List<Producto> lstProductosFavoritos;


}
