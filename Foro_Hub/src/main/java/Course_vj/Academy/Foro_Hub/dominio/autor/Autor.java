package Course_vj.Academy.Foro_Hub.dominio.autor;

import jakarta.persistence.Embeddable;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    private String nombre;
    private String email;
    @Enumerated(EnumType.STRING)
    private Facultad facultad;


    public Autor(DatosAutor autor) {
        this.nombre = autor.nombre();
        this.email = autor.email();
        this.facultad = autor.facultad();

    }


    public Autor(String nombre) {
        this.nombre = nombre;

    }

    public void actualizarNombre(String nombre) {
        this.nombre = nombre;

    }
}
