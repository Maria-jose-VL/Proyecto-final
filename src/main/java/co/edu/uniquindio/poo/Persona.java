package co.edu.uniquindio.poo;

public abstract class Persona {
    private String nombre;
    protected String apellido;
    private String telefono;
    private String identificacion;
    public Persona(String nombre, String apellido, String telefono, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.identificacion = identificacion;
    }
}