package co.edu.uniquindio.poo;

public class Administrador extends Persona {
    private double tarifaMotoClasica;
    private double tarifaMotoHibrida;
    private double tarifaCarro;

    public Administrador(String nombre, String apellido, String telefono, String identificacion,
                         double tarifaMotoClasica, double tarifaMotoHibrida, double tarifaCarro) {
        super(nombre, apellido, telefono, identificacion);
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMotoHibrida;
        this.tarifaCarro = tarifaCarro;
    }

    // Getters y setters para los atributos de tarifa
    public double getTarifaMotoClasica() {
        return tarifaMotoClasica;
    }

    public void setTarifaMotoClasica(double tarifaMotoClasica) {
        this.tarifaMotoClasica = tarifaMotoClasica;
    }

    public double getTarifaMotoHibrida() {
        return tarifaMotoHibrida;
    }

    public void setTarifaMotoHibrida(double tarifaMotoHibrida) {
        this.tarifaMotoHibrida = tarifaMotoHibrida;
    }

    public double getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(double tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }
}
