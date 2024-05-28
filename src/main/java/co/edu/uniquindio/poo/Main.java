package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del parqueadero: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de puestos: ");
        int numeroPuestos = scanner.nextInt();
        System.out.print("Asignar tarifa del carro");
       // int 
        scanner.nextLine(); // Consumir la nueva línea

        Parqueadero parqueadero = new Parqueadero(nombre, numeroPuestos);

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Eliminar Vehículo");
            System.out.println("3. Verificar Puesto");
            System.out.println("4. Generar Reporte Diario");
            System.out.println("5. Generar Reporte Mensual");
            System.out.println("6. Obtener Propietario por Puesto");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarVehiculo(scanner, parqueadero);
                    break;
                case 2:
                    eliminarVehiculo(scanner, parqueadero);
                    break;
                case 3:
                    verificarPuesto(scanner, parqueadero);
                    break;
                case 4:
                    generarReporteDiario(scanner, parqueadero);
                    break;
                case 5:
                    generarReporteMensual(scanner, parqueadero);
                    break;
                case 6:
                    obtenerPropietarioPorPuesto(scanner, parqueadero);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private static void agregarVehiculo(Scanner scanner, Parqueadero parqueadero) {
    
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario: ");
        String nombrePropietario = scanner.nextLine();
        System.out.print("Ingrese los apellidos del propietario: ");
        String apellidosPropietario = scanner.nextLine();
        System.out.print("Ingrese la edad del propietario: ");
        int edadPropietario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el teléfono del propietario: ");
        String telefonoPropietario = scanner.nextLine();
        System.out.print("Ingrese la identificación del propietario: ");
        String identificacionPropietario = scanner.nextLine();
        System.out.print("Ingrese el correo del propietario: ");
        String correoPropietario = scanner.nextLine();

        Propietario propietario = new Propietario(nombrePropietario, apellidosPropietario, edadPropietario, telefonoPropietario, identificacionPropietario, correoPropietario);

        System.out.print("Ingrese el tipo de vehículo (carro/moto_clasica/moto_hibrida): ");
        String tipoVehiculo = scanner.nextLine();
        Vehiculo vehiculo = null;
        if (tipoVehiculo.equalsIgnoreCase("carro")) {
            vehiculo = new Carro(placa, modelo, propietario);
        } else if (tipoVehiculo.equalsIgnoreCase("moto_clasica")) {
            System.out.print("Ingrese la velocidad máxima de la moto: ");
            double velocidadMaxima = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea
            vehiculo = new Moto(placa, modelo, propietario, velocidadMaxima, TipoMoto.MOTO_CLASICA);
        } else if (tipoVehiculo.equalsIgnoreCase("moto_hibrida")) {
            System.out.print("Ingrese la velocidad máxima de la moto: ");
            double velocidadMaxima = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea
            vehiculo = new Moto(placa, modelo, propietario, velocidadMaxima, TipoMoto.MOTO_HIBRIDA);
        }

        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();
        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (vehiculo != null) {
            parqueadero.agregarVehiculoPorPuesto(vehiculo, posicionI, posicionJ);
            System.out.println("Vehículo agregado exitosamente.");
        } else {
            System.out.println("Tipo de vehículo no reconocido.");
        }
    }

    private static void eliminarVehiculo(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();
        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        LocalDateTime fechaSalida = LocalDateTime.now();
        parqueadero.eliminarVehiculoPorPuesto(posicionI, posicionJ, fechaSalida);
        System.out.println("Vehículo eliminado exitosamente.");
    }

    private static void verificarPuesto(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();
        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        boolean disponible = parqueadero.verificarPuesto(posicionI, posicionJ);
        System.out.println("El puesto (" + posicionI + "," + posicionJ + ") está " + (disponible ? "disponible" : "ocupado"));
    }

    private static void generarReporteDiario(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);
        System.out.println("Reporte Diario: " + reporteDiario);
    }

    private static void generarReporteMensual(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese el mes y año (yyyy-mm): ");
        String mesStr = scanner.nextLine();
        YearMonth mes = YearMonth.parse(mesStr);
        double reporteMensual = parqueadero.generarReporteMensual(mes);
        System.out.println("Reporte Mensual: " + reporteMensual);
    }

    private static void obtenerPropietarioPorPuesto(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la posición I del puesto: ");
        int posicionI = scanner.nextInt();
        System.out.print("Ingrese la posición J del puesto: ");
        int posicionJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        Propietario propietario = parqueadero.obtenerPropietarioPorPuesto(posicionI, posicionJ);
        if (propietario != null) {
            System.out.println("Propietario: " + propietario.getNombres() + " " + propietario.getApellidos() + " " + propietario.getEdad()+ " " + propietario.getTelefono()+" " + propietario.getIdentificacion()+ " " + propietario.getCorreo()+ " " );
        } else {
            System.out.println("No hay ningún propietario registrado en el puesto (" + posicionI + "," + posicionJ + ")");
        }
    }
}

