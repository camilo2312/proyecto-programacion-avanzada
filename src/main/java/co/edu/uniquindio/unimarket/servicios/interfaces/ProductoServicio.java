package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;

import java.util.List;

public interface ProductoServicio {
    int crearProducto(ProductoDTO productoDTO);
    int eliminarProducto(int codigoProducto);
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);
    int actualizarPorEstado(int codigoProducto, Estado estado);
    int actualizarPorCantidad(int codigoProducto, int cantidad);
    ProductoGetDTO obtenerProducto(int codigoProducto);
    List<ProductoGetDTO> listarProductosPorCategoria(int codigoCategoria);
    List<ProductoGetDTO> listarProductoUsuario(String cedulaUsuario);
    List<ProductoGetDTO> listarProductoFavUsuario(String cedulaUsuario);
    List<ProductoGetDTO> listarProductoPrecios(double precioMin, double precioMax);
}
