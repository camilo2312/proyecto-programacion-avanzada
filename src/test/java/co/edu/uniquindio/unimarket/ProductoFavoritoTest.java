package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoFavoritoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ProductoFavoritoTest {
    @Autowired
    private ProductoFavoritoServicio productoFavoritoServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearFavoritosUsuario() {
        try {
            boolean respuesta = productoFavoritoServicio.crearFavoritosUsuario(new FavoritoDTO(
                    "1094923724",
                    1
            ));

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFavoritoUsuario() {
        try {
            boolean respuesta = productoFavoritoServicio.eliminarFavoritoUsuario(new FavoritoDTO(
                    "1094923724",
                    1
            ));

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
