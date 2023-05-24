package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class LoginController {
    private final UsuarioServicio usuarioServicio;
    private final SesionServicio sesionServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarCliente(@Valid @RequestBody UsuarioDTO
                                                               cliente) throws Exception {
        usuarioServicio.registrarUsuario(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Usuario creado correctamente"));
    }

    @GetMapping("/reestablecerContrasena/{email}")
    public ResponseEntity<MensajeDTO> reestablecerContrasena(@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                usuarioServicio.reestablecerContrasena(email)));
    }
}
