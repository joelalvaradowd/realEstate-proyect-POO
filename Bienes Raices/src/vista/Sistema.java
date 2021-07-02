/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Sistema {

    private Scanner sc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Inicio de sesion");
        System.out.println("2. Registrarse");
        System.out.print("Eliga una opcion:");
        int elec = sc.nextInt();
        while (elec > 2 || elec < 1) {
            System.out.println("Eleccion incorrecta");
            System.out.println("1. Inicio de sesion");
            System.out.println("2. Registrarse");
            System.out.print("Eliga una opcion:");
            int elec2 = sc.nextInt();
            elec = elec2;
        }
        sc.nextLine();
        if (elec == 1) {
            System.out.print("Ingrese su usuario:");
            String usuario = sc.nextLine();
            System.out.print("Ingrese su contraseña:");
            String contraseña = sc.nextLine();
        } else {
            System.out.print("Ingrese su nombre de usuario:");
            String usuario = sc.nextLine();
            System.out.print("Ingrese su numero de cedula:");
            String cedula = sc.nextLine();
            System.out.print("Ingrese su contraseña:");
            String contraseña = sc.nextLine();
            System.out.print("Ingrese su correo:");
            String correo = sc.nextLine();
            System.out.print("Ingrese su fecha de nacimiento con el formato(año-mes-dia):");
            String fechanacimiento = sc.nextLine();
            LocalDate hoy = LocalDate.now();
            while (LocalDate.parse(fechanacimiento).isAfter(hoy.minusYears(18))) {
                System.out.println("No se puede registrar usted es menor de edad");
                System.out.print("Ingrese su fecha de nacimiento con el formato(año-mes-dia):");
                String fechanacimiento2 = sc.nextLine();
                fechanacimiento = fechanacimiento2;
            }
            System.out.println("Registro exitoso!");
        }
    }
}
