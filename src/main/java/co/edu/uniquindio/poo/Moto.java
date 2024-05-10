package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {

    public Moto(String placa, String modelo,Propietario propietario, int tarifaMotoClasica,
            int tarifaMotoHibrida, int tarifacarro) {
        super(placa, modelo, propietario);
    }

    @Override
    public double calcularTarifaVehiculo() {
        
        return tarifaMotoClasica;
    }
}