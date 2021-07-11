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
public class CalculadoraPrestamoAleman extends CalculadoraPrestamo {

    private static ArrayList<Double> cuotaPagar;

    public CalculadoraPrestamoAleman(double costo, double tasaInteres, int cuotas) {
        super(costo, tasaInteres, cuotas);

    }

    public static ArrayList<Double> getCuotaPagar() {
        return cuotaPagar;
    }

    @Override
    public void calculadoraPrestamo(double costo, double tasaInteres, int cuotas) {
        int menosMeses = cuotas;
        double totalPagar = costo;
        while (menosMeses > 0) {
            double amortizacion = costo / cuotas;
            double interes = costo * (tasaInteres * 0.01);
            double cuotasPagar = amortizacion + interes;
            cuotaPagar.add(cuotasPagar);
            costo -= amortizacion;
        }

    }

    public void mostrarCuotas(List<Double> cuotaPagar) {
        for (Double d : cuotaPagar) {
            System.out.println(d);
        }
    }

    public static void main(String args[]) {
        
    }
}
