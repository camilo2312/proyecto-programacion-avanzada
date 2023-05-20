package co.edu.uniquindio.unimarket.seguridad.servicios;
import co.edu.uniquindio.unimarket.modelo.entidades.Moderador;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo clienteRepo;
    @Autowired
    private ModeradorRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario cliente = clienteRepo.findByEmail(email);
        if(cliente == null){
            Moderador admin = adminRepo.findByEmail(email);
            if(admin == null)
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(admin);
        }else{
            return UserDetailsImpl.build(cliente);
        }
    }
}