package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.EmailDTO;
import lombok.*;


public interface EmailServicio {
    void enviarEmail(EmailDTO emailDTO) throws Exception;
}
