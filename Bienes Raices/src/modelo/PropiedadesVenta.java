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
 * @author Eliot
 */
public class PropiedadesVenta {

    private double precio;
    private String tipo;
    private String ciudad;
    private String sector;
    private static ArrayList<Propiedad> propiedades;

//    public static List<Propiedad> filtrarPropiedades(double precioMax, double precioMin, String tipo, String ciudad, String sector) {
//        List<Propiedad> propiedadesBuscadas = new ArrayList<>();
//        for (Propiedad p : propiedades) {
//
//            if (p.getPrecio() > precioMax && p.getPrecio() < precioMin && tipo != null && ciudad != null && sector != null) {
//                if (p.getPrecio() == precio && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
//                    propiedadesBuscadas.add(p);
//                }
//                if (p.getPrecio() == precio && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio > 0 && tipo != null && ciudad != null && sector == null) {
//                if (p.getPrecio() == precio && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad)) {
//                    propiedadesBuscadas.add(p);
//                }
//                if (p.getPrecio() == precio && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio > 0 && tipo != null && ciudad == null && sector == null) {
//                if (p.getPrecio() == precio && tipo.equals("terreno") && p instanceof Terreno) {
//                    propiedadesBuscadas.add(p);
//                }
//                if (p.getPrecio() == precio && tipo.equals("vivienda") && p instanceof Casa) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio > 0 && tipo == null && ciudad == null && sector == null) {
//                if (p.getPrecio() == precio) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio == 0 && tipo == null && ciudad == null && sector == null) {
//                propiedadesBuscadas.add(p);
//            }
//
//            if (precio == 0 && tipo != null && ciudad != null && sector != null) {
//                if (tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
//                    propiedadesBuscadas.add(p);
//                }
//                if (tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio == 0 && tipo != null && ciudad != null && sector == null) {
//                if (tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad)) {
//                    propiedadesBuscadas.add(p);
//                }
//                if (tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio == 0 && tipo != null && ciudad == null && sector == null) {
//                if (tipo.equals("terreno") && p instanceof Terreno) {
//                    propiedadesBuscadas.add(p);
//                }
//                if (tipo.equals("vivienda") && p instanceof Casa) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio == 0 && tipo == null && ciudad != null && sector != null) {
//                if (p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio == 0 && tipo == null && ciudad != null && sector == null) {
//                if (p.getCiudad().equals(ciudad)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//
//            if (precio == 0 && tipo == null && ciudad == null && sector != null) {
//                if (p.getSector().equals(sector)) {
//                    propiedadesBuscadas.add(p);
//                }
//            }
//        }
//        List<Propiedad> noVendidas = new ArrayList<>();
//        for (Propiedad p : propiedadesBuscadas) {
//            if (!p.isVendida()) {
//                noVendidas.add(p);
//            }
//        }
//        return noVendidas;
//
//    }
    public static List<Propiedad> buscarPrecio(double precioMax, double precioMin) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida()) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioTipo(double precioMax, double precioMin, String tipo) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("terreno") && p instanceof Terreno) {
                buscar.add(p);
            }
            else if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("vivienda") && p instanceof Casa){
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static void main(String[] args) {
        propiedades = new ArrayList<>();
        propiedades.add(new Terreno("1", 3000, 25.9, 30, "guayas", "guayaquil", "tulcan y azuay", "sur", "bonita casa", false, TipoTerreno.VIVIENDA));
        propiedades.add(new Terreno("2", 30, 40, 50, "guayas", "machala", "tulcan y azuay", "norte", "bonita casa", false, TipoTerreno.VIVIENDA));
        propiedades.add(new Casa("3", 30, 0, 0, "el oro", "machala", "casa de dos pisos", "sur", "sfsgvsd", false, 0, 0));
        propiedades.add(new Casa("4", 30, 0, 0, "esmeraldas", "esmeraldas", "casa de dos pisos", "sur", "sfsgvsd", false, 0, 0));
        propiedades.add(new Casa("5", 20, 0, 0, "el oro", "machala", "casa de dos pisos", "sur", "sfsgvsd", true, 0, 0));
        mostrarPropiedades(filtrarPropiedades(3000, null, "guayaquil", null));
        // precio, tipo, ciudad, sector

    }

    public static void mostrarPropiedades(List<Propiedad> propiedades) {
        for (Propiedad p : propiedades) {
            System.out.println(p);
        }
    }

}
