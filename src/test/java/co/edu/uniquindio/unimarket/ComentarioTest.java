package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioTest {
    @Autowired
    private ComentarioServicio comentarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentario() {
        try {
            int codigo = comentarioServicio.crearComentario(new ComentarioDTO(
                    "Buen producto",
                    1,
                    "1101237842"
            ));

            Assertions.assertNotEquals(0, codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosPorProducto() {
        try {
            List<ComentarioGetDTO> lstComentarios = comentarioServicio.listarComentarios(3);

            Assertions.assertEquals(1, lstComentarios.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
