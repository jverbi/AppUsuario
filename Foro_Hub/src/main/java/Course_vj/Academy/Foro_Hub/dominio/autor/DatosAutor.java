package Course_vj.Academy.Foro_Hub.dominio.autor;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutor(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @Enumerated(EnumType.STRING)
        Facultad facultad
) {
}
