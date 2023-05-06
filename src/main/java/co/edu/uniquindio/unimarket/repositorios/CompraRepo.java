package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
    @Query("SELECT c FROM Compra c WHERE c.usuario.cedula = :cedulaUsuario")
    List<Compra> obtenerListaComprasPorUsuario(String cedulaUsuario);
    @Query("SELECT c FROM Compra c WHERE c.estado = :estadoCompra")
    List<Compra> obtenerListaComprasPorEstado(EstadoCompra estadoCompra);

    @Query("SELECT SUM(c.precioTotal) FROM Compra c WHERE YEAR(c.fechaCreacion) = :anio AND MONTH(c.fechaCreacion) = :mes")
    double obtenerTotalVentasDadoMesAnio(int anio, int mes);
}
