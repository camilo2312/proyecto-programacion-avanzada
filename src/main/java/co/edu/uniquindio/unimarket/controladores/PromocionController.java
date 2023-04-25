package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.PromocionDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.PromocionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/promocion")
@AllArgsConstructor
public class PromocionController {
    private final PromocionServicio promocionServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> crearPromocion(@Valid @RequestBody PromocionDTO promocionDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                promocionServicio.crearPromocion(promocionDTO)
        ));
    }
    @PutMapping("/{codigoPromocion}")
    public ResponseEntity<MensajeDTO> actualizarPromocion(@PathVariable int codigoPromocion, @Valid @RequestBody PromocionDTO promocionDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                promocionServicio.actualizarPromocion(codigoPromocion, promocionDTO)
        ));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> eliminarPromocion(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                promocionServicio.eliminarPromocion(codigo)
        ));
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> obtenerPromocion(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                promocionServicio.obtenerPromocion(codigo)
        ));
    }

}
