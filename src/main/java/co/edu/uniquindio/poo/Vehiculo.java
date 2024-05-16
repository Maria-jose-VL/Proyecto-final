package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario Propietario;

    public Vehiculo(String placa, String modelo,Propietario propietario) {
        assert placa != null && !placa.isBlank(): "La placa no puede ser nulo ni vacío";
        assert modelo != null && !modelo.isBlank(): "El modelo no puede ser nulo ni vacío";

        this.placa = placa;
        this.modelo = modelo;
        Propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return Propietario;
    }
    
}