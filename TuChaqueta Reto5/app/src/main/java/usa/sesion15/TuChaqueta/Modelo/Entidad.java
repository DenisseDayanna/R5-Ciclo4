package usa.sesion15.TuChaqueta.Modelo;

public class Entidad {

    String imagen;
    String titulo;
    String descripcion;

    public Entidad(String imagen, String titulo, String descripcion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
