package Course_vj.Academy.Foro_Hub.dominio.autor.Usuario;


import Course_vj.Academy.Foro_Hub.dominio.autor.DatosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsurios(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fecha_de_creacion,
        @NotBlank
        String status,
        @NotNull
        @Valid
        DatosAutor autor,
        @NotNull
        Curso curso
) {
}
