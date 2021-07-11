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
 * @author Eliot
 */
public class Consulta {
  private LocalDate fechaInicio; 
  private String codigoPropiedad;
  private Agente agente;
  private Cliente cliente;
  private String pregunta;
  private String respuesta;
  private Estado estado;
  
    public Consulta(LocalDate fechaInicio, String codigoPropiedad, Agente agente, Cliente cliente, String pregunta, Estado estado){
     this.fechaInicio = fechaInicio;
     this.codigoPropiedad = codigoPropiedad;
     this.agente = agente;
     this.cliente = cliente;
     this.pregunta = pregunta;
     this.estado = estado;
  }
  
  
  
  
  
  
          
  
}
