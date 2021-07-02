/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Agente;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author User
 */
public class Sistema {

    private static ArrayList<Usuario> usuarios;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int elec;
        do {
            inicializarAtributos();
            System.out.println("1. Inicio de sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Eliga una opcion:");
            elec = sc.nextInt();
            sc.nextLine();
            if (elec == 1) {
                System.out.print("Ingrese su usuario:");
                String usuario = sc.nextLine();
                System.out.print("Ingrese su contraseña:");
                String contraseña = sc.nextLine();
                boolean existe = false;
                for (Usuario u : usuarios) {
                    if (u.getUser().equals(usuario) && u.getPassword().equals(contraseña)) {
                        u.mostrarMenu();
                        existe = true;
                    }
                }
                if (!existe) {
                    System.out.println("Usuario o contraseña incorrecto");
                }

            } else if (elec == 2) {
                System.out.print("Ingrese su nombre:");
                String nombre = sc.nextLine();
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
                    fechanacimiento = sc.nextLine();
                }
                Usuario u = new Cliente(usuario, contraseña, cedula, nombre, correo);
                usuarios.add(u);
                System.out.println("Registro exitoso!");
            }
        } while (elec != 3);
    }

    public static void inicializarAtributos() {
        usuarios = new ArrayList<>();
        usuarios.add(new Agente("joealalv", "bebePoxi", "0957831282", "Joel", "joelalvarado2000g@hotmail.com"));
        usuarios.add(new Agente("eliotsant", "bebeHermoso", "0952869451", "Eliott", "eliotsant@outlook.com"));
        usuarios.add(new Cliente("rmera", "bebeGuapa", "0912345678", "Rocio", "rmera@espol.edu.ec"));
    }

}
