/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author User
 */
public abstract class CalculadoraPrestamo {
    private double costo;
    private double tasaInteres;
    private int cuotas;

    public CalculadoraPrestamo(double costo, double tasaInteres, int cuotas) {
        this.costo = costo;
        this.tasaInteres = tasaInteres;
        this.cuotas = cuotas;
    }
    public abstract double calculadoraPrestamo();

    public double getCosto() {
        return costo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public int getCuotas() {
        return cuotas;
    }
    
}
