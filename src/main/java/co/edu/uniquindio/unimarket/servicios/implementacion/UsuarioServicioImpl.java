package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    // Método que permite realizar el registro de un usuario
    public String registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula(usuarioDTO.getCedula());
        nuevoUsuario.setNombreCompleto(usuarioDTO.getNombreCompleto());
        nuevoUsuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        nuevoUsuario.setContrasena(passwordEncoder.encode(usuarioDTO.getContrasena()));
        nuevoUsuario.setEmail(usuarioDTO.getEmail());
        nuevoUsuario.setNumeroTelefono(usuarioDTO.getNumeroTelefono());
        nuevoUsuario.setEstado(Estado.ACTIVO);

        return usuarioRepo.save(nuevoUsuario).getCedula();
    }

    @Override
    // Método que permite actualizar la información de un usuario
    public String actualizarUsuario(String cedula, UsuarioDTO usuarioDTO) throws Exception {

        Usuario usuario = obtenerUsuarioBD(cedula);
        usuario.setNombreCompleto(usuarioDTO.getNombreCompleto());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNumeroTelefono(usuarioDTO.getNumeroTelefono());
        usuario.setEstado(usuarioDTO.getEstado());

        return usuarioRepo.save(usuario).getCedula();
    }

    @Override
    // Método que permite obtener un usuario mediante su cédula
    public UsuarioGetDTO obtenerUsuario(String cedula) throws Exception {
        return transformarUsuario(obtenerUsuarioBD(cedula));
    }


    @Override
    // Método que permite obtener la lista de usuarios registrados
    public List<UsuarioGetDTO> obtenerUsuarios() throws Exception {
        List<Usuario> lstUsuarios = usuarioRepo.findAll();
        List<UsuarioGetDTO> lstReturnUsuarios = new ArrayList<>();

        if (lstUsuarios != null && lstUsuarios.size() > 0)
        {
            lstUsuarios.forEach(usuario -> {
                lstReturnUsuarios.add(transformarUsuario(usuario));
            });
        }

        return lstReturnUsuarios;
    }

    @Override
    // Método que permite actualizar la lista de favoritos del usuario
    public boolean crearProductoFavoritoUsuario(Usuario usuario) throws Exception {
        return usuarioRepo.save(usuario).getCedula().equals("");
    }

    @Override
    // Método que permite cambiar la contraseña del usuario
    public boolean cambiarContrasena(String identificacionUsuario, String nuevaContrasena) throws Exception {
        Usuario usuario = usuarioRepo.obtenerUsuarioCorreoNombreUsuario(identificacionUsuario);

        if (usuario != null) {
            usuario.setContrasena(passwordEncoder.encode(nuevaContrasena));
            usuarioRepo.save(usuario);
            return true;
        }

        throw new Exception("El usuario identificado con " + identificacionUsuario + " no existe en la base de datos");
    }

    // Método que permite obtener un usuario de la base de datos
    public Usuario obtenerUsuarioBD(String cedula) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(cedula);

        if (usuario.isEmpty()) {
            throw new Exception("El usuario con el código " + cedula + " no existe");
        }

        return usuario.get();
    }

    /* Método que permite realizar la transformación de un usuario de tipo
       Usuario a un usuario de tipo UsuarioGetDTO
     */
    private UsuarioGetDTO transformarUsuario(Usuario usuario) {
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO(
                usuario.getCedula(),
                usuario.getNombreCompleto(),
                usuario.getEmail(),
                usuario.getNumeroTelefono(),
                usuario.getContrasena(),
                usuario.getNombreUsuario(),
                usuario.getEstado(),
                new ArrayList<>());
        return usuarioGetDTO;
    }
}
