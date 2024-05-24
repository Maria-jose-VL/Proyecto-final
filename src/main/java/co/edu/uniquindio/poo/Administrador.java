package co.edu.uniquindio.poo;

public class Administrador extends Persona {

    public Administrador(String nombres, String apellidos, Byte edad, String telefono, String identificacion,
            String correo) {
        super(nombres, apellidos, edad, telefono, identificacion, correo);
        //TODO Auto-generated constructor stub
        
    }
        /**
     * Método para cambiar el precio de la tarifa de cada vehiculo
     */
    public void cambiarTarifa(Vehiculo vehiculo, double tarifa){
        vehiculo.setTarifa(tarifa);
    }
}