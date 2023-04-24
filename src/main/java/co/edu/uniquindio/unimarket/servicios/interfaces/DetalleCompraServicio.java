package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;

import java.util.List;

public interface DetalleCompraServicio {
    int crearDetalleCompra(int codigoCompra, DetalleCompraDTO detalleCompraDTO) throws Exception;
    List<DetalleCompraGetDTO> obtenerDetallesPorCompra(int codigoCompra) throws Exception;

    List<DetalleCompraGetDTO> trasnformarLista(List<DetalleCompra> lstDetallesCompra);

}
