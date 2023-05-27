package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    private final EmailServicio emailServicio;
    @Override
    // Método que permite crear un comentario
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario nuevoComentario = new Comentario();
        Usuario usuario = new Usuario();
        Usuario vendedor = new Usuario();
        Producto producto = new Producto();
        int codigoComentario = 0;
        String mensajeCorreo = "";

        usuario = usuarioServicio.obtenerUsuarioBD(comentarioDTO.getCedulaUsuario());

        if (usuario != null) {
            producto = productoServicio.obtenerProductoBD(comentarioDTO.getCodigoProducto());
            if (producto != null) {
                nuevoComentario.setDescripcion(comentarioDTO.getDescripcion());
                nuevoComentario.setFechaCreacion(LocalDate.now());
                nuevoComentario.setUsuario(usuario);
                nuevoComentario.setProducto(producto);

                codigoComentario = comentarioRepo.save(nuevoComentario).getCodigo();

                if (codigoComentario > 0) {
                    vendedor = usuarioServicio.obtenerUsuarioBD(producto.getVendedor().getCedula());
                    mensajeCorreo = "El usuario " + usuario.getNombreCompleto() + " realizó un comentario sobre su producto " +
                            producto.getNombre() + ", el comentario fue el siguiente: \n";
                    mensajeCorreo += comentarioDTO.getDescripcion();

                    emailServicio.enviarEmail(new EmailDTO(
                            "Comentario de productos",
                            mensajeCorreo,
                            vendedor.getEmail()
                    ));
                }
            } else {
                throw  new Exception("El producto no existe");
            }
        } else {
            throw  new Exception("El usuario no existe");
        }


        return codigoComentario;
    }

    @Override
    // Método que permite listar los comentarios de un producto dado su código
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {
        List<Comentario> lstComentarios = comentarioRepo.getComentariosPorProducto(codigoProducto);
        List<ComentarioGetDTO> lstComentariosDTO = new ArrayList<>();

        if (lstComentarios != null && lstComentarios.size() > 0)
        {
            lstComentarios.forEach(comentario -> {
                lstComentariosDTO.add(transformarComentario(comentario));
            });
        }
        return lstComentariosDTO;
    }

    private ComentarioGetDTO transformarComentario(Comentario comentario) {
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getDescripcion(),
                comentario.getFechaCreacion(),
                comentario.getProducto().getCodigo(),
                comentario.getUsuario().getCedula(),
                comentario.getUsuario().getNombreCompleto());
        return comentarioGetDTO;
    }
}
