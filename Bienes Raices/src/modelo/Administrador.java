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
    private static int codigo = 0;

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
            System.out.println("5. Ver propiedades");
            System.out.print("Elija una opcion: ");
            elec = sc.nextInt();
            sc.nextLine();
            switch (elec) {
                case 1: {
                    System.out.print("Ingrese el tipo de propiedad(casa o terreno) que desea ingresar: ");
                    String propiedad = sc.nextLine();
                    while (!propiedad.equals("casa") && !propiedad.equals("terreno")) {
                        System.out.println("No ha ingresado ninguna de las 2 opciones");
                        System.out.print("Ingrese el tipo de propiedad(casa o terreno) que desea ingresar: ");
                        propiedad = sc.nextLine();

                    }
                    if (propiedad.equals("terreno")) {
                        System.out.print("Ingrese el precio del terreno:");
                        double precio = sc.nextDouble();
                        System.out.print("Ingrese el ancho del terreno en metros:");
                        double ancho = sc.nextDouble();
                        System.out.print("Ingrese la profundidad del terreno en metros: ");
                        double profundidad = sc.nextDouble();
                        System.out.print("Ingrese la ciudad donde se encuentra el terreno:");
                        sc.nextLine();
                        String ciudad = sc.nextLine();
                        System.out.print("Ingrese la direccion donde se encuentra el terreno:");
                        String direccion = sc.nextLine();
                        System.out.print("Ingrese el sector donde se encuentra el terreno: ");
                        String sector = sc.nextLine();
                        System.out.print("Ingrese la provincia:");
                        String provincia = sc.nextLine();
                        System.out.print("Ingrese el tipo de terreno:");
                        String tipo = sc.nextLine();
                        TipoTerreno tipoT = TipoTerreno.valueOf(tipo.toUpperCase());
                        System.out.print("Ingrese una descripcion del terreno: ");
                        String descripcion = sc.nextLine();
                        codigo++;
                        propiedades.add(new Terreno(String.valueOf(codigo), precio, ancho, profundidad, provincia, ciudad,direccion, sector, descripcion, false, tipoT));
                        break;
                    }
                    else if(propiedad.equals("casa")){
                        System.out.print("Ingrese el precio de la casa:");
                        double precio = sc.nextDouble();
                        System.out.print("Ingrese el ancho de la casa en metros:");
                        double ancho = sc.nextDouble();
                        System.out.print("Ingrese la profundidad de la casa en metros: ");
                        double profundidad = sc.nextDouble();
                        System.out.print("Ingrese la ciudad donde se encuentra la casa:");
                        sc.nextLine();
                        String ciudad = sc.nextLine();
                        System.out.print("Ingrese la direccion donde se encuentra la casa:");
                        String direccion = sc.nextLine();
                        System.out.print("Ingrese el sector donde se encuentra la casa: ");
                        String sector = sc.nextLine();
                        System.out.print("Ingrese la provincia donde se encuentre la casa:");
                        String provincia = sc.nextLine();
                        System.out.print("Ingrese el numero de pisos");
                        int pisos=sc.nextInt();
                        System.out.print("Ingrese el numero de habitaciones:");
                        int habitaciones=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Agregue una descripcion de la casa:");
                        String descripcion=sc.nextLine();      
                        Propiedad c = new Casa(String.valueOf(codigo),precio,ancho,profundidad,provincia,ciudad,direccion,sector,descripcion,false,pisos,habitaciones);
                        codigo++;
                        propiedades.add(c);
                        break;
                    }               
                }
                case 2: {
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
                    agentes.add((Agente) u);
                    Sistema.agregarUsuario(u);
                    break;
                }
                case 3: {
                    System.out.println(propiedades);
                    break;
                }
                default:
                    System.out.println("Opcion inválida");
                    break;
            }
        } while (elec != 4);
    }
}
