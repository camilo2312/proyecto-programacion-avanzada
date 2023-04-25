package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.DireccionDTO;
import co.edu.uniquindio.unimarket.dto.DireccionGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Direccion;
import co.edu.uniquindio.unimarket.servicios.interfaces.DireccionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class DireccionTest {
    @Autowired
    private DireccionServicio direccionServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearDireccion() {
        try {
            int codigoDireccion = direccionServicio.crearDireccion(new DireccionDTO(
                    "Calle 10 #10-05",
                    7080,
                    "1094923724"
            ));

            Assertions.assertNotEquals(0, codigoDireccion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarDireccion() {
        try {
            Direccion direccion = direccionServicio.obtenerDireccionBD(20);
            direccion.setDescripcion("Cricasia");
            int codigo = direccionServicio.actualizarDireccion(20, new DireccionDTO(
                    direccion.getDescripcion(),
                    direccion.getCodigoPostal(),
                    direccion.getUsuario().getCedula()
            ));

            Assertions.assertEquals(0, codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarDireccion() {
        try {
            boolean resultado = direccionServicio.eliminarDireccion(25);

            Assertions.assertNotEquals(true, resultado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDireccionesPorUsuario() {
        try {
            List<DireccionGetDTO> lstDirecciones = direccionServicio.obtenerDireccionUsuario("1099233413");

            Assertions.assertNotEquals(0, lstDirecciones.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
