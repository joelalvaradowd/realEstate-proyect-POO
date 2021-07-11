/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CalculadoraPrestamoFrances extends CalculadoraPrestamo {

    private static ArrayList<Double> cuotaPagar;

    public CalculadoraPrestamoFrances(double costo, double tasaInteres, int cuotas) {
        super(costo, tasaInteres, cuotas);
    }

    public static ArrayList<Double> getCuotaPagar() {
        return cuotaPagar;
    }

    @Override
    public void calculadoraPrestamo(double costo, double tasaInteres, int cuotas) {
        int menosAnios = cuotas;
        while (menosAnios > 0) {
            double cuotaMonto = costo * ((tasaInteres * 0.01) / 1 - (1 + Math.pow(tasaInteres * 0.01, (-cuotas))));
            double interesMonto = costo * (tasaInteres * 0.01);
            double reduccionCapital = cuotaMonto - interesMonto;
            double capitalAdeudado = costo - reduccionCapital;
            cuotaPagar.add(reduccionCapital);
            costo = capitalAdeudado;
            menosAnios--;
        }
    }
}
