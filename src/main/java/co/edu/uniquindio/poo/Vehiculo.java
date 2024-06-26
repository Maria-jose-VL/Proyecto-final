package co.edu.uniquindio.poo;

public abstract class Vehiculo {

    private final String placa;
    private final String modelo;
    private final Propietario Propietario;

    /**
     * Cosntructor de la clase vehiculo
     */

    public Vehiculo(String placa, String modelo, Propietario propietario) {
        /**
         * aserciones para poder hacer los test de la clase Vehiculo
         */
        assert placa != null && !placa.isBlank() : "La placa no puede ser nulo ni vacío";
        assert modelo != null && !modelo.isBlank() : "El modelo no puede ser nulo ni vacío";

        this.placa = placa;
        this.modelo = modelo;
        Propietario = propietario;
    }

    /**
     * Métodos get y set de la clase Vehiculo
     */
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return Propietario;
    }

    public abstract double getTarifa();

    public abstract void setTarifa(double tarifa);

}