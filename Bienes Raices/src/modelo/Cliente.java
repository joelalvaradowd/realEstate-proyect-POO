/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cliente extends Usuario {

    private LocalDate nacimiento;
    private ArrayList<Alerta> alertas;

    public Cliente(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
    }

    public void mostrarCuotas(String tipo) {
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int elec;
        do {
            System.out.println("Menu de cliente");
            System.out.println("1.Consultar propiedades");
            System.out.println("2.Buzon de consultas");
            System.out.println("3.Crear alerta");
            System.out.println("4.Simular prestamo");
            System.out.println("5.Cerrar sesion");
            System.out.print("Elija una opcion:");
            elec = sc.nextInt();
            switch (elec) {
                case 1: {
                    System.out.println("Consultar propiedades");
                    System.out.print("Tipo:");
                    String tipo = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Precio maximo:");
                    double rangomas = sc.nextDouble();
                    System.out.print("Precio minimo:");
                    double rangomenos=sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ciudad:");
                    String ciudad = sc.nextLine();
                    System.out.println("Sector:");
                    String sector = sc.nextLine();
                    PropiedadesVenta pv=new PropiedadesVenta();
                    pv.filtrarPropiedades(rangomas, rangomenos, tipo, ciudad, sector);
                    pv.mostrarPropiedades(pv.filtrarPropiedades(rangomas, rangomenos, tipo, ciudad, sector));
                }
                case 2: {
                    break;
                }
                case 3: {
                    System.out.println("Creando Alarma...");
                    double precio = 0;
                    String tipo = null, ciudad = null, sector = null;
                    System.out.print("Ingrese el precio:");
                    String price = sc.nextLine();
                    if (!price.isBlank()) {
                        precio = Double.parseDouble(price);
                    }
                }
                case 4:
                    System.out.println("Calculadora de prestamos");
                    System.out.print("Seleccione el sistema de amortizacion(Aleman/frances):");
                    String tipo=sc.nextLine();
                    sc.nextLine();
                    System.out.print("Ingrese el costo del inmobiliario:");
                    double ci=sc.nextDouble();
                    System.out.print("Ingrese la tasa de interes:");
                    double ti=sc.nextDouble();
                    System.out.print("Ingrese el numero de cuotas mensuales:");
                    int cm=sc.nextInt();
                    if(tipo.equals("frances")){
                        System.out.println("Sistema frances");
                        CalculadoraPrestamoFrances cf=new CalculadoraPrestamoFrances(ci,ti,cm);
                        cf.mostrarCuotas(cf.calculadoraPrestamo(ci, ti, cm));
                    }
                    else if(tipo.equals("aleman")){
                        System.out.println("Sistema Aleman");
                        CalculadoraPrestamoAleman ca=new CalculadoraPrestamoAleman(ci,ti,cm);
                        ca.calculadoraPrestamo(ci, ti, cm);
                        ca.mostrarCuotas(ca.calculadoraPrestamo(ci, ti, cm));
                    }   
                    break;
            }
            
        } while (elec != 5);

    }
}
