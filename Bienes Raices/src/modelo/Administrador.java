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
    public void registrarPropiedad(Propiedad p){       
        propiedades.add(p);
    }
    public void registrarAgente(Agente a){
        agentes.add(a);
    }
}                                               
