/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Agente extends Usuario {

    private ArrayList<Venta> ventas;
    private ArrayList<Propiedad> propiedades;
    private Buzon buzon;

    public Agente(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
    }
    
    public void agregarPropiedad(Propiedad p){
        propiedades.add(p);
    }

    public void responderDuda() {
    }

    public void presentarConsultas() {
    }

    public void seguirPropiedad(Propiedad p) {
        propiedades.add(p);
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int elec;
        do {
            System.out.println("Menu de agente");
            System.out.println("1.Registrar buzon");
            System.out.println("2. Registrar venta");
            System.out.println("3. Cerrar sesion");
            System.out.print("Elija una opcion:");
            elec = sc.nextInt();
            if (elec == 1) {
            } else if (elec == 2) {
            }
        } while (elec != 3);
    }
}
