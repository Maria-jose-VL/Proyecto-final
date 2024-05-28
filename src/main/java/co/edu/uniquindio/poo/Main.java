package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    private static Parqueadero parqueadero;
    private static Administrador administrador;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión del parqueadero.");

        System.out.print("Ingrese el nombre del parqueadero: ");
        String nombreParqueadero = scanner.nextLine();

        System.out.print("Ingrese el número de puestos del parqueadero: ");
        int numeroPuestos = scanner.nextInt();
<<<<<<< HEAD
        System.out.print("Asignar tarifa del carro");
       // int 
        scanner.nextLine(); // Consumir la nueva línea
=======
        scanner.nextLine(); // Consumir el salto de línea
>>>>>>> b143ccbe38da3770b8fe9a2eade436bb689f1c14

        parqueadero = new Parqueadero(nombreParqueadero, numeroPuestos);

        administrador = new Administrador("Admin", "Admin", (byte) 30, "123456789", "admin123", "admin@correo.com");

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarVehiculo(scanner);
                    break;
                case 2:
                    eliminarVehiculo(scanner);
                    break;
                case 3:
                    cambiarTarifa(scanner);
                    break;
                case 4:
                    generarReporteDiario(scanner);
                    break;
                case 5:
                    generarReporteMensual(scanner);
                    break;
                case 6:
                    obtenerPropietarioPorPuesto(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Eliminar vehículo");
        System.out.println("3. Cambiar tarifa");
        System.out.println("4. Generar reporte diario");
        System.out.println("5. Generar reporte mensual");
        System.out.println("6. Obtener propietario por puesto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarVehiculo(Scanner scanner) {
        System.out.print("Ingrese el tipo de vehículo (carro/moto): ");
        String tipoVehiculo = scanner.nextLine();

        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el nombre del propietario: ");
        String nombres = scanner.nextLine();

        System.out.print("Ingrese los apellidos del propietario: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese la edad del propietario: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el teléfono del propietario: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la identificación del propietario: ");
        String identificacion = scanner.nextLine();

        System.out.print("Ingrese el correo del propietario: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese la hora de entrada (AAAA-MM-DDTHH:MM): ");
        String fechaEntradaStr = scanner.nextLine();
        LocalDateTime fechaEntrada = LocalDateTime.parse(fechaEntradaStr);

        Propietario propietario = new Propietario(nombres, apellidos, edad, telefono, identificacion, correo);
        Vehiculo vehiculo;

        if (tipoVehiculo.equalsIgnoreCase("carro")) {
            vehiculo = new Carro(placa, modelo, propietario);
        } else if (tipoVehiculo.equalsIgnoreCase("moto")) {
            System.out.print("Ingrese la velocidad máxima de la moto: ");
            double velocidadMaxima = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Ingrese el tipo de moto (MOTO_CLASICA/MOTO_HIBRIDA): ");
            String tipoMotoStr = scanner.nextLine();
            TipoMoto tipoMoto = TipoMoto.valueOf(tipoMotoStr);

            vehiculo = new Moto(placa, modelo, propietario, velocidadMaxima, tipoMoto);
        } else {
            System.out.println("Tipo de vehículo no válido.");
            return;
        }

        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();

        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        try {
            parqueadero.agregarVehiculoPorPuesto(vehiculo, posicionI, posicionJ);
            System.out.println("Vehículo registrado exitosamente.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    private static void eliminarVehiculo(Scanner scanner) {
        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();

        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese la fecha y hora de salida (AAAA-MM-DDTHH:MM): ");
        String fechaSalidaStr = scanner.nextLine();
        LocalDateTime fechaSalida = LocalDateTime.parse(fechaSalidaStr);

        try {
            parqueadero.eliminarVehiculoPorPuesto(posicionI, posicionJ, fechaSalida);
            System.out.println("Vehículo eliminado exitosamente.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cambiarTarifa(Scanner scanner) {
        System.out.print("Ingrese el tipo de vehículo (carro/moto): ");
        String tipoVehiculo = scanner.nextLine();

        System.out.print("Ingrese la nueva tarifa: ");
        double tarifa = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        if (tarifa < 0) {
            System.out.println("La tarifa debe ser mayor o igual a cero.");
            return;
        }

        if (tipoVehiculo.equalsIgnoreCase("carro")) {
            administrador.cambiarTarifa(new Carro("dummy", "dummy", null), tarifa);
        } else if (tipoVehiculo.equalsIgnoreCase("moto")) {
            System.out.print("Ingrese el tipo de moto (MOTO_CLASICA/MOTO_HIBRIDA): ");
            String tipoMotoStr = scanner.nextLine();
            TipoMoto tipoMoto = TipoMoto.valueOf(tipoMotoStr);

            administrador.cambiarTarifa(new Moto("dummy", "dummy", null, 0, tipoMoto), tarifa);
        } else {
            System.out.println("Tipo de vehículo no válido.");
        }
    }

    private static void generarReporteDiario(Scanner scanner) {
        System.out.print("Ingrese la fecha del reporte (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        Collection<Double> reporte = parqueadero.generarReporteDiario(fecha);

        System.out.println("Reporte diario:");
        System.out.println("Dinero recaudado por carros: " + reporte.toArray()[0]);
        System.out.println("Dinero recaudado por motos clásicas: " + reporte.toArray()[1]);
        System.out.println("Dinero recaudado por motos híbridas: " + reporte.toArray()[2]);
    }

    private static void generarReporteMensual(Scanner scanner) {
        System.out.print("Ingrese el año y mes del reporte (AAAA-MM): ");
        String mesStr = scanner.nextLine();
        YearMonth mes = YearMonth.parse(mesStr);

        double dineroRecaudado = parqueadero.generarReporteMensual(mes);

        System.out.println("Dinero recaudado en el mes " + mes + ": " + dineroRecaudado);
    }

    private static void obtenerPropietarioPorPuesto(Scanner scanner) {
        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();

        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Propietario propietario = parqueadero.obtenerPropietarioPorPuesto(posicionI, posicionJ);

        if (propietario != null) {
            System.out.println("Propietario del vehículo:");
            System.out.println("Nombres: " + propietario.getNombres());
            System.out.println("Apellidos: " + propietario.getApellidos());
            System.out.println("Edad: " + propietario.getEdad());
            System.out.println("Teléfono: " + propietario.getTelefono());
            System.out.println("Identificación: " + propietario.getIdentificacion());
            System.out.println("Correo: " + propietario.getCorreo());
        } else {
            System.out.println("El puesto está disponible o no existe.");
        }
    }
}