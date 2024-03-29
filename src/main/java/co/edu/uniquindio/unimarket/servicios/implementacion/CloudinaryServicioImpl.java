package co.edu.uniquindio.unimarket.servicios.implementacion;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class CloudinaryServicioImpl implements CloudinaryServicio {
    private final Cloudinary cloudinary;
    public CloudinaryServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dajsnzdgb");
        config.put("api_key", "747236412539794");
        config.put("api_secret", "raxX6SwPsoJnWCmK3_Irpr2nCZI");
        cloudinary = new Cloudinary(config);
    }
    @Override
    public Map subirImagen(File file, String carpeta) throws Exception{

        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                String.format("uniquindio/unimarket/%s", carpeta)));
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception{
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
    @Override
    public File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}

