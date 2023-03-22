package co.edu.uniquindio.unimarket.servicios;

public interface EmailServicio {
    String enviarMensaje(String asunto, String cuerpo, String para);
}
