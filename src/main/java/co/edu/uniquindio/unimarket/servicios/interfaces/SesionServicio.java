package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO session);

    void logout(int codigoUsuario);
}
