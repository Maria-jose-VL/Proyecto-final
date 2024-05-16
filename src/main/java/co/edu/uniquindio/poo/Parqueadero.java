package co.edu.uniquindio.poo;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public class Parqueadero {
    public String nombre;
    private int numeroPuestos;
    private final  Collection<Registro> registros; 
    private final  Collection<Puesto> puestos;
    private final  Collection<Vehiculo> vehiculos;
    
    public Parqueadero(String nombre, int numeroPuestos) {
        assert nombre != null && !nombre.isBlank(): "El nombre no puede nulo ni tampoco vacío";
        assert numeroPuestos >0 : "El número de puestos no puede ser negativo ni tampoco cero";
        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        this.registros = new LinkedList<>();
        this.puestos = new LinkedList<>();
        this.vehiculos= new LinkedList<>();
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

    public Collection<Puesto> getPuestos() {
        return puestos;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void crearPuestos(int numeroPuestos){
        for (int i=0; i < numeroPuestos; i++ ){
            String posicionI = "Fila" + (i+1);
            for( int j=0; j < numeroPuestos; i++){
                String posicionJ= "Columna" + (j+1);
                Puesto puesto = new Puesto(posicionI, posicionJ, Estado.DISPONIBLE);
                puestos.add(puesto);
            }
        }
    }    
    private boolean verificarPuesto(String posicionI, String posicionJ){
        for (Puesto puesto : puestos){
            if (puesto.getPosicionI().equals(posicionI) && puesto.getPosicionJ().equals(posicionJ) && puesto.getEstado()== Estado.OCUPADO){
                return false;
            }
        }
        return true;
    }    
public void agregarVehiculoPuesto(Vehiculo vehiculo, String posicionI, String posicionJ){
        if (verificarPuesto(posicionI, posicionJ)){
            Optional <Puesto> puestoAbuscar = buscarPuesto(posicionI, posicionJ);
        puestoAbuscar.ifPresent(puesto -> puesto.setVehiculo(vehiculo));
        actualizarEstadoPuesto(posicionI, posicionJ, Estado.OCUPADO);
        
        LocalDateTime fechaEntrada = LocalDateTime.now();
        Registro nuevoRegistro = new Registro(fechaEntrada, null, vehiculo);
        registros.add(nuevoRegistro);
        addVehiculo(vehiculo);
        }
        else{
            assert !verificarPuesto(posicionI, posicionJ): "Error: el puesto se encuentra ocupado";
        }
    }
}