package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.PromocionGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;

import java.util.List;

public interface ProductoServicio {
    // Método que permite crear un producto
    int crearProducto(ProductoDTO productoDTO) throws Exception;
    // Método que permite eliminar un producto de la base de datos dado su código
    int eliminarProducto(int codigoProducto) throws Exception;
    // Método que permite actualizar un registro de un producto de la base de datos
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;
    // Método que permite actualizar el estado de un producto
    int actualizarPorEstado(int codigoProducto, Estado estado) throws Exception;
    // Método que permite obtener un producto mediante su codigo
    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    // Método que permite obtener de la base de datos un producto dado su código sin transformar
    Producto obtenerProductoBD(int codigoProducto) throws Exception;
    // Método que permite obtener una lista de productos por una categoria
    List<ProductoGetDTO> listarProductosPorCategoria(Categoria categoria) throws Exception;
    // Método que permite obtener una lista de categorias por vendedor
    List<ProductoGetDTO> listarProductoUsuario(String cedulaUsuario) throws Exception;
    // Método que permite obtener los productos favoritos de un usuario
    List<ProductoGetDTO> listarProductoFavUsuario(String cedulaUsuario) throws Exception;
    // Método que permite obtener una lista de productos dado un rango de precios
    List<ProductoGetDTO> listarProductoPrecios(double precioMin, double precioMax) throws Exception;
    // Método que permite obtener una lista de productos dado su nombre
    List<ProductoGetDTO> listarProductosPorNombre(String nombre);
    List<ProductoGetDTO> transformarListaProductos(List<Producto> productos);
    int obtenerDisponibilidadProducto(int codigo);
}
