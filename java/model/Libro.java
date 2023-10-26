package model;

public class Libro {
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private String genero;
    private String bilbioteca;

    public Libro(String titulo, String autor, String fechaPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBilbioteca() {
        return bilbioteca;
    }

    public void setBilbioteca(String bilbioteca) {
        this.bilbioteca = bilbioteca;
    }

    public String toString(){
        return "Titulo: "+titulo+"\nAutor: "+autor+"\nFecha publicación: "+fechaPublicacion+"\nGénero: "+genero;
    }
}