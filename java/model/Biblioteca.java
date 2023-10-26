package model;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private String horarioAtencion;

    public Biblioteca(String nombre, String direccion, String horarioAtencion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horarioAtencion = horarioAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }
}