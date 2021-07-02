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
public class Terreno extends Propiedad{
  private TipoTerreno tipo;  

    public Terreno(String codigo, double precio, double ancho, double profundidad, String provincia, String direccion, String sector, String descripcion, boolean vendida, TipoTerreno tipo) {
        super(codigo, precio, ancho, profundidad, provincia, direccion, sector, descripcion, vendida);
        this.tipo = tipo;
    }

}
