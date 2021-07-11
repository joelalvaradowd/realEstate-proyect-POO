/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Eliot
 */
public class Casa extends Propiedad {

    private int numPisos;
    private int numHabitaciones;

    public Casa(String codigo, double precio, double ancho, double profundidad, String provincia, String ciudad, String direccion, String sector, String descripcion, boolean vendida, int pisos, int habitaciones) {
        super(codigo, precio, ancho, profundidad, provincia, ciudad, direccion, sector, descripcion, vendida);
        this.numHabitaciones = habitaciones;
        this.numPisos = pisos;
    }
    
    @Override
    public void mostrarDetalles(){
        super.mostrarDetalles();
        System.out.println("Numero de pisos: "+numPisos);
        System.out.println("Numero ded habitaciones: "+numHabitaciones);
        
        
    }
}
