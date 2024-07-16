package Course_vj.Academy.Foro_Hub.dominio.autor.Usuario;



public record DatosListadoUsuario(
        Long id,
        String título,
        String mensaje,
        String fecha_de_creación,
        String autor
) {
    public DatosListadoUsuario(Usuarios usuario){
        this(usuario.getId(), usuario.getTitulo(), usuario.getMensaje(), usuario.getFecha_de_creacion(), usuario.getAutor().getNombre());
    }
}
