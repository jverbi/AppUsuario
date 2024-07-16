package Course_vj.Academy.Foro_Hub.controller;


import Course_vj.Academy.Foro_Hub.dominio.autor.Autor;
import Course_vj.Academy.Foro_Hub.dominio.autor.Usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



import java.net.URI;
import java.util.Optional;




@RestController
@RequestMapping("/topicos")
public class ForoHubController {

    @Autowired
    private TopicosRepository topicosRepository;

    @PostMapping
    public ResponseEntity registroUsuarios(@RequestBody @Valid DatosUsurios datosUsuarios, UriComponentsBuilder uriComponentsBuilder) {
        Usuarios usuarios = topicosRepository.save(new Usuarios(datosUsuarios));
        RespuestaDeUsuario respuestaDeUsuario = new RespuestaDeUsuario(
                usuarios.getTitulo(),
                usuarios.getMensaje(),
                usuarios.getFecha_de_creacion(),
                usuarios.getStatus(),
                new Autor(
                        usuarios.getAutor().getNombre(),
                        usuarios.getAutor().getEmail(),
                        usuarios.getAutor().getFacultad()
                ),

                usuarios.getCurso()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(usuarios.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaDeUsuario);


    }

    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuario(Pageable paginacion) {
        return topicosRepository.findAll(paginacion).map(DatosListadoUsuario::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarUsuario(@PathVariable Long id, @RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {

        //Codigo sin verificacion si el topico existe o no:
        //Usuarios usuarios = topicosRepository.getReferenceById(datosActualizarUsuario.id());
        //usuarios.actualizarDatos(datosActualizarUsuario);

        Optional<Usuarios> usuariosOpcional = topicosRepository.findById(id);
        if (usuariosOpcional.isPresent()) {
            Usuarios usuarios = usuariosOpcional.get();
            usuarios.actualizarDatos(datosActualizarUsuario);
            topicosRepository.save(usuarios);
            RespuestaDeUsuario respuesta = new RespuestaDeUsuario(
                    usuarios.getTitulo(),
                    usuarios.getMensaje(),
                    usuarios.getFecha_de_creacion(),
                    usuarios.getStatus(),
                    new Autor(
                            usuarios.getAutor().getNombre(),
                            usuarios.getAutor().getEmail(),
                            usuarios.getAutor().getFacultad()
                    ),
                    usuarios.getCurso()
            );
            return ResponseEntity.ok(respuesta);
        } else {
            throw new IllegalArgumentException("No se encontró el usuario con ID: " + id);
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        //Usuarios usuarios = topicosRepository.getReferenceById(id);
        //topicosRepository.delete(usuarios);

       Optional<Usuarios> eliminarUsuarioOpcional = topicosRepository.findById(id);
        if(eliminarUsuarioOpcional.isPresent()){
            topicosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            throw new IllegalArgumentException("No se encontró el usuario con ID: " + id);
        }

    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity retornarUsuario(@PathVariable Long id) {
        Usuarios usuarios = topicosRepository.getReferenceById(id);
        topicosRepository.delete(usuarios);
        RespuestaDeUsuario datosDelUsuario = new RespuestaDeUsuario(
                usuarios.getTitulo(),
                usuarios.getMensaje(),
                usuarios.getFecha_de_creacion(),
                usuarios.getStatus(),
                new Autor(
                        usuarios.getAutor().getNombre(),
                        usuarios.getAutor().getEmail(),
                        usuarios.getAutor().getFacultad()
                ),

                usuarios.getCurso()
        );
        return ResponseEntity.ok(datosDelUsuario);

    }
}

