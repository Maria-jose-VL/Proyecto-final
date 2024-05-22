package co.edu.uniquindio.poo;

public abstract class Persona {
    
    private final String nombres;
    private final String apellidos;
    private final int edad; 
    private final String telefono;
    private final String identificacion;
    private final String correo;

        /**
     * Constructor de la clase Persona
     */

    public Persona(String nombres, String apellidos, int edad, String telefono, String identificacion, String correo) {

    /**
     * Asersiones para poder hacer los test de la clase Persona
     */

        assert nombres != null && !nombres.isBlank(): "Los nombres no pueden ser nulos ni vacíos";
        assert apellidos != null && !apellidos.isBlank(): "Los apellidos no pueden ser nulos ni vacíos";
        assert edad >0: "La edad debe ser mayor a cero";
        assert telefono != null && !telefono.isBlank(): "El telefono no puede ser nulo ni vacío";
        assert identificacion != null && !identificacion.isBlank(): "La identificación no puede ser nulo ni vacío";
        assert correo != null && !correo.isBlank(): "El correo no puede ser nulo ni vacío";

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.correo = correo;
  
    }

            /**
     * Métodos get de la clase persona
     */

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }
}