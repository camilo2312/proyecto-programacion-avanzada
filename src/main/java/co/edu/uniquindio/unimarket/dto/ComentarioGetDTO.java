package co.edu.uniquindio.unimarket.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class ComentarioGetDTO {
    private int codigo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private int codigoProducto;
    private String cedulaUsuario;
}
