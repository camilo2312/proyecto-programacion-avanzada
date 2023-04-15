package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepo usuarioRepo;
    @Override
    public String registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuarioBuscado = usuarioRepo.findByEmail(usuarioDTO.getEmail());

        if (usuarioBuscado != null) {
            throw new Exception("El correo ingresado ya existe");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula(usuarioDTO.getCedula());
        nuevoUsuario.setNombreCompleto(usuarioDTO.getNombreCompleto());
        nuevoUsuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        nuevoUsuario.setContrasena(usuarioDTO.getContrasena());
        nuevoUsuario.setEmail(usuarioDTO.getEmail());
        nuevoUsuario.setNumeroTelefono(usuarioDTO.getNumeroTelefono());

        return usuarioRepo.save(nuevoUsuario).getCedula();
    }

    @Override
    public String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception {

        Usuario usuario = obtenerUsuarioBD(cedula);
        usuario.setNombreCompleto(usuarioDTO.getNombreCompleto());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNumeroTelefono(usuarioDTO.getNumeroTelefono());

        return usuarioRepo.save(usuario).getCedula();
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(String cedula) throws Exception {
        return transformarUsuario(obtenerUsuarioBD(cedula));
    }

    private Usuario obtenerUsuarioBD(String cedula) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(cedula);

        if (usuario.isEmpty()) {
            throw new Exception("El usuario con el código " + cedula + " no existe");
        }

        return usuario.get();
    }
    private UsuarioGetDTO transformarUsuario(Usuario usuario) {
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO(usuario.getCedula(), usuario.getNombreCompleto(), usuario.getEmail(), usuario.getNumeroTelefono(), usuario.getContrasena());
        return usuarioGetDTO;
    }
}
