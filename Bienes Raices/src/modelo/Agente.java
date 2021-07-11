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
public class Agente extends Usuario {

    private ArrayList<Venta> ventas;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<Consulta> consultas;
    private String codigo;
    private int numVentas;

    public Agente(String codigo,String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
        this.codigo = codigo;
        propiedades = new ArrayList<>();
        consultas = new ArrayList<>();
        
    }
    
    public int getNumVentas(){
        return numVentas;
    }
    
    public int getNumRespuestas(){
        int total = 0;
        for(Consulta c: consultas){
            if(c.getRespuesta()!=null){
                total++;
            }
        }
        return total;
    }
    
    public String getCodigo(){
        return codigo;
    }

    public void agregarConsulta(Consulta c) {
        consultas.add(c);
    }

    public void agregarPropiedad(Propiedad p) {
        propiedades.add(p);
    }

    public void revisarBuzon() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Buzon de " + super.getNombre());
        if (!consultas.isEmpty()) {
            for (Consulta c : consultas) {
                System.out.println(String.valueOf(c.getFechaInicio()) + ": " + c.getCliente().getNombre() + ": " + c.getPregunta());
                if (c.getEstado() == Estado.ESPERANDO) {
                    System.out.print("¿Contestar? (si/no):");
                    String decision = sc.nextLine();
                    if (decision.equals("si")) {
                        System.out.print("Respuesta:");
                        String respuesta = sc.nextLine();
                        c.setRespuesta(respuesta);
                        c.setFechaRespuesta(LocalDate.now());
                        c.setEstado(Estado.RESPONDIDO);
                    }
                } else {
                    System.out.println(String.valueOf(c.getFechaInicio()) + ": " + c.getAgente().getNombre() + ": " + c.getRespuesta());
                }
            }
        } else {
            System.out.println("No tiene consultas asignadas todavía");
        }

    }

    public void concretarVenta(String nombre, String cedula, String correo) {
        ventas.add(new Venta(nombre, cedula, correo, LocalDate.now()));
    }
    
    public void registrarVenta(){
        for(Venta v: ventas){
            if(!v.isRegistrada()){
                v.registrar();
                numVentas++;
            }
        }
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
                revisarBuzon();
            } else if (elec == 2) {
                registrarVenta();
                System.out.println("Todas las ventas fueron registradas");
            }
        } while (elec != 3);
    }
}
