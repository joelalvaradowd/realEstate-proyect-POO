/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
//import javax.mail.Session;

/**
 *
 * @author User
 */
public class Alerta {

    private String tipo;
    private double precioMax;
    private double precioMin;
    private String ciudad;
    private String sector;
    private String to;

    public Alerta(String tipo, double precioMax, double precioMin, String ciudad, String sector, String to) {
        this.tipo = tipo;
        this.precioMax = precioMax;
        this.precioMin = precioMin;
        this.ciudad = ciudad;
        this.sector = sector;
        this.to = to;
    }

    public boolean enviarAlerta(Propiedad p) {
        boolean buscaPrecio = (precioMax > 0) && (precioMin > 0);
        boolean buscaTipo = tipo != null;
        boolean buscaCiudad = ciudad != null;
        boolean buscaSector = sector != null;
        if (buscaPrecio && !buscaTipo && !buscaCiudad && !buscaSector) {
            return buscarPrecio(p);
        } else if (buscaPrecio && buscaTipo && !buscaCiudad && !buscaSector) {
            return buscarPrecioTipo(p);
        } else if (buscaPrecio && !buscaTipo && buscaCiudad && !buscaSector) {
            return buscarPrecioCiudad(p);
        } else if (buscaPrecio && !buscaTipo && !buscaCiudad && buscaSector) {
            return buscarPrecioSector(p);
        } else if (buscaPrecio && buscaTipo && buscaCiudad && !buscaSector) {
            return buscarPrecioTipoCiudad(p);
        } else if (buscaPrecio && buscaTipo && !buscaCiudad && buscaSector) {
            return buscarPrecioTipoSector(p);
        } else if (buscaPrecio && buscaTipo && buscaCiudad && buscaSector) {
            return buscarPrecioTipoCiudadSector(p);
        } else if (!buscaPrecio && buscaTipo && !buscaCiudad && !buscaSector) {
            return buscarTipo(p);
        } else if (!buscaPrecio && buscaTipo && buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarTipociudad(tipo, ciudad));
        } else if (!buscaPrecio && buscaTipo && !buscaCiudad && buscaSector) {
            buscadas.addAll(buscarTipoSector(tipo, sector));
        } else if (!buscaPrecio && buscaTipo && buscaCiudad && buscaSector) {
            buscadas.addAll(buscarTipoCiudadSector(tipo, ciudad, sector));
        } else if (!buscaPrecio && !buscaTipo && buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarCiudad(ciudad));
        } else if (!buscaPrecio && !buscaTipo && buscaCiudad && buscaSector) {
            buscadas.addAll(buscarCiudadSector(ciudad, sector));
        } else if (buscaPrecio && !buscaTipo && buscaCiudad && buscaSector) {
            buscadas.addAll(buscarPrecioCiudadSector(precioMax, precioMin, ciudad, sector));
        } else if (!buscaPrecio && !buscaTipo && !buscaCiudad && buscaSector) {
            buscadas.addAll(buscarSector(sector));
        }
    }

    public boolean buscarPrecio(Propiedad p) {
        return p.getPrecio() >= precioMin && p.getPrecio() <= precioMax;
    }

    public boolean buscarPrecioTipo(Propiedad p) {
        if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("terreno") && p instanceof Terreno) {
            return true;
        } else if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("vivienda") && p instanceof Casa) {
            return true;
        }
        return false;
    }

    public boolean buscarPrecioCiudad(Propiedad p) {

        return p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && p.getCiudad().equals(ciudad);

    }

    public boolean buscarPrecioSector(Propiedad p) {
        return p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && p.getSector().equals(sector);
    }

    public boolean buscarPrecioTipoCiudad(Propiedad p) {
        if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad)) {
            return true;
        } else if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad)) {
            return true;
        }
        return false;
    }

    public boolean buscarPrecioTipoSector(Propiedad p) {
        if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("terreno") && p instanceof Terreno && p.getSector().equals(sector)) {
            return true;
        } else if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("vivienda") && p instanceof Casa && p.getSector().equals(sector)) {
            return true;
        }
        return false;
    }

    public boolean buscarPrecioTipoCiudadSector(Propiedad p) {
        if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
            return true;
        } else if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
            return true;
        }
        return false;
    }

    public boolean buscarTipo(Propiedad p) {
        if (tipo.equals("terreno") && p instanceof Terreno) {
            return true;
        } else if (tipo.equals("vivienda") && p instanceof Casa) {
            return true;
        }
        return false;
    }

    public boolean buscarTipociudad(Propiedad p) {
        if (tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad)) {
            return true;
        } else if (tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad)) {
            return true;
        }
        return false;
    }

    public boolean buscarTipoSector(Propiedad p) {
        if (tipo.equals("terreno") && p instanceof Terreno && p.getSector().equals(sector)) {
            return true;
        } else if (tipo.equals("vivienda") && p instanceof Casa && p.getSector().equals(sector)) {
            return true;
        }
        return false;
    }

    public boolean buscarTipoCiudadSector(Propiedad p) {
        if (!p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
            return true;
        } else if (!p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
            return true;

        }
        return false;
    }

    public boolean buscarCiudad(Propiedad p) {
        return !p.isVendida() && p.getCiudad().equals(ciudad);

    }

    public boolean buscarCiudadSector(Propiedad p) {

        return p.getSector().equals(sector) && p.getCiudad().equals(ciudad) && !p.isVendida();

    }

    public boolean buscarPrecioCiudadSector(Propiedad p) {
        return p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && p.getCiudad().equals(ciudad) && p.getSector().equals(sector);

    }

    public boolean buscarSector(Propiedad p) {

        return !p.isVendida() && p.getSector().equals(sector);

    }

    public void mostrarPropiedades(List<Propiedad> propiedades) {
        for (Propiedad p : propiedades) {
            System.out.println(p);
        }
    }

}
