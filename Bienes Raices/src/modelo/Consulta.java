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
  private String agente;
  private String pregunta;
  private String respuesta;
  private enum Estado{};
  private ArrayList<Conversacion> conversaciones;
  
          
  
}
