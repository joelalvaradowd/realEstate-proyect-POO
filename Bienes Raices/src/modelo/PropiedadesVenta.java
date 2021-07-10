/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Eliot
 */
public class PropiedadesVenta {
    private double precio;
    private String tipo;
    private String ciudad;
    private String sector;
    private ArrayList<Propiedad> propiedades;

    public PropiedadesVenta(double precio, String ciudad, String sector) {
        this.precio = precio;
        this.ciudad = ciudad;
        this.sector = sector;
    }

    public PropiedadesVenta(double precio, String ciudad) {
        this.precio = precio;
        this.ciudad = ciudad;
    }

    public PropiedadesVenta(String ciudad, String sector) {
        this.ciudad = ciudad;
        this.sector = sector;
    }
    
}
