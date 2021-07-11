/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import vista.Sistema;

/**
 *
 * @author User
 */
public class Administrador extends Usuario {

    private ArrayList<Agente> agentes;
    private static ArrayList<Propiedad> propiedades = new ArrayList<>();
    private static int i = 0;
    private static int codigoAgente = 0;
    private static int codigo = 0;

    public Administrador(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
        agentes = new ArrayList<>();
        agregarPropiedades();

    }
    
    public void mostrarPropiedades(){
        for(Propiedad p: propiedades){
            System.out.println(p);
        }
    }


    public static ArrayList<Propiedad> obtenerPropiedades() {
        return propiedades;
    }

    public static void agregarPropiedades() {
        propiedades.add(new Terreno("34", 30000, 30, 10, "guayas", "guayaquil", "Guayas, Guayaquil, Norte, Cdla Kennedy", "norte", "Bonito terreno en calle comercial", false, TipoTerreno.VIVIENDA));
        propiedades.add(new Terreno("35", 40000, 40, 10, "guayas", "guayaquil", "La chala, por la sana sana", "norte", "Arriba de una farmacia", false, TipoTerreno.VIVIENDA));
        propiedades.add(new Casa("76", 70000, 18, 10, "guayas", "guayaquil", "Sur, cdla Domingo sabia 250", "sur", "Ciudadela tranquilo y segura", false, 2, 5));
        propiedades.add(new Terreno("23", 80000, 22, 15, "imbabura", "ibarra", "Norte, La Victoria 240s", "norte", "Buen lugar para negocio, esquinero", false,TipoTerreno.COMERCIAL));
        propiedades.add(new Casa("44", 60000, 15, 7, "guayas", "guayaquil", "SurOeste, 24ava y la ch", "surOeste", "Casa familiar muy amplia", false, 2, 3));
        propiedades.add(new Casa("88", 50000, 13, 8, "Santa Elena", "Salinas", "Sur, Las palmas 350s", "sur", "Casa bonita cerca de la playa", false, 2, 5));
        propiedades.add(new Terreno("62", 100000, 30, 21, "manabi", "manta", "centro, Los olivos 1350c", "centro", "Lugar empresarial cerca del centro", false, TipoTerreno.EMPRESARIAL));
        propiedades.add(new Terreno("86", 90000, 23, 16, "guayas", "guayaquil", "Norte, Victor Emilio estrada y las monjas", "Norte", "Zona muy comecial en urdesa", false, TipoTerreno.COMERCIAL));
        propiedades.add(new Casa("96", 75000, 20, 13, "pichincha", "quito", "Sur, Avenida Paramericana 360s", "sur", "casa muy amplia en sector seguro", false, 3, 6));
        propiedades.add(new Terreno("106", 40000, 18, 10, "guayas", "guayaquil", "Norte, Lomas de la Alborada", "norte", "Lugar muy concurrido y seguro", false,TipoTerreno.VIVIENDA));
    }

    public void registrarPropiedad(Propiedad p) {
        propiedades.add(p);
        if (i < agentes.size()) {
            agentes.get(i).seguirPropiedad(p);
            i++;
        }
        if (i >= agentes.size()) {
            i = 0;
        }
    }

