package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

/*import co.edu.uniquindio.poo.parqueadero.Estado;
import co.edu.uniquindio.poo.parqueadero.Moto;
import co.edu.uniquindio.poo.parqueadero.Moto.TipoMoto;
import co.edu.uniquindio.poo.parqueadero.Parqueadero;
import co.edu.uniquindio.poo.parqueadero.Puesto;
import co.edu.uniquindio.poo.parqueadero.Registro;
import co.edu.uniquindio.poo.parqueadero.Vehiculo;*/

public class ParqueaderoTest {

    @Test
    public void agregarVehiculoPorPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 100);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121"," jua@uq.com" );
        Carro carro = new Carro("ABC123","2020" , propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuesto(1, 1));  
    }

    @Test
    public void eliminarVehiculoPorPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 100);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121"," jua@uq.com" );
        Carro carro = new Carro("ABC123","2020" , propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuesto(1, 1));
        parqueadero.eliminarVehiculoPorPuesto(1, 1, LocalDateTime.now().plusHours(1));
       
    }

    @Test
    public void testAddVehiculoInvalidPuesto() {
    Parqueadero parqueadero = new Parqueadero("parqueadero", 10);
    Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121"," jua@uq.com" );
    Carro carro = new Carro("ABC123","2020" , propietario);
        assertThrows(Throwable.class, () -> parqueadero.agregarVehiculoPorPuesto(carro, 11, 11));
    }

    @Test
    public void testRemoveVehiculoInvalidPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 10);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121"," jua@uq.com" );
        Carro carro = new Carro("ABC123","2020" , propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertThrows(Throwable.class, () -> parqueadero.eliminarVehiculoPorPuesto(1, 2, LocalDateTime.now()));
    }

    @Test
    public void testGetVehiculos() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 100);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121"," jua@uq.com" );
        Carro carro = new Carro("ABC123","2020" , propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(1, parqueadero.getVehiculos().size());
        assertTrue(parqueadero.getVehiculos().contains(carro));

    }
}