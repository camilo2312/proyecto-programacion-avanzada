package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    // Consultas JPQL = lenguaje de consultas para JPA
    // @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    // Usuario buscarUsuarioEmail(String email);
    Usuario findByEmail(String email);
}
