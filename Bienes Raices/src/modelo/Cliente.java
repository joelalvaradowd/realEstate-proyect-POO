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
                    System.out.println("Tipo");
                    String tipo = sc.nextLine();
                    System.out.println("Rango de precio:");
                    String rango = sc.nextLine();
                    System.out.println("Ciudad:");
                    String ciudad = sc.nextLine();
                    System.out.println("Sector:");
                    String sector = sc.nextLine();
                    if (tipo == "casa") {
                        
                    }
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

            }
        } while (elec != 5);

    }
}
