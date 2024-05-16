package co.edu.uniquindio.poo;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class RegistroTest {
@Test
    public void calcularHora(){

        LocalDateTime fechaEntrada = LocalDateTime.of( 2024, 5, 15, 8, 30);
        LocalDateTime fechaSalida = LocalDateTime.of(2024, 5, 15, 10, 30);

        int tiempoEstacionado = Registro.calcularTiempo(fechaEntrada, fechaSalida);

    }
}