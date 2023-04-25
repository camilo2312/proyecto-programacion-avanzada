package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class CompraTest {
    @Autowired
    private CompraServicio compraServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompra() {
        try {

            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO(
                    5,
                    10000,
                    1
            );

            List<DetalleCompraDTO> detalleCompraDTOS = new ArrayList<>();
            detalleCompraDTOS.add(detalleCompraDTO);

            CompraDTO compraDTO = new CompraDTO(
                    MedioPago.EFECTIVO,
                    "1094923724",
                    500000,
                    detalleCompraDTOS
            );

            int codigoCompra = compraServicio.crearCompra(compraDTO);

            Assertions.assertTrue(codigoCompra > 0);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompra() {
        try {
            CompraGetDTO compraGetDTO = compraServicio.obtenerCompra(1);

            Assertions.assertNotNull(compraGetDTO);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCompraUsuario() {
        try {
            List<CompraGetDTO> lstCompras = compraServicio.listarCompraUsuario("1094923724");

            Assertions.assertTrue(lstCompras.size() > 0);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasPorEstado() {
        try {
            List<CompraGetDTO> lstCompras = compraServicio.listarComprasPorEstado(EstadoCompra.APROBADA);

            Assertions.assertTrue(lstCompras.size() > 0);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
