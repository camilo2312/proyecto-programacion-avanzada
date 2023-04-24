package co.edu.uniquindio.unimarket.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ComentarioGetDTO {
    private int codigo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private int codigoProducto;
    private String cedulaUsuario;
}
