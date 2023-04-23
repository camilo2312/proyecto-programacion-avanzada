package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    // Método que permite obtener los productos por una categoria
    @Query("SELECT p FROM Producto p WHERE :categoria member of p.lstCategorias")
    List<Producto> getProductosPorCategoria(Categoria categoria);
    // Método que permite obtener los productos de un vendedor
    @Query("SELECT p FROM Producto p WHERE p.vendedor.cedula = :cedulaUsuario")
    List<Producto> getProductosPorUsuario(String cedulaUsuario);
    // Método que permite obtener los productos favoritos de un usuario
    @Query("SELECT p FROM Producto  p WHERE :usuario member of p.lstUsuariosProductosFavoritos")
    List<Producto> getProductosFavoritos(Usuario usuario);
    // Método que permite obtener productos por un rango de precios
    @Query("SELECT p FROM Producto p WHERE p.precio >= :precioMinimo AND p.precio <= :precioMaximo")
    List<Producto> getProductosPorRangoPrecio(double precioMinimo, double precioMaximo);
    @Query("SELECT p FROM Producto p WHERE p.nombre like concat('%', :nombre, '%') AND p.estado = 'ACEPTADO' ")
    List<Producto> getProductosPorNombre(String nombre);
}
