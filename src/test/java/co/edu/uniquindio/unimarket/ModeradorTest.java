package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ModeradorTest {
    @Autowired
    private ModeradorServicio moderadorServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void aprobarRechazarProducto() {
        try {
            boolean respuesta = moderadorServicio.aprobarRechazarProducto(3, Estado.INACTIVO);

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
