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
public class Administrador extends Usuario {

    private ArrayList<Agente> agentes;
    private ArrayList<Propiedad> propiedades;
    private static int i = 0;

    public Administrador(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
        agentes = new ArrayList<>();
        propiedades = new ArrayList<>();

    }

    private void registrarPropiedad(Propiedad p) {
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
        } while (elec != 4);
        switch (elec) {
            case 1:
                System.out.println("Ingrese el tipo de propiedad(casao terreno) que desea ingresar:");
                String propiedad = sc.nextLine();
                while (propiedad != "casa" || propiedad != "terreno") {
                    System.out.println("No ha ingresado ninguna de las 2 opciones:");
                    propiedad = sc.nextLine();    
                    
                }
                if(propiedad=="terreno"){
                    System.out.print("Ingrese el precio del terreno:");
                    double precio=sc.nextDouble();
                    System.out.print("Ingrese el ancho del terreno en metros:");
                    double ancho=sc.nextDouble();
                    System.out.print("Ingrese la profundidad del terreno en metros");
                    double profundidad=sc.nextDouble();
                    System.out.print("Ingrese la ciudad donde se encuentra el terreno:");
                    String ciudad=sc.nextLine();
                    System.out.print("Ingrese la direccion donde se encuentra el terreno:");
                    String direccion=sc.nextLine();
                    System.out.print("Ingrese el sector donde se encuentra el terreno");
                    String sector=sc.nextLine();
                    System.out.println("Ingrese el tipo de terreno:");
                    String tipo=sc.nextLine();
                    Propiedad terreno=new Terreno()
                    
                }
        }
    }
}
