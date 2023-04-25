package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.DireccionDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DireccionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/direccion")
@AllArgsConstructor
public class DireccionController {
    private final DireccionServicio direccionServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> crearDireccion(@Valid @RequestBody DireccionDTO direccionDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                direccionServicio.crearDireccion(direccionDTO)
        ));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> actualizarDireccion(@PathVariable int codigo, @Valid @RequestBody DireccionDTO direccionDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                direccionServicio.actualizarDireccion(codigo, direccionDTO)
        ));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> eliminarDireccion(@PathVariable int codigo) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                direccionServicio.eliminarDireccion(codigo)
        ));
    }
}
