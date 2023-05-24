package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.ImagenDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
public class ProductoTest {
    @Autowired
    private ProductoServicio productoServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto() {
        try {
            List<ImagenDTO> lstImagenes = new ArrayList<>();
            lstImagenes.add(new ImagenDTO("1", "https://w0.peakpx.com/wallpaper/132/121/HD-wallpaper-goku-perron-en-dios-anime-dragon-ball-ssj-ssj-dios.jpg"));
            List<Categoria> lstCategorias = new ArrayList<>();
            lstCategorias.add(Categoria.Juegos);
            ProductoDTO productoDTO = new ProductoDTO(
                    "Producto de prueba",
                    "Es un producto creado desde el test",
                    150000,
                    20,
                    "1098123651",
                    lstImagenes,
                    lstCategorias
            );

            int codigo = productoServicio.crearProducto(productoDTO);

            Assertions.assertNotEquals(0, codigo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProducto() {
        try {
            int codigo = productoServicio.eliminarProducto(3);

            Assertions.assertEquals(3, codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProducto() {
        try {
            Producto producto = productoServicio.obtenerProductoBD(3);
            producto.setPrecio(800000);

            ProductoDTO productoDTO = new ProductoDTO(
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getDisponibilidad(),
                    producto.getVendedor().getCedula(),
                    null,
                    producto.getLstCategorias()
            );

            int codigo = productoServicio.actualizarProducto(3, productoDTO);

            Assertions.assertEquals(3, codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPorEstado() {
        try {
            int codigo = productoServicio.actualizarPorEstado(3, Estado.RECHAZADO);

            Assertions.assertEquals(3, codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProducto() {
        try {
            ProductoGetDTO productoGetDTO = productoServicio.obtenerProducto(1);

            Assertions.assertNotNull(productoGetDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosPorCategoria() {
        try {
            List<ProductoGetDTO> lstProductos = productoServicio.listarProductosPorCategoria(Categoria.Juegos);

            Assertions.assertNotEquals(0, lstProductos.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductoUsuario() {
        try {
            List<ProductoGetDTO> lstProductos = productoServicio.listarProductoUsuario("1094936382");

            Assertions.assertNotEquals(0, lstProductos.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductoFavUsuario() {
        try {
            List<ProductoGetDTO> lstProductos = productoServicio.listarProductoFavUsuario("1094936382");

            Assertions.assertNotEquals(0, lstProductos.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductoPrecios() {
        try {
            List<ProductoGetDTO> lstProductos = productoServicio.listarProductoPrecios(100000, 300000);

            Assertions.assertNotEquals(0, lstProductos.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosPorNombre() {
        try {
            List<ProductoGetDTO> lstProductos = productoServicio.listarProductosPorNombre("Nevera");

            Assertions.assertNotEquals(0, lstProductos.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
