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
public class CalculadoraPrestamoAleman extends CalculadoraPrestamo{
    
    public CalculadoraPrestamoAleman(double costo, double tasaInteres, int cuotas){
        super(costo,tasaInteres,cuotas);
        
    }
    @Override
    public double calculadoraPrestamo(){
        return 0;
        
    }
}