    public void registrarAgente(Agente a) {
        agentes.add(a);
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int elec;
        do {
            System.out.println("Menu de administrador");
            System.out.println("1.Registrar propiedad");
            System.out.println("2.Registrar agente");
            System.out.println("3.Reporte contactos y ventas");
            System.out.println("4.Cerrar sesion");
            System.out.println("5. Ver propiedades y agentes");
            System.out.print("Elija una opcion: ");
            elec = sc.nextInt();
            sc.nextLine();
            switch (elec) {
                case 1: {
                    System.out.print("Ingrese el tipo de propiedad(casa o terreno) que desea ingresar: ");
                    String propiedad = sc.nextLine();
                    while (!propiedad.equals("casa") && !propiedad.equals("terreno")) {
                        System.out.println("No ha ingresado ninguna de las 2 opciones");
                        System.out.print("Ingrese el tipo de propiedad(casa o terreno) que desea ingresar: ");
                        propiedad = sc.nextLine();

                    }
                    if (propiedad.equals("terreno")) {
                        System.out.print("Ingrese el precio del terreno:");
                        double precio = sc.nextDouble();
                        System.out.print("Ingrese el ancho del terreno en metros:");
                        double ancho = sc.nextDouble();
                        System.out.print("Ingrese la profundidad del terreno en metros: ");
                        double profundidad = sc.nextDouble();
                        System.out.print("Ingrese la ciudad donde se encuentra el terreno:");
                        sc.nextLine();
                        String ciudad = sc.nextLine();
                        System.out.print("Ingrese la direccion donde se encuentra el terreno:");
                        String direccion = sc.nextLine();
                        System.out.print("Ingrese el sector donde se encuentra el terreno: ");
                        String sector = sc.nextLine();
                        System.out.print("Ingrese la provincia:");
                        String provincia = sc.nextLine();
                        System.out.print("Ingrese el tipo de terreno:");
                        String tipo = sc.nextLine();
                        TipoTerreno tipoT = TipoTerreno.valueOf(tipo.toUpperCase());
                        System.out.print("Ingrese una descripcion del terreno: ");
                        String descripcion = sc.nextLine();
                        codigo++;
                        propiedades.add(new Terreno(String.valueOf(codigo), precio, ancho, profundidad, provincia, ciudad, direccion, sector, descripcion, false, tipoT));
                        break;
                    } else if (propiedad.equals("casa")) {
                        System.out.print("Ingrese el precio de la casa:");
                        double precio = sc.nextDouble();
                        System.out.print("Ingrese el ancho de la casa en metros:");
                        double ancho = sc.nextDouble();
                        System.out.print("Ingrese la profundidad de la casa en metros: ");
                        double profundidad = sc.nextDouble();
                        System.out.print("Ingrese la ciudad donde se encuentra la casa:");
                        sc.nextLine();
                        String ciudad = sc.nextLine();
                        System.out.print("Ingrese la direccion donde se encuentra la casa:");
                        String direccion = sc.nextLine();
                        System.out.print("Ingrese el sector donde se encuentra la casa: ");
                        String sector = sc.nextLine();
                        System.out.print("Ingrese la provincia donde se encuentre la casa:");
                        String provincia = sc.nextLine();
                        System.out.print("Ingrese el numero de pisos:");
                        int pisos = sc.nextInt();
                        System.out.print("Ingrese el numero de habitaciones:");
                        int habitaciones = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Agregue una descripcion de la casa:");
                        String descripcion = sc.nextLine();
                        codigo++;
                        propiedades.add(new Casa(String.valueOf(codigo), precio, ancho, profundidad, provincia, ciudad, direccion, sector, descripcion, false, pisos, habitaciones));
                        break;
                    }
                }
                case 2: {
                    System.out.print("Ingrese el nombre del agente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Ingrese el correo eletronico: ");
                    String correo = sc.nextLine();
                    System.out.print("Ingrese el usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String password = sc.nextLine();
                    codigoAgente++;
                    Usuario u = new Agente(String.valueOf(codigoAgente), usuario, password, cedula, nombre, correo);
                    agentes.add((Agente) u);
                    Sistema.agregarUsuario(u);
                    break;
                }
                case 3: {
                    tableWithLinesAndMaxWidth(agentes);
                    System.out.println("Ingrese la fecha minima(dia-mes-año)");
                    LocalDate fechaMinima;
                    String fmin=sc.nextLine();
                    if(fmin.isEmpty()){
                        fechaMinima=null;
                    }
                    else{
                        String[] num=fmin.split("-");
                        fechaMinima = LocalDate.of(Integer.parseInt(num[2]), Integer.parseInt(num[1]), Integer.parseInt(num[0]));
                    }
                    System.out.println("Ingrese la fecha minima(dia-mes-año)");
                    LocalDate fechaMaxima;
                    String fmax=sc.nextLine();
                    if(fmax.isEmpty()){
                        fechaMaxima=null;
                    }
                    else{
                        String[] num=fmax.split("-");
                        fechaMaxima = LocalDate.of(Integer.parseInt(num[2]), Integer.parseInt(num[1]), Integer.parseInt(num[0]));
                    }
                    break;
                }
                case 4: {
                    System.out.println("Volviendo al menú anterior...");
                    break;
                }
                case 5: {
                    System.out.println(propiedades);
                    System.out.println(agentes);
                    break;
                }
                default:
                    System.out.println("Opcion inválida");
                    break;
            }
        } while (elec != 4);
    }
    
      public static void tableWithLinesAndMaxWidth(List<Agente> agentes) {
        String[][] table = new String[agentes.size() + 1][6];
        table[0][0] = "Agente";
        table[0][1] = "Numero Ventas";
        table[0][2] = "Numero de respuestas";

        int k = 1;
        for (Agente p : agentes) {
            table[k][0] = p.getCodigo();
            table[k][1] = String.valueOf(p.getNumVentas());
            table[k][2] = String.valueOf(p.getNumRespuestas());
            k++;
        }
        /*
	 * leftJustifiedRows - If true, it will add "-" as a flag to format string to
	 * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = true;

        /*
	 * Maximum allowed width. Line will be wrapped beyond this width.
         */
        int maxWidth = 30;

        /*
	 * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */

 /*
	 * Create new table array with wrapped rows
         */
        List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
        List<String[]> finalTableList = new ArrayList<>();
        for (String[] row : tableList) {
            // If any cell data is more than max width, then it will need extra row.
            boolean needExtraRow = false;
            // Count of extra split row.
            int splitRow = 0;
            do {
                needExtraRow = false;
                String[] newRow = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    // If data is less than max width, use that as it is.
                    if (row[i].length() < maxWidth) {
                        newRow[i] = splitRow == 0 ? row[i] : "";
                    } else if ((row[i].length() > (splitRow * maxWidth))) {
                        // If data is more than max width, then crop data at maxwidth.
                        // Remaining cropped data will be part of next row.
                        int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
                                ? (splitRow * maxWidth) + maxWidth
                                : row[i].length();
                        newRow[i] = row[i].substring((splitRow * maxWidth), end);
                        needExtraRow = true;
                    } else {
                        newRow[i] = "";
                    }
                }
                finalTableList.add(newRow);
                if (needExtraRow) {
                    splitRow++;
                }
            } while (needExtraRow);
        }
        String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
        for (int i = 0; i < finalTable.length; i++) {
            finalTable[i] = finalTableList.get(i);
        }

        /*
	 * Calculate appropriate Length of each column by looking at width of data in
	 * each column.
	 * 
	 * Map columnLengths is <column_number, column_length>
         */
        Map<Integer, Integer> columnLengths = new HashMap<>();
        Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
            if (columnLengths.get(i) == null) {
                columnLengths.put(i, 0);
            }
            if (columnLengths.get(i) < a[i].length()) {
                columnLengths.put(i, a[i].length());
            }
        }));

        /*
	 * Prepare format String
         */
        final StringBuilder formatString = new StringBuilder("");
        String flag = leftJustifiedRows ? "-" : "";
        columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
        formatString.append("|\n");


        /*
	 * Prepare line for top, bottom & below header row.
         */
        String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        line = line + "+\n";

        /*
	 * Print table
         */
        System.out.print(line);
        Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
        System.out.print(line);

        Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
                .forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
        System.out.print(line);
    }
}
