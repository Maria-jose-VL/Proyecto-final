package co.edu.uniquindio.poo;

import java.util.List;

public class Parqueadero {
    public String nombre;
    public List<Registro> registros; 
    public List<Puesto> puestos;
    
    //Constructor de la clase parqueadero
    public Parqueadero(String nombre, List<Registro> registros, List<Puesto> puestos) {
        this.nombre = nombre;
        this.registros = registros;
        this.puestos = puestos;
    }

    
}  