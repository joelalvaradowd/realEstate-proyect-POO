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


    public CalculadoraPrestamoAleman(double costo, double tasaInteres, int cuotas) {
        super(costo, tasaInteres, cuotas);

    }
    @Override
    public ArrayList calculadoraPrestamo(double costo, double tasaInteres, int cuotas) {
        int menosMeses = cuotas;
        double totalPagar = costo;
        ArrayList<Double> cuotaPagar= new ArrayList<>();
        while (menosMeses > 0) {
            double amortizacion = costo / cuotas;
            double interes = costo * (tasaInteres * 0.01);
            double cuotasPagar = amortizacion + interes;
            cuotaPagar.add(cuotasPagar);
            costo -= amortizacion;
        }
        return cuotaPagar;
    }

    public void mostrarCuotas(List<Double> cuotaPagar) {
        for (double d : cuotaPagar) {
            System.out.println(d);
        }
    }

    public static void main(String args[]) {
        
    }
}
