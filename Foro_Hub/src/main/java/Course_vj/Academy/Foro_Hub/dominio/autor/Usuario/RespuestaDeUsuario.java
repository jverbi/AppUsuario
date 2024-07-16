package Course_vj.Academy.Foro_Hub.dominio.autor.Usuario;

import Course_vj.Academy.Foro_Hub.dominio.autor.Autor;


public record RespuestaDeUsuario(

        String titulo,

        String mensaje,

        String fecha_de_creacion,

        String status,


        Autor autor,

        Curso curso
) {


}
