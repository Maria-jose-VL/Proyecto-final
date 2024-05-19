package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private final double velocidadMaxima;
    private final TipoMoto tipoMoto;

        /**
     * Constructor de la clase
     */

    public Moto(String placa, String modelo,Propietario propietario,double velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);
            /**
     * asersiones para hacer los test de la clase Moto
     */
        assert velocidadMaxima >0: "La velacidad máxima debe ser mayor a cero";
        assert tipoMoto != null: "El tipo de moto debe ser diferente de nulo";

        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto= tipoMoto;
        
            /**
     * Métodos get de la clase Moto
     */
    }
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
}