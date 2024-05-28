package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {

    private final LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private final Vehiculo vehiculo;

    /**
     * Constructor de la clase Registro
     */

    public Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo) {
        /**
         * Asersiones para poder hacer los test de la clase Registro
         */

        assert fechaEntrada != null : "La fecha de entrada no puede ser nula";

        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.vehiculo = vehiculo;

    }

    /**
     * Método para clacular el tiempo que estuvo estacionado un vehiculo
     */

    public int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long horas = tiempo.toHours();
        if (tiempo.toMinutes() > 0 && tiempo.toMinutes() < 60) {
            horas = 1; // Si estuvo menos de una hora, se cobra una hora completa
        }
        return (int) horas;
    }

    /**
     * Método para clacular el precio de la tarifa para cualquier vehiculo
     */

    public double calcularTarifa() {
        int tiempoEstacionado = calcularTiempo(fechaEntrada, fechaSalida);
        double tarifaPorHora = vehiculo.getTarifa();
        return tiempoEstacionado * tarifaPorHora;
    }

    /**
     * Métodos get y set de la clase Registro
     */
    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}