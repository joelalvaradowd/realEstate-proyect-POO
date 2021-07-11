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
public class Consulta implements Comparable<Consulta>{

    private LocalDate fechaInicio;    
    private Propiedad propiedad;
    private Agente agente;
    private Cliente cliente;
    private String pregunta;
    private String respuesta;
    private Estado estado;
    private LocalDate fechaRespuesta;
    
    public Consulta(LocalDate fechaInicio, Propiedad propiedad, Agente agente, Cliente cliente, String pregunta, Estado estado) {
        this.fechaInicio = fechaInicio;
        this.propiedad = propiedad;
        this.agente = agente;
        this.cliente = cliente;
        this.pregunta = pregunta;
        this.estado = estado;
        respuesta = null;
        fechaRespuesta = null;
        agente.agregarConsulta(this);
    }
    
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }
    
    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
    
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }
    
    public Propiedad getPropiedad() {
        return propiedad;
    }
    
    public Agente getAgente() {
        return agente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public String getPregunta() {
        return pregunta;
    }
    
    public String getRespuesta() {
        return respuesta;
    }
    
    public Estado getEstado() {
        return estado;
    }

    @Override
    public int compareTo(Consulta o) {
        return Integer.valueOf(propiedad.getCodigo()) - Integer.valueOf(o.getPropiedad().getCodigo());
    }
    
}
