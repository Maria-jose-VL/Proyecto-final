package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    // Es esatatica ya que se cambiaron todas las tarifas de las instancias de carro
    private static double tarifa;

    public Carro(String placa, String modelo, Propietario propietario) {
        super(placa, modelo, propietario);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double getTarifa() {

        return tarifa;
    }

    @Override
    public void setTarifa(double tarifa) {
        assert tarifa >= 0;
        Carro.tarifa = tarifa;

    }
}