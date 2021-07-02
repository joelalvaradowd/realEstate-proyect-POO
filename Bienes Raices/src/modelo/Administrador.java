/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import vista.Sistema;

/**
 *
 * @author User
 */
public class Administrador extends Usuario {

    private ArrayList<Agente> agentes;
    private ArrayList<Propiedad> propiedades;
    private static int i = 0;

    public Administrador(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
        agentes = new ArrayList<>();
        propiedades = new ArrayList<>();

    }

    public void registrarPropiedad(Propiedad p) {
        propiedades.add(p);
        if (i < agentes.size()) {
            agentes.get(i).seguirPropiedad(p);
            i++;
        }
        if (i >= agentes.size()) {
            i = 0;
        }
    }

    public void registrarAgente(Agente a) {
        agentes.add(a);
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int elec;
        do {
            System.out.println("Menu de administrador");
            System.out.println("1.Registrar propiedad");
            System.out.println("2.Registrar agente");
            System.out.println("3.Reporte contactos y ventas");
            System.out.println("4.Cerrar sesion");
            System.out.print("Elija una opcion:");
            elec = sc.nextInt();
            sc.nextLine();
            switch(elec){
                case 2:{
                    System.out.print("Ingrese el nombre del agente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Ingrese el correo eletronico: ");
                    String correo = sc.nextLine();
                    System.out.print("Ingrese el usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String password = sc.nextLine();
                    Usuario u = new Agente(usuario, password, cedula, nombre, correo);
                    agentes.add((Agente)u);
                    Sistema.agregarUsuario(u);
                }
            }
        } while (elec != 4);
    }
}
