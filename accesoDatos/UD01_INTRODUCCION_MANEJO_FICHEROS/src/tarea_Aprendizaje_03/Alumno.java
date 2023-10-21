package tarea_Aprendizaje_03;

import java.io.Serializable;
import java.time.LocalDate;

public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre, apellido;
    private LocalDate fecha_nac;
    private int telefono;

    public Alumno() { }

    public Alumno(String nombre, String apellido, LocalDate fecha_nac, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
