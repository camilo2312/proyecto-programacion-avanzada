package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoFavoritoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoFavoritoServicioImpl implements ProductoFavoritoServicio {

    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    @Override
    // Método que permite adicionar un producto favorito al usuario
    public boolean crearFavoritosUsuario(FavoritoDTO favoritoDTO) throws Exception{
        Usuario usuario = usuarioServicio.obtenerUsuarioBD(favoritoDTO.getCedulaUsuario());
        Producto producto = productoServicio.obtenerProductoBD(favoritoDTO.getCodigoProducto());
        if (!usuario.getLstProductosFavoritos().contains(producto)) {
            producto.getLstUsuariosProductosFavoritos().add(usuario);
            usuario.getLstProductosFavoritos().add(producto);
            return usuarioServicio.crearProductoFavoritoUsuario(usuario);
        }

        return false;
    }

    @Override
    public boolean eliminarFavoritoUsuario(FavoritoDTO favoritoDTO) throws Exception {
        Usuario usuario = usuarioServicio.obtenerUsuarioBD(favoritoDTO.getCedulaUsuario());
        Producto producto = productoServicio.obtenerProductoBD(favoritoDTO.getCodigoProducto());
        if (usuario.getLstProductosFavoritos().contains(producto)) {
            producto.getLstUsuariosProductosFavoritos().remove(usuario);
            usuario.getLstProductosFavoritos().remove(producto);
            return usuarioServicio.crearProductoFavoritoUsuario(usuario);
        }

        throw new Exception("EL producto con él código "+ favoritoDTO.getCodigoProducto() + " no esta en la lista de favoritos del usuario");
    }


}
