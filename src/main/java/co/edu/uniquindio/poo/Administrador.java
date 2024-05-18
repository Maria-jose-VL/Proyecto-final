package co.edu.uniquindio.poo;

public class Administrador extends Persona {

    public Administrador(String nombres, String apellidos, Byte edad, String telefono, String identificacion,
            String correo) {
        super(nombres, apellidos, edad, telefono, identificacion, correo);
        //TODO Auto-generated constructor stub
    }
    public void cambiarTarifa(Vehiculo vehiculo, double tarifa){
        if( vehiculo instanceof Carro){
            vehiculo.setTarifa(tarifa);
        }
        else if(vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            if(moto.getTipoMoto()==TipoMoto.MOTO_HIBRIDA){
                vehiculo.setTarifa(tarifa);
            }
            else {
                vehiculo.setTarifa(tarifa);
            }
        }

    }
}