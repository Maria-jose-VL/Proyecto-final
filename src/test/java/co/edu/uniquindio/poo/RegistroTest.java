package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RegistroTest {
@Test
    public void placaIgual(){
        Parqueadero parqueadero = new Parqueadero("Estacionamiento", 20);
        Propietario propietario = new Propietario("Juan", "Perez", 20, "32345422", "1014393391","juan@uq.com" );
        Vehiculo vehiculo1 = new Vehiculo("GFU-411","2023" , propietario ){};
        
        parqueadero.agregarVehiculoPorPuesto(vehiculo1, 1,1);
        Propietario propietario2 = new Propietario("c", "p", 19, "123123", "21412312", "jadsas@edq.com");
        Vehiculo vehiculo2= new Vehiculo("GFU-411", "2022", propietario2) {};
        assertThrows(Throwable.class, ()-> parqueadero.agregarVehiculoPorPuesto(vehiculo2, 1, 1));
        }
}