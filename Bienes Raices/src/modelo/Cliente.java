/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

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
    
    public void mostrarCuotas(String tipo){}

    @Override
    public void mostrarMenu() {
        System.out.println("Menu de cliente");
    }
}
