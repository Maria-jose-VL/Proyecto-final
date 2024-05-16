package co.edu.uniquindio.poo;
import java.time.Duration;
import java.time.LocalDateTime;

public record Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo ) {
    public int 
    calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long horas = tiempo.toHours();
        return (int) horas ;
    }
} 