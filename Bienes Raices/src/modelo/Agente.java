/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Agente extends Usuario{
    private ArrayList<Venta> ventas;
    private ArrayList<Propiedad> propiedades;
    private Buzon buzon;

    public Agente(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
    }
    public void responderDuda(){}
    
    public void presentarConsultas(){}
    
    public void seguirPropiedad(Propiedad p){
        propiedades.add(p);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menu de agente");
    }
}
