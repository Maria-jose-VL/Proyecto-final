package co.edu.uniquindio.poo;

public class Puesto {

    private final int posicionI;
    private final int posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;

    public Puesto(int posicionI, int posicionJ, Estado estado) {
        
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.estado = estado;
    }
    public int getPosicionI() {
        return posicionI;
    }
    public int getPosicionJ() {
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