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
public class Terreno extends Propiedad {

    private TipoTerreno tipo;

    public Terreno(String codigo, double precio, double ancho, double profundidad, String provincia, String ciudad, String direccion, String sector, String descripcion, boolean vendida, TipoTerreno tipo) {
        super(codigo, precio, ancho, profundidad, provincia, ciudad, direccion, sector, descripcion, vendida);
        this.tipo = tipo;
    }

    public Terreno(Terreno p) {
        super(p.getCodigo(), p.getPrecio(), p.getAncho(), p.getProfundidad(), p.getProvincia(), p.getCiudad(), p.getDireccion(), p.getSector(), p.getDescripcion(), p.isVendida());
        this.tipo = p.getTipo();
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: " + String.valueOf(tipo));
    }

    public TipoTerreno getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == getClass()) {
            Terreno t = (Terreno) o;
            return super.equals(o) && tipo == t.tipo;

        }
        return false;
    }

}
