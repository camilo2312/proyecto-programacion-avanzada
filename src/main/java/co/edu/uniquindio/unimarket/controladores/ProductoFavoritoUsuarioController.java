package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DireccionDTO;
import co.edu.uniquindio.unimarket.dto.FavoritoDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoFavoritoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/productos-favoritos")
@AllArgsConstructor
public class ProductoFavoritoUsuarioController {
    private final ProductoFavoritoServicio productoFavoritoServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> crearFavoritosUsuario(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                productoFavoritoServicio.crearFavoritosUsuario(favoritoDTO)
        ));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> crearFavoritosUsuario(@PathVariable int codigo, @Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoFavoritoServicio.eliminarFavoritoUsuario(favoritoDTO)
        ));
    }
}
