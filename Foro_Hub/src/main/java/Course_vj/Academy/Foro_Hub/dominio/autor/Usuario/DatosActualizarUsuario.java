package Course_vj.Academy.Foro_Hub.dominio.autor.Usuario;

import Course_vj.Academy.Foro_Hub.dominio.autor.Autor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        @Valid
        Autor autor
) {
}
