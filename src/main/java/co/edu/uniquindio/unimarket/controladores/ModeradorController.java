package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/moderador")
@RestController
@AllArgsConstructor
public class ModeradorController {
    private final ModeradorServicio moderadorServicio;
    @GetMapping("/aprobar-rechazar-producto/{codigoProducto}/{estado}")
    public ResponseEntity<MensajeDTO> aprobarRechazarProducto(@PathVariable int codigoProducto, @PathVariable Estado estado) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                moderadorServicio.aprobarRechazarProducto(codigoProducto, estado)
        ));
    }
}
