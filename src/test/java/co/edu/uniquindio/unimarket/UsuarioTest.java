package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    public void registrarUsuarioTest() {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("100", "Pepe", "pepe@gmail.com", "3116789000", "pepeperez", "1234");
            usuarioServicio.registrarUsuario(usuarioDTO);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
