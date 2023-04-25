package co.edu.uniquindio.unimarket.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SesionDTO {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
