package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepo extends JpaRepository<Direccion, Integer> {
    @Query("SELECT d FROM Direccion d WHERE d.usuario.cedula = :cedulaUsuario")
    List<Direccion> getDireccionUsuario(String cedulaUsuario);
}
