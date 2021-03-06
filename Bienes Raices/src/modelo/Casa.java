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

    public Casa(Casa p) {
        super(p.getCodigo(), p.getPrecio(), p.getAncho(), p.getProfundidad(), p.getProvincia(), p.getCiudad(), p.getDireccion(), p.getSector(), p.getDescripcion(), p.isVendida());
        this.numHabitaciones = p.numHabitaciones;
        this.numPisos = p.numPisos;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == getClass()) {
            Casa c = (Casa) o;
            return super.equals(o) && numHabitaciones == c.numHabitaciones && numPisos == c.numPisos;

        }
        return false;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Numero de pisos: " + numPisos);
        System.out.println("Numero ded habitaciones: " + numHabitaciones);

    }
}
