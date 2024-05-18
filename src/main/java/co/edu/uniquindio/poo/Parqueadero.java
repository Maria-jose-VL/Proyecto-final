package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;

public class Parqueadero {
    public String nombre;
    private int numeroPuestos;
    private final Collection<Registro> registros;
    private final Hashtable<String, Puesto> puestos;
    private final Collection<Vehiculo> vehiculos;

    public Parqueadero(String nombre, int numeroPuestos) {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede nulo ni tampoco vacío";
        assert numeroPuestos > 0 : "El número de puestos no puede ser negativo ni tampoco cero";
        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        this.registros = new LinkedList<>();
        this.puestos = new Hashtable<>();
        this.vehiculos = new LinkedList<>();
        crearPuestos(numeroPuestos);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPuestos() {
        return numeroPuestos;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public Hashtable<String, Puesto> getPuestos() {
        return puestos;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void crearPuestos(int numeroPuestos) {
        for (int i = 0; i < numeroPuestos; i++) {
            int posicionI = (i + 1);
            for (int j = 0; j < numeroPuestos; i++) {
                int posicionJ = (j + 1);
                String llave = "(" + posicionI + "," + posicionJ + ")";
                puestos.put(llave, new Puesto(posicionI, posicionJ, Estado.DISPONIBLE));
            }
        }
    }

    private boolean verificarPuesto(int posicionI, int posicionJ) {
        Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
        if (puesto != null) {
            if (puesto.getEstado().equals(Estado.DISPONIBLE)) {
                return true;
            }
        }
        return false;
    }

    public void agregarVehiculoPuesto(Vehiculo vehiculo, int posicionI, int posicionJ) {
        assert verificarPuesto(posicionI, posicionJ) == true : "Error, el puesto esta ocupado";
        if (verificarPuesto(posicionI, posicionJ)) {
            Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
            puesto.setVehiculo(vehiculo);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.OCUPADO);
            LocalDateTime fechaEntrada = LocalDateTime.now();
            Registro registro = new Registro(fechaEntrada, null, vehiculo);
            registros.add(registro);
            vehiculos.add(vehiculo);
        }
    }

    public void eliminarVehiculoPuesto(int posicionI, int posicionJ) {
        if (!verificarPuesto(posicionI, posicionJ)) {
            LocalDateTime fechaSalida = LocalDateTime.now();
            Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
            var vehiculoPuesto = puesto.getVehiculo();
            puesto.setVehiculo(null);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.DISPONIBLE);
            for (Registro registro : registros) {
                if (registro.getVehiculo().equals(vehiculoPuesto)) {
                    registro.setFechaSalida(fechaSalida);
                }
            }
        }
    }

    public void actualizarEstadoPuesto(int posicionI, int posicionJ, Estado estado) {
        Estado estadoDisponible = Estado.DISPONIBLE;
        Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
        if (puesto.getEstado().equals(estadoDisponible)) {
            puesto.setEstado(estado);
        }

    }

    public Collection<Double> generarReporteDiario(LocalDate fecha) {
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().isEqual(fecha)) {
                Vehiculo vehiculo = registro.getVehiculo();
                double tarifa = registro.calcularTarifa();
                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    if (moto.getTipoMoto() == TipoMoto.MOTO_CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }
                }
            }
        }
        Collection<Double> reporteDiario = new LinkedList<>();
        reporteDiario.add(dineroRecaudadoCarro);
        reporteDiario.add(dineroRecaudadoMotoClasica);
        reporteDiario.add(dineroRecaudadoMotoHibrida);

        return reporteDiario;
    }

    public Propietario obtenerPropietarioPorPuesto(int posicionI, int posicionJ) {
        Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
        if (puesto != null) {
            if (puesto.getEstado().equals(Estado.OCUPADO)) {
                Vehiculo vehiculo = puesto.getVehiculo();
                return vehiculo.getPropietario();
            }
        }
        return null;
    }
}