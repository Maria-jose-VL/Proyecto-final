package co.edu.uniquindio.poo;

public class Puesto {
    private final String posicionI;
    private final String posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;
    public Puesto(String posicionI, String posicionJ, Estado estado) {
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.estado = estado;
    }
    public String getPosicionI() {
        return posicionI;
    }
    public String getPosicionJ() {
        return posicionJ;
    }
    public Estado getEstado() {
        return estado;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


}