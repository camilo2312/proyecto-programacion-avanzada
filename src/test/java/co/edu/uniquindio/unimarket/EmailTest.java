package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class EmailTest {

    @Autowired
    private EmailServicio emailServicio;
    @Test
    public void enviarCorreo() {
        try {
            emailServicio.enviarEmail(new EmailDTO(
                "Correo de prueba unitaria",
                    "Correo que se ejecuto desde la prueba unitaria",
                    "camiramos234@gmail.com"
            ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
