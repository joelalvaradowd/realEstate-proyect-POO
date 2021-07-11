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

    private static ArrayList<Propiedad> propiedades = Administrador.obtenerPropiedades();

    public static List<Propiedad> filtrarPropiedades(double precioMax, double precioMin, String tipo, String ciudad, String sector) {
        List<Propiedad> buscadas = new ArrayList<>();
        boolean buscaPrecio = (precioMax > 0) && (precioMin > 0);
        boolean buscaTipo = tipo != null;
        boolean buscaCiudad = ciudad != null;
        boolean buscaSector = sector != null;
        if (buscaPrecio && !buscaTipo && !buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarPrecio(precioMax, precioMin));
        } else if (buscaPrecio && buscaTipo && !buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarPrecioTipo(precioMax, precioMin, tipo));
        } else if (buscaPrecio && !buscaTipo && buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarPrecioCiudad(precioMax, precioMin, ciudad));
        } else if (buscaPrecio && !buscaTipo && !buscaCiudad && buscaSector) {
            buscadas.addAll(buscarPrecioSector(precioMax, precioMin, sector));
        } else if (buscaPrecio && buscaTipo && buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarPrecioTipoCiudad(precioMax, precioMin, tipo, ciudad));
        } else if (buscaPrecio && buscaTipo && !buscaCiudad && buscaSector) {
            buscadas.addAll(buscarPrecioTipoSector(precioMax, precioMin, tipo, sector));
        } else if (buscaPrecio && buscaTipo && buscaCiudad && buscaSector) {
            buscadas.addAll(buscarPrecioTipoCiudadSector(precioMax, precioMin, tipo, ciudad, sector));
        } else if (!buscaPrecio && buscaTipo && !buscaCiudad && !buscaSector) {
            buscadas.addAll(buscarTipo(tipo));
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
        return buscadas;

    }

    public static Propiedad buscarPropiedad(String codigo, List<Propiedad> filtradas) {
        for (Propiedad p : filtradas) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

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
            } else if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("vivienda") && p instanceof Casa) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioCiudad(double precioMax, double precioMin, String ciudad) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && p.getCiudad().equals(ciudad)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioSector(double precioMax, double precioMin, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioTipoCiudad(double precioMax, double precioMin, String tipo, String ciudad) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad)) {
                buscar.add(p);
            } else if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioTipoSector(double precioMax, double precioMin, String tipo, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getSector().equals(sector)) {
                buscar.add(p);
            } else if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioTipoCiudadSector(double precioMax, double precioMin, String tipo, String ciudad, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
                buscar.add(p);
            } else if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarTipo(String tipo) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isVendida() && tipo.equals("terreno") && p instanceof Terreno) {
                buscar.add(p);
            } else if (!p.isVendida() && tipo.equals("vivienda") && p instanceof Casa) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarTipociudad(String tipo, String ciudad) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad)) {
                buscar.add(p);
            } else if (!p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarTipoSector(String tipo, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getSector().equals(sector)) {
                buscar.add(p);
            } else if (!p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarTipoCiudadSector(String tipo, String ciudad, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isVendida() && tipo.equals("terreno") && p instanceof Terreno && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
                buscar.add(p);
            } else if (!p.isVendida() && tipo.equals("vivienda") && p instanceof Casa && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarCiudad(String ciudad) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isVendida() && p.getCiudad().equals(ciudad)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarCiudadSector(String ciudad, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getSector().equals(sector) && p.getCiudad().equals(ciudad) && !p.isVendida()) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarPrecioCiudadSector(double precioMax, double precioMin, String ciudad, String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > precioMin && p.getPrecio() < precioMax && !p.isVendida() && p.getCiudad().equals(ciudad) && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public static List<Propiedad> buscarSector(String sector) {
        List<Propiedad> buscar = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (!p.isVendida() && p.getSector().equals(sector)) {
                buscar.add(p);
            }
        }
        return buscar;
    }

    public void mostrarPropiedades(List<Propiedad> propiedades) {
        for (Propiedad p : propiedades) {
            System.out.println(p);
        }
    }

    
  
}
