/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CalculadoraPrestamoFrances extends CalculadoraPrestamo {

    public CalculadoraPrestamoFrances(double costo, double tasaInteres, int cuotas) {
        super(costo, tasaInteres, cuotas);
    }

    @Override
    public ArrayList<Double> calculadoraPrestamo(double costo, double tasaInteres, int cuotas) {
        int menosAnios = cuotas;
        ArrayList<Double> cuotaPagar = new ArrayList<>();
        while (menosAnios > 0) {
            double cuotaMonto = costo * ((tasaInteres * 0.01) / 1 - (1 + Math.pow(tasaInteres * 0.01, (-cuotas))));
            double interesMonto = costo * (tasaInteres * 0.01);
            double reduccionCapital = -cuotaMonto + interesMonto;
            double capitalAdeudado = costo - reduccionCapital;
            cuotaPagar.add(reduccionCapital);
            costo = capitalAdeudado;
            menosAnios--;
        }
        return cuotaPagar;
    }

    public void mostrarCuotas(List<Double> cuotaPagar) {
        System.out.println("Cuotas a pagar:");
        int cont = 1;
        for (double d : cuotaPagar) {
            System.out.println("Mes:"+cont+":"+Math.floor(d*100)/100);
            cont++;
        }
    }
}
