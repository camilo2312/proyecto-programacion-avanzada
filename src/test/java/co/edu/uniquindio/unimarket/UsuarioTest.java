package co.edu.uniquindio.unimarket;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
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
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuarioTest() {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "100",
                    "Pepe",
                    "pepe@gmail.com",
                    "3116789000",
                    "pepeperez",
                    "1234",
                    Estado.ACTIVO);
            String cedulaUsuario = usuarioServicio.registrarUsuario(usuarioDTO);

            Assertions.assertNotEquals("", cedulaUsuario);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuario() {
        try {
            UsuarioGetDTO usuario = usuarioServicio.obtenerUsuario("1094923724");
            usuario.setNombreCompleto("Pepe Perez Lopez");

            String cedulaActualizada = usuarioServicio.actualizarUsuario(usuario.getCedula(), new UsuarioDTO(
                    usuario.getCedula(),
                    usuario.getNombreCompleto(),
                    usuario.getEmail(),
                    usuario.getNumeroTelefono(),
                    usuario.getNombreUsuario(),
                    usuario.getContrasena(),
                    usuario.getEstado()
            ));

            usuario = usuarioServicio.obtenerUsuario(cedulaActualizada);

            Assertions.assertNotEquals("Daniel Esteban Tusarma Guerrero", usuario.getNombreCompleto());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuario() {
        try {
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario("1094923724");

            Assertions.assertEquals("d4n73l", usuarioGetDTO.getContrasena());
        } catch (Exception exception){
            exception.printStackTrace();
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuarios() {
        try {
            List<UsuarioGetDTO> lstUsuarios = usuarioServicio.obtenerUsuarios();

            Assertions.assertNotEquals(0, lstUsuarios.size());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarContrasena() {
        try {
            boolean respuesta = usuarioServicio.cambiarContrasena("juanc.ramosr@uqvirtual.com", "1234");

            Assertions.assertTrue(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
