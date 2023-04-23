package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.EstadoCompra;

import java.util.List;

public interface CompraServicio {
    int crearCompra(CompraDTO compraDTO) throws Exception;
    CompraGetDTO obtenerCompra(int codigoCompra) throws Exception;
    Compra obtenerCompraBD(int codigoCompra) throws Exception;
    List<CompraGetDTO> listarCompraUsuario(String cedulaUsuario) throws Exception;
    List<CompraGetDTO> listarComprasPorEstado(EstadoCompra estadoCompra) throws Exception;
}
