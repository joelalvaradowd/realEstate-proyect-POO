/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class CalculadoraPrestamoFrances extends CalculadoraPrestamo{
    public CalculadoraPrestamoFrances(double costo,double tasaInteres,int cuotas){
        super(costo,tasaInteres,cuotas);
    }
    @Override
    public double calculadoraPrestamo() {
        Scanner sc=new Scanner(System.in);
        double c=super.getCosto();
        double t=super.getTasaInteres();
        int cuota=super.getCuotas();
        int menosAnios=cuota;
        double totalPagar=c;
        
        while(menosAnios>0){
            double cuotaMonto=c*((t*0.01)/1-(1+Math.pow(t*0.01,(-cuota))));
            double interesMonto=c*(t*0.01);
            double reduccionCapital=cuotaMonto-interesMonto;
            double capitalAdeudado=c-reduccionCapital;
            c=capitalAdeudado;
            totalPagar+=interesMonto;
            menosAnios--;
        }
        return totalPagar;
    }
}
