package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/direccion")
@AllArgsConstructor
public class CompraController {
    private final CompraServicio compraServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> crearCompra(@Valid @RequestBody CompraDTO compraDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                compraServicio.crearCompra(compraDTO)
        ));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> obtenerCompra(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                compraServicio.obtenerCompra(codigo)
        ));
    }

    @GetMapping("/{cedulaUsuario}")
    public ResponseEntity<MensajeDTO> obtenerComprasUsuario(@PathVariable String cedulaUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                compraServicio.listarCompraUsuario(cedulaUsuario)
        ));
    }

    @GetMapping("/{estado}")
    public ResponseEntity<MensajeDTO> obtenerCompraEstado(@PathVariable EstadoCompra estado) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                compraServicio.listarComprasPorEstado(estado)
        ));
    }

}
