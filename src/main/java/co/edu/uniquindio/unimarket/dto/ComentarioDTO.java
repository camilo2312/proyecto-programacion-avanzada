package co.edu.uniquindio.unimarket.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

public class ComentarioDTO {
    private String descripcion;
    private int codigoProducto;
    private String cedulaUsuario;
}
