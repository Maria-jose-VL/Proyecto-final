/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertTrue(true);
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }
    @Test
    public void shouldAnswerWithFalse() {
        LOG.info("Hola");
        assertFalse(false);
        LOG.info("Chao");
    }
   /**  @Test
    public void testVerificarDisponibilidad() {
        Parqueadero parqueadero = new Parqueadero("p", 10);
        Propietario propietario = new Propietario("Juan", "Perez", 20, "32345422", "1014393391","juan@uq.com" );
        Vehiculo vehiculo = new Vehiculo("gfu-411", "2023", propietario);
        parqueadero.agregarVehiculoPorPuesto(vehiculo, 0, 0);
        Vehiculo vehiculo2 = new Vehiculo("gfu-411", "2023", propietario);
        assertThrows(Throwable.class, ()-> parqueadero.agregarVehiculoPorPuesto(new Vehiculo(null, null, propietario),0, 0)); // El puesto (0,0) debería estar disponible inicialmente
    }**/
}

