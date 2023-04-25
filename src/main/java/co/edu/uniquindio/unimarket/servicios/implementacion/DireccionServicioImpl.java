package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.DireccionDTO;
import co.edu.uniquindio.unimarket.dto.DireccionGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Direccion;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.DireccionRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DireccionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DireccionServicioImpl implements DireccionServicio {
    private final DireccionRepo direccionRepo;
    private final UsuarioServicio usuarioServicio;
    // Método que permite crear una dirección en la base de datos
    @Override
    public int crearDireccion(DireccionDTO direccionDTO) throws  Exception{
        Direccion nuevaDireccion = new Direccion();
        Usuario usuario = usuarioServicio.obtenerUsuarioBD(direccionDTO.getCedulaUsuario());
        if (usuario != null) {
            nuevaDireccion.setDescripcion(direccionDTO.getDescripcion());
            nuevaDireccion.setCodigoPostal(direccionDTO.getCodigoPostal());
            nuevaDireccion.setUsuario(usuario);

            return direccionRepo.save(nuevaDireccion).getCodigo();
        }

        throw new Exception("El usuario identificado con " + direccionDTO.getCedulaUsuario() + " no exist en la base de datos");
    }

    // Método que permite actualizar el registro de una dirección
    @Override
    public int actualizarDireccion(int codigoDireccion, DireccionDTO direccionDTO) throws Exception {
        Direccion direccion = obtenerDireccionBD(codigoDireccion);
        if (direccion != null) {
            direccion.setCodigo(codigoDireccion);
            direccion.setDescripcion(direccionDTO.getDescripcion());
            direccion.setCodigoPostal(direccionDTO.getCodigoPostal());

            return direccionRepo.save(direccion).getCodigo();
        }

        return 0;
    }

    // Método que permite eliminar una dirección de la base de datos
    @Override
    public boolean eliminarDireccion(int codigoDireccion) throws Exception{
        Direccion direccion = obtenerDireccionBD(codigoDireccion);
        if (direccion != null) {
            direccionRepo.delete(direccion);
            return true;
        }

        return  false;
    }

    // Método que permite obtener las direcciones asociadas a un usuario
    @Override
    public List<DireccionGetDTO> obtenerDireccionUsuario(String cedulaUsuario) throws Exception {
        List<DireccionGetDTO> lstRespuestaDirecciones = new ArrayList<>();
        List<Direccion> lstDirecciones = (List<Direccion>) direccionRepo.getDireccionUsuario(cedulaUsuario);

        if (lstDirecciones != null && lstDirecciones.size() > 0) {
            lstDirecciones.forEach(direccion -> {
                lstRespuestaDirecciones.add(transformarDireccion(direccion));
            });
        }

        return lstRespuestaDirecciones;
    }

    // Método que permite obtener una dirección de la base de datos
    @Override
    public Direccion obtenerDireccionBD(int codigoDireccion) throws Exception {
        Optional<Direccion> direccion = direccionRepo.findById(codigoDireccion);
        if (direccion.isEmpty()) {
            throw new Exception("La dirección asociada al código " + codigoDireccion + " no existe");
        }

        return direccion.get();
    }

    // Método que permite transformar una dirección en una dirección DTO
    public DireccionGetDTO transformarDireccion(Direccion direccion) {
        DireccionGetDTO direccionGetDTO = new DireccionGetDTO(
                direccion.getCodigo(),
                direccion.getDescripcion(),
                direccion.getCodigoPostal(),
                direccion.getUsuario().getCedula()
        );

        return direccionGetDTO;
    }


}
