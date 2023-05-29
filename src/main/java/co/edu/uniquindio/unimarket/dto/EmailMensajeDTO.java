package co.edu.uniquindio.unimarket.dto;

public class EmailMensajeDTO {
    public String mensajeCompra = "" +
            "<div style=\"margin: auto 30%;\n" +
            "  background: #fff;\n" +
            "  border-radius: 4px;\n" +
            "  font-family: sans-serif;\">\n" +
            "  <h3 style=\"text-align: center;\n" +
            "  background-color: #3b96c8;\n" +
            "  padding: 1%;\n" +
            "  border-radius: 4px 4px 0px 0px;\n" +
            "  color: #fff;\">!Compra de productos!</h3>\n" +
            "  <h5 style=\"text-align: center;\">{0} </h5>\n" +
            "  \n {1}" +
            "  \n" +
            "  <h4>Total pagado: {2}</h4>\n" +
            "</div>";

    public String tabla =
            "<table style=\"padding: 2%;\n" +
            "  border: 1px solid gray;\n" +
            "  border-radius: 4px;\n" +
            "  margin: 2% auto;\n" +
            "  width: 100%;\">\n" +
            "    <thead>\n" +
            "      <tr>\n" +
            "        <th style=\"text-align:left\">Producto</th>\n" +
            "        <th style=\"text-align:right\">Cantidad</th>\n" +
            "        <th style=\"text-align:right\">Precio</th>\n" +
            "      </tr>\n" +
            "    </thead>\n" +
            "    <tbody>\n{0}</tbody>\n" +
            "  </table>";

    public String mensajeUsuario = "Señor(a) {0} usted realizó la compra de los siguientes productos: \n";
    public String mensajeVendedor = "El usuario {0} realizó la compra de los siguientes productos: \n";
}
