package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@AllArgsConstructor
public class UsuarioController {
    @Autowired
    private final UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {
        String cedula = usuarioServicio.registrarUsuario(usuarioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false,
                "Cliente " + cedula + " creado exitosamente"));
    }
    @PutMapping("/{cedula}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable String cedula, @Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {

        String cedulaActualizada = usuarioServicio.actualizarUsuario(cedula, usuarioDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false,
                "Cliente " + cedula + " actualizado exitosamente"));
    }
    @GetMapping("/{cedula}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(String cedula) throws Exception{
        return  ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false,
                usuarioServicio.obtenerUsuario(cedula)));
    }
    @GetMapping
    public ResponseEntity<MensajeDTO> obtenerUsuarios() throws Exception {
        return  ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK, false,
                usuarioServicio.obtenerUsuarios()
        ));
    }
}
