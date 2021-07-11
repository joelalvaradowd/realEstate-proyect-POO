/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Venta {

    private String nombreCliente;
    private String cedula;
    private String correo;
    private LocalDate fecha;
    private boolean registrada;

    public Venta(String nombreCliente, String cedula, String correo, LocalDate fecha) {
        this.nombreCliente = nombreCliente;
        this.cedula = cedula;
        this.correo = correo;
        this.fecha = fecha;
        registrada = false;
    }

    public boolean isRegistrada() {
        return registrada;
    }

    public void registrar() {
        if (!isRegistrada()) {
            registrada = true;
        }
    }

    @Override
    public String toString() {
        return "\nCliente: " + nombreCliente + "\nCedula: " + cedula + "\nCorreo: " + correo + "\nFecha: " + String.valueOf(fecha)+"\n";
    }

}
