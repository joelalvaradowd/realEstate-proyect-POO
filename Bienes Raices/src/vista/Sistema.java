/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import modelo.Administrador;
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
        inicializarAtributos();
        do {
            System.out.println("1. Inicio de sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.println("4. Ver usuarios");
            System.out.print("Elija una opcion:");
            elec = sc.nextInt();
            sc.nextLine();
            switch (elec) {
                case 1: {
                    System.out.print("Ingrese su usuario:");
                    String usuario = sc.nextLine();
                    System.out.print("Ingrese su contraseña:");
                    String password = sc.nextLine();
                    Usuario u = existeUsuario(usuario, password);
                    if(u!=null){
                        u.mostrarMenu();
                    }
                    else{
                        System.out.println("Usuario o contraseña incorrecta");
                    }
                    break;
                }
                case 2: {
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
                    System.out.print("Ingrese su fecha de nacimiento con el formato (dia mes año):");
                    String input = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
                    LocalDate fechanacimiento = LocalDate.parse(input, formatter);
                    LocalDate hoy = LocalDate.now();
                    while (fechanacimiento.isAfter(hoy.minusYears(18))) {
                        System.out.println("No se puede registrar usted es menor de edad");
                        System.out.print("Ingrese su fecha de nacimiento con el formato(dia mes año):");
                        input = sc.nextLine();
                        formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
                        fechanacimiento = LocalDate.parse(input, formatter);
                    }
                    usuarios.add(new Cliente(usuario, contraseña, cedula, nombre, correo));
                    System.out.println("Registro exitoso!");
                    break;
                }
                case 4:
                    System.out.println(usuarios);
                    System.out.println(usuarios.size());
                    break;
                default:
                    break;
            }
        } while (elec != 3);
    }

    public static void inicializarAtributos() {
        usuarios = new ArrayList<>();
        usuarios.add(new Administrador("joealalv", "bebePoxi", "0957831282", "Joel", "joelalvarado2000g@hotmail.com"));
        usuarios.add(new Agente("eliotsant", "bebeHermoso", "0952869451", "Eliott", "eliotsant@outlook.com"));
        usuarios.add(new Cliente("rmera", "bebeGuapa", "0912345678", "Rocio", "rmera@espol.edu.ec"));
    }
    
    public static void agregarUsuario(Usuario u){
        usuarios.add(u);
    }
    
    public static Usuario existeUsuario(String user, String password){
        for(Usuario u: usuarios){
            if(u.getUser().equals(user) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}
