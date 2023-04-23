package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    @Override
    // Método que permite crear un comentario
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setDescripcion(comentarioDTO.getDescripcion());
        nuevoComentario.setUsuario(usuarioServicio.obtenerUsuarioBD(comentarioDTO.getCedulaUsuario()));
        nuevoComentario.setProducto(productoServicio.obtenerProductoBD(comentarioDTO.getCodigoProducto()));

        return comentarioRepo.save(nuevoComentario).getCodigo();
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
                comentario.getUsuario().getCedula());
        return comentarioGetDTO;
    }
}
