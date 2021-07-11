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
    private LocalDate fechaRespuesta;
    
    public Consulta(LocalDate fechaInicio, String codigoPropiedad, Agente agente, Cliente cliente, String pregunta, Estado estado) {
        this.fechaInicio = fechaInicio;
        this.codigoPropiedad = codigoPropiedad;
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
    
    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
    
    @Override
    public String toString() {
        return "Consulta{" + "fechaInicio=" + fechaInicio + ", codigoPropiedad=" + codigoPropiedad + ", agente=" + agente + ", cliente=" + cliente + ", pregunta=" + pregunta + ", respuesta=" + respuesta + ", estado=" + estado + '}';
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }
    
    public String getCodigoPropiedad() {
        return codigoPropiedad;
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
    
}
