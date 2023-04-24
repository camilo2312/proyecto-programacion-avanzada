package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;

import java.util.List;

public interface ProductoFavoritoServicio {
    // Método que permite asociar productos favoritos del usuario
    boolean crearFavoritosUsuario(FavoritoDTO favoritoDTO) throws Exception;
    // Método que permite eliminar un producto favorito de la lista del usuario
    boolean eliminarFavoritoUsuario(FavoritoDTO favoritoDTO) throws Exception;
}
