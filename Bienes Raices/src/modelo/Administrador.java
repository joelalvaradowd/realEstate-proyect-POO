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
public class Administrador extends Usuario {

    private ArrayList<Agente> agentes;
    private ArrayList<Propiedad> propiedades;
    private static int i=0;
    public Administrador(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
        agentes = new ArrayList<>();
        propiedades = new ArrayList<>();
        
    }

    private void registrarPropiedad(Propiedad p) {
        propiedades.add(p);
        if(i<agentes.size()){
        agentes.get(i).seguirPropiedad(p);
        i++;
        }
        if(i>=agentes.size()){
            i = 0;
        }
    }

    public void registrarAgente(Agente a) {
        agentes.add(a);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menu de administrador");
    }
}                                               
