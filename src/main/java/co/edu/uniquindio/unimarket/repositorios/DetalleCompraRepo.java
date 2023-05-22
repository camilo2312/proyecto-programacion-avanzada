package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Integer> {
    @Query("SELECT d FROM DetalleCompra d WHERE d.compra.codigo = :codigoCompra")
    List<DetalleCompra> obtenerDetalleCompraPorCompra(int codigoCompra);

    @Query = ("SELECT c.nombre, COUNT(p) FROM Categoria c JOIN c.productos p GROUP BY c.nombre", Object[].class);

}
