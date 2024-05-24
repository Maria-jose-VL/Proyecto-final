package co.edu.uniquindio.poo;



public class Propietario extends Persona {
    public Propietario(String nombres, String apellidos, int edad, String telefono, String identificacion,
            String correo) {
                
        super(nombres, apellidos, edad, telefono, identificacion, correo);
        //TODO Auto-generated constructor stub
        assert edad > 15 : "La edad debe ser mayor a 15";
    }
}