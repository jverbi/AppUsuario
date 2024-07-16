package Course_vj.Academy.Foro_Hub.dominio.autor.Usuario;

import Course_vj.Academy.Foro_Hub.dominio.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="usuarios")
@Entity (name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha_de_creacion;
    private String status;
    @Embedded
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Usuarios(DatosUsurios datosUsuarios) {
        this.titulo = datosUsuarios.titulo();
        this.mensaje = datosUsuarios.mensaje();
        this.fecha_de_creacion = datosUsuarios.fecha_de_creacion();
        this.status = datosUsuarios.status();
        this.autor = new Autor(datosUsuarios.autor());
        this.curso = datosUsuarios.curso();
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        if(datosActualizarUsuario.titulo() != null){
            this.titulo = datosActualizarUsuario.titulo();
        }

        if(datosActualizarUsuario.mensaje() != null){
            this.mensaje = datosActualizarUsuario.mensaje();
        }


        if (this.autor != null) {
            this.autor.actualizarNombre(datosActualizarUsuario.autor().getNombre());
        }
    }
}

