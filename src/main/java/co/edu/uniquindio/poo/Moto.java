package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private final double velocidadMaxima;
    private final TipoMoto tipoMoto;
    private static double tarifaClasica;
    private static double tarifaHibrida;

    /**
     * Constructor de la clase
     */

    public Moto(String placa, String modelo, Propietario propietario, double velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);
        /**
         * asersiones para hacer los test de la clase Moto
         */
        assert velocidadMaxima > 0 : "La velacidad máxima debe ser mayor a cero";
        assert tipoMoto != null : "El tipo de moto debe ser diferente de nulo";

        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;

        /**
         * Métodos get de la clase Moto
         */
    }

    @Override
    public double getTarifa() {
        if (tipoMoto == TipoMoto.MOTO_CLASICA) {
            return tarifaClasica;
        } else {
            return tarifaHibrida;
        }
    }

    @Override
    public void setTarifa(double tarifa) {
        /**
         * asersiones para hacer los test de la clase Moto
         */
        assert tarifa >= 0 : "La tarifa debe ser mayor a cero";
        if (tipoMoto == TipoMoto.MOTO_CLASICA) {
            Moto.tarifaClasica = tarifa;
        } else {
            Moto.tarifaHibrida = tarifa;
        }

    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
}