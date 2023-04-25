package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionRepo extends JpaRepository<Promocion, Integer> {
    @Query("SELECT p FROM Promocion p WHERE :producto member of p.productos")
    Promocion obtenerPromocionPorProducto(Producto producto);
    @Query("SELECT p FROM Promocion p JOIN Producto pr ON p.codigo = pr.promocion.codigo WHERE p.codigo = :codigoPromocion")
    Promocion obtenerPromocion(int codigoPromocion);
}
