package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {
    ComentarioDTO crearComentario(ComentarioDTO comentarioDTO);
    List<ComentarioGetDTO> listarComentarios(int codigoProducto);
}
