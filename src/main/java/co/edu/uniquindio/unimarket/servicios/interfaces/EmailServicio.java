package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface EmailServicio {
    String enviarMensaje(String asunto, String cuerpo, String para);
}
