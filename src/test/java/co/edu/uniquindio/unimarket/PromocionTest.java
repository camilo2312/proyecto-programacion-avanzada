package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.PromocionDTO;
import co.edu.uniquindio.unimarket.dto.PromocionGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Promocion;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.PromocionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class PromocionTest {
    @Autowired
    private PromocionServicio promocionServicio;
    @Autowired
    private ProductoServicio productoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPromocion() {
        try {
            ProductoGetDTO productoGetDTO = productoServicio.obtenerProducto(4);
            List<ProductoGetDTO> lstProductos = new ArrayList<>();
            lstProductos.add(productoGetDTO);
            PromocionDTO promocionDTO = new PromocionDTO(
                    10,
                    "Freidoras al 10%",
                    LocalDate.now(),
                    LocalDate.now().plusDays(30),
                    lstProductos
            );

            int codigo = promocionServicio.crearPromocion(promocionDTO);

            Assertions.assertNotEquals(0, codigo);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPromocion() {
        try {
            PromocionGetDTO promocion = promocionServicio.obtenerPromocion(1);
            promocion.setNombre("Nuevas promos");

            PromocionDTO promocionDTO = new PromocionDTO(
                    promocion.getPorcentajeDescuento(),
                    promocion.getNombre(),
                    promocion.getFechaInicio(),
                    promocion.getFechaFin(),
                    promocion.getLstProductos()
            );

            int codigo = promocionServicio.actualizarPromocion(promocionDTO);

            Assertions.assertNotEquals(2, codigo);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPromocion() {
        try {
            boolean respuesta = promocionServicio.eliminarPromocion(5);

            Assertions.assertEquals(true, respuesta);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPromocion() {
        try {
            PromocionGetDTO promocionGetDTO = promocionServicio.obtenerPromocion(3);

            Assertions.assertEquals(20.0, promocionGetDTO.getPorcentajeDescuento());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
