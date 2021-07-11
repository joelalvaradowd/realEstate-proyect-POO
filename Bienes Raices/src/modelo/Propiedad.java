/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eliot
 */
public class Propiedad {

    private String codigo;
    private double precio;
    private double ancho;
    private double profundidad;
    private String provincia;
    private String ciudad;
    private String direccion;
    private String sector;
    private String descripcion;
    private boolean vendida;
    private boolean consultada = false;
    private List<Consulta> consultas;
    private Scanner sc;

    public Propiedad(String codigo, double precio, double ancho, double profundidad, String provincia, String ciudad, String direccion, String sector, String descripcion, boolean vendida) {
        this.codigo = codigo;
        this.ancho = ancho;
        this.precio = precio;
        this.profundidad = profundidad;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.sector = sector;
        this.vendida = vendida;
        this.ciudad = ciudad;
        consultas = new ArrayList<>();
    }

    public Propiedad(Propiedad p) {
        this.codigo = p.codigo;
        this.ancho = p.ancho;
        this.precio = p.precio;
        this.profundidad = p.profundidad;
        this.provincia = p.provincia;
        this.descripcion = p.descripcion;
        this.direccion = p.direccion;
        this.sector = p.sector;
        this.vendida = p.vendida;
        this.ciudad = p.ciudad;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVendida() {
        return vendida;
    }

    public void setVendida(boolean vendida) {
        this.vendida = vendida;
    }

    public boolean isConsultada() {
        return consultada;
    }

    public void consultar() {
        if (!isConsultada()) {
            consultada = true;
        }
    }

    @Override
    public String toString() {
        return "Propiedad{" + "codigo=" + codigo + ", precio=" + precio + ", ancho=" + ancho + ", profundidad=" + profundidad + ", provincia=" + provincia + ", direccion=" + direccion + ", sector=" + sector + ", descripcion=" + descripcion + ", vendida=" + vendida + '}';
    }

    public void mostrarDetalles() {
        System.out.println("Detalles de la propiedad");
        System.out.println("Codigo: " + codigo);
        System.out.println("Precio: " + precio);
        System.out.println("Ancho: " + ancho);
        System.out.println("Profundidad: " + profundidad);
        System.out.println("Provincia: " + provincia);
        System.out.println("Dirección: " + direccion);
        System.out.println("Sector: " + sector);
        System.out.println("Descripcion: " + descripcion);

    }

}
