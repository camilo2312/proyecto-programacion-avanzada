package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(length = 100)
    private String nombre;
    @Column(length = 200)
    private String descripcion;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private int disponibilidad;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @Column(nullable = false)
    private LocalDate fechaPublicacion;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @ToString.Exclude
    private List<Categoria> lstCategorias;
    @ElementCollection
    @ToString.Exclude
    private Map<String, String> lstImages;
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentarios;
    @ManyToOne
    @ToString.Exclude
    private Usuario vendedor;
    @ManyToOne
    @ToString.Exclude
    private Promocion promocion;
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<DetalleCompra> detallesCompra;
    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "Favoritos")
    private List<Usuario> lstUsuariosProductosFavoritos;
    @ManyToMany
    @JoinTable(name = "Moderador_Producto")
    private List<Moderador> lstModeradores;

}
