package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;

import java.util.List;

public interface CompraServicio {
    int crearCompra(CompraDTO compraDTO);

    CompraGetDTO obtenerCompra(int codigoCompra);
    List<CompraGetDTO> listarCompraUsuario(String cedulaUsuario);
}
