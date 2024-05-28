package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    @Test
    public void agregarVehiculoPorPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 100);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121", " jua@uq.com");
        Carro carro = new Carro("ABC123", "2020", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuesto(1, 1));
    }

    @Test
    public void eliminarVehiculoPorPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 100);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121", " jua@uq.com");
        Carro carro = new Carro("ABC123", "2020", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuesto(1, 1));
        parqueadero.eliminarVehiculoPorPuesto(1, 1, LocalDateTime.now().plusHours(1));

    }

    @Test
    public void agregarVehiculoInvalidoPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 10);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121", " jua@uq.com");
        Carro carro = new Carro("ABC123", "2020", propietario);
        assertThrows(Throwable.class, () -> parqueadero.agregarVehiculoPorPuesto(carro, 11, 11));
    }

    @Test
    public void eliminarVehiculoInvalidoPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 10);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121", " jua@uq.com");
        Carro carro = new Carro("ABC123", "2020", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertThrows(Throwable.class, () -> parqueadero.eliminarVehiculoPorPuesto(1, 2, LocalDateTime.now()));
    }

    @Test
    public void testGetVehiculos() {
        Parqueadero parqueadero = new Parqueadero("parqueadero", 100);
        Propietario propietario = new Propietario("Juan", "Rod", 21, "123141", "124121", " jua@uq.com");
        Carro carro = new Carro("ABC123", "2020", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(1, parqueadero.getVehiculos().size());
        assertTrue(parqueadero.getVehiculos().contains(carro));

    }

    @Test
    public void tamanioDelParqueadero() {

        Parqueadero parqueadero = new Parqueadero("parqueadero", 10);
        assertEquals(100, parqueadero.getPuestos().size());

    }

    @Test
    public void obtenerPropietarioPorPuesto() {

        Parqueadero parqueadero = new Parqueadero("parqueadero", 5);
        Propietario propietario1 = new Propietario("Maria jose", "Valencia", 19, "2878212", "83728372",
                "majo@gmail.com");
        Carro carro = new Carro("AJHS77", "carro", propietario1);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        assertEquals(propietario1, parqueadero.obtenerPropietarioPorPuesto(1, 1));
    }

    @Test
    public void obtenerPropietarioPorPuestoSinVehiculo() {

        Parqueadero parqueadero = new Parqueadero("parkeando", 5);
        assertThrows(Throwable.class, () -> parqueadero.obtenerPropietarioPorPuesto(2, 2));

    }

    @Test
    public void agregarDiferentesVehiculos() {

        Parqueadero parqueadero = new Parqueadero("parqueadero", 5);
        Propietario propietario1 = new Propietario("Maria jose", "Valencia", 19, "2878212", "83728372",
                "majo@gmail.com");
        Propietario propietario2 = new Propietario("Juan", "Ramirez", 20, "2328372", "283283", "juan@gmail.com");
        Propietario propietario3 = new Propietario("Jorge", "cifuentes", 24, "2837822", "3827382", "jorge@gmail.com");
        Carro carro = new Carro("AJHS77", "carro", propietario1);
        Moto motoClasica = new Moto("SDS288", "motoClasica", propietario2, 150, TipoMoto.MOTO_CLASICA);
        Moto motoHibrida = new Moto("DJ44SS", "motoHibrida", propietario3, 250, TipoMoto.MOTO_HIBRIDA);
        assertEquals(true, parqueadero.verificarPuesto(1, 4));
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 4);
        assertEquals(false, parqueadero.verificarPuesto(1, 4));
        assertEquals(true, parqueadero.verificarPuesto(2, 1));
        parqueadero.agregarVehiculoPorPuesto(motoClasica, 2, 1);
        assertEquals(false, parqueadero.verificarPuesto(2, 1));
        assertEquals(true, parqueadero.verificarPuesto(3, 2));
        parqueadero.agregarVehiculoPorPuesto(motoHibrida, 3, 2);
        assertEquals(false, parqueadero.verificarPuesto(3, 2));

    }

    @Test
    public void Agregar2vehiculosA1puesto() {

        Parqueadero parqueadero = new Parqueadero("parqueadero", 5);
        Propietario propietario1 = new Propietario("Maria jose", "Valencia", 19, "2878212", "83728372",
                "majo@gmail.com");
        Propietario propietario2 = new Propietario("Juan", "Ramirez", 20, "2328372", "283283", "juan@gmail.com");
        Propietario propietario3 = new Propietario("Jorge", "cifuentes", 24, "2837822", "3827382", "jorge@gmail.com");
        Carro carro = new Carro("AJHS77", "carro", propietario1);
        Moto motoClasica = new Moto("SDS288", "motoClasica", propietario2, 150, TipoMoto.MOTO_CLASICA);
        Moto motoHibrida = new Moto("DJ44SS", "motoHibrida", propietario3, 250, TipoMoto.MOTO_HIBRIDA);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 3);
        parqueadero.agregarVehiculoPorPuesto(motoClasica, 3, 2);
        assertEquals(false, parqueadero.verificarPuesto(1, 3));
        assertEquals(false, parqueadero.verificarPuesto(3, 2));
        assertThrows(Throwable.class, () -> parqueadero.agregarVehiculoPorPuesto(motoHibrida, 3, 2));

    }

    @Test
    public void totalApagarLuegoDeXhoras() {

        Parqueadero parqueadero = new Parqueadero("parqueadero", 5);
        Administrador administrador = new Administrador("valeria", "lopez", (byte) 30, "3843878743", "4983894",
                "vale@gmail.com");
        Propietario propietario1 = new Propietario("Maria jose", "Valencia", 19, "2878212", "83728372",
                "majo@gmail.com");
        Propietario propietario2 = new Propietario("Juan", "Ramirez", 20, "2328372", "283283", "juan@gmail.com");
        Propietario propietario3 = new Propietario("Jorge", "cifuentes", 24, "2837822", "3827382", "jorge@gmail.com");
        Carro carro = new Carro("AJHS77", "carro", propietario1);
        Moto motoClasica = new Moto("SDS288", "motoClasica", propietario2, 150, TipoMoto.MOTO_CLASICA);
        Moto motoHibrida = new Moto("DJ44SS", "motoHibrida", propietario3, 250, TipoMoto.MOTO_HIBRIDA);
        administrador.cambiarTarifa(carro, 5000.0);
        administrador.cambiarTarifa(motoClasica, 3000.0);
        administrador.cambiarTarifa(motoHibrida, 4000.0);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        parqueadero.agregarVehiculoPorPuesto(motoClasica, 2, 2);
        parqueadero.agregarVehiculoPorPuesto(motoHibrida, 3, 3);
        parqueadero.eliminarVehiculoPorPuesto(1, 1, LocalDateTime.now().plusHours(8));
        parqueadero.eliminarVehiculoPorPuesto(2, 2, LocalDateTime.now().plusHours(8));
        parqueadero.eliminarVehiculoPorPuesto(3, 3, LocalDateTime.now().plusHours(8));
        LocalDate fecha = LocalDate.now();
        List<Double> reporteDiarioEsperado = List.of(40000.0, 24000.0, 32000.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);
        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

    }

    @Test
    public void reporteMensual() {

        Parqueadero parqueadero = new Parqueadero("parqueadero", 5);
        Administrador administrador = new Administrador("valeria", "lopez", (byte) 30, "3843878743", "4983894",
                "vale@gmail.com");
        Propietario propietario1 = new Propietario("Maria jose", "Valencia", 19, "2878212", "83728372",
                "majo@gmail.com");
        Propietario propietario2 = new Propietario("Juan", "Ramirez", 20, "2328372", "283283", "juan@gmail.com");
        Propietario propietario3 = new Propietario("Jorge", "cifuentes", 24, "2837822", "3827382", "jorge@gmail.com");
        Carro carro = new Carro("AJHS77", "carro", propietario1);
        Moto motoClasica = new Moto("SDS288", "motoClasica", propietario2, 150, TipoMoto.MOTO_CLASICA);
        Moto motoHibrida = new Moto("DJ44SS", "motoHibrida", propietario3, 250, TipoMoto.MOTO_HIBRIDA);
        administrador.cambiarTarifa(carro, 5000.0);
        administrador.cambiarTarifa(motoClasica, 3000.0);
        administrador.cambiarTarifa(motoHibrida, 4000.0);
        parqueadero.agregarVehiculoPorPuesto(carro, 1, 1);
        parqueadero.agregarVehiculoPorPuesto(motoClasica, 2, 2);
        parqueadero.agregarVehiculoPorPuesto(motoHibrida, 3, 3);
        parqueadero.eliminarVehiculoPorPuesto(1, 1, LocalDateTime.now().plusDays(1));
        parqueadero.eliminarVehiculoPorPuesto(2, 2, LocalDateTime.now().plusHours(8));
        parqueadero.eliminarVehiculoPorPuesto(3, 3, LocalDateTime.now().plusMonths(1));
        YearMonth mes = YearMonth.now();
        assertEquals(3120000.0, parqueadero.generarReporteMensual(mes));

    }
}
