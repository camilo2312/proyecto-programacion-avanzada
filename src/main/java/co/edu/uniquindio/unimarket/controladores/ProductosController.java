package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/productos")
@AllArgsConstructor
public class ProductosController {
    private final ProductoServicio productoServicio;
    @PostMapping
    public ResponseEntity<MensajeDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                productoServicio.crearProducto(productoDTO)
        ));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int codigo) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                productoServicio.eliminarProducto(codigo)
        ));
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigo, @Valid @RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.actualizarProducto(codigo, productoDTO)
        ));
    }
    @PutMapping("/{estado}")
    public ResponseEntity<MensajeDTO> actualizarProductoEstado(@PathVariable Estado estado, @PathVariable int codigo) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                HttpStatus.CREATED,
                false,
                productoServicio.actualizarPorEstado(codigo, estado)
        ));
    }
    @GetMapping("/{codigoProducto}/{estado}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int codigoProducto, @PathVariable Estado estado) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.actualizarPorEstado(codigoProducto, estado)
        ));
    }
    @GetMapping("/{categoria}")
    public ResponseEntity<MensajeDTO> listarProductosPorCategoria(@PathVariable Categoria categoria) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.listarProductosPorCategoria(categoria)
        ));
    }
    @GetMapping("/{cedula}")
    public ResponseEntity<MensajeDTO> listarProductoUsuario(@PathVariable String cedula) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.listarProductoUsuario(cedula)
        ));
    }
    @GetMapping("/favoritos/{cedula}")
    public ResponseEntity<MensajeDTO> listarProductoFavUsuario(@PathVariable String cedula) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.listarProductoFavUsuario(cedula)
        ));
    }
    @GetMapping("/{preciomin}/{preciomax}")
    public ResponseEntity<MensajeDTO> listarProductoPrecios(@PathVariable double preciomin, @PathVariable double preciomax) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.listarProductoPrecios(preciomin, preciomax)
        ));
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<MensajeDTO> listarProductosPorNombre(@PathVariable String nombre) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                productoServicio.listarProductosPorNombre(nombre)
        ));
    }
}
