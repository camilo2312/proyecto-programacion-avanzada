package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.Moderador;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
public class DireccionGetDTO {
    private int codigo;
    private String descripcion;
    private int codigoPostal;
    private String cedulaUsuario;
}
