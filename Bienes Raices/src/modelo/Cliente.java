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
public class Cliente extends Usuario {

    private LocalDate nacimiento;
    private List<Consulta> consultas = new ArrayList<>();
    private List<Propiedad> propiedades;
    private List<Alerta> alertas;

    public Cliente(String user, String password, String cedula, String nombre, String correo) {
        super(user, password, cedula, nombre, correo);
        propiedades = new ArrayList<>();
        for (Propiedad p : Administrador.obtenerPropiedades()) {
            if (p instanceof Terreno) {
                propiedades.add(new Terreno((Terreno) p));
            } else {
                propiedades.add(new Casa((Casa) p));
            }
        }

    }

    public List<Propiedad> obtenerPropiedades() {
        return propiedades;
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int elec;
        do {
            System.out.println("Menu de cliente");
            System.out.println("1.Consultar propiedades");
            System.out.println("2.Buzon de consultas");
            System.out.println("3.Crear alerta");
            System.out.println("4.Simular prestamo");
            System.out.println("5.Cerrar sesion");
            System.out.print("Elija una opcion:");
            elec = sc.nextInt();
            switch (elec) {
                case 1: {
                    System.out.println("Consultar propiedades");
                    sc.nextLine();
                    System.out.print("Tipo:");
                    String tipo;
                    String pt = sc.nextLine();
                    if (pt.isEmpty()) {
                        tipo = null;
                    } else {
                        tipo = pt;
                    }
                    System.out.print("Precio maximo:");
                    double rangomas;
                    String prmas = sc.nextLine();
                    if (prmas.isEmpty()) {
                        rangomas = 0;
                    } else {
                        rangomas = Double.parseDouble(prmas);
                    }
                    System.out.print("Precio minimo:");
                    double rangomenos;
                    String prmenos = sc.nextLine();
                    if (prmenos.isEmpty()) {
                        rangomenos = 0;
                    } else {
                        rangomenos = Double.parseDouble(prmenos);
                    }

                    sc.nextLine();
                    System.out.print("Ciudad:");
                    String ciudad;
                    String pc = sc.nextLine();
                    if (pc.isEmpty()) {
                        ciudad = null;
                    } else {
                        ciudad = pc;
                    }
                    System.out.print("Sector:");
                    String sector;
                    String ps = sc.nextLine();
                    if (ps.isEmpty()) {
                        sector = null;
                    } else {
                        sector = ps;
                    }
                    PropiedadesVenta pv = new PropiedadesVenta(this);
                    List<Propiedad> filtradas = pv.filtrarPropiedades(rangomas, rangomenos, tipo, ciudad, sector);
                    System.out.println();
                    System.out.println("Tipo           " + tipo);
                    System.out.println("Rango Precio   " + String.valueOf(rangomenos) + "-" + String.valueOf(rangomas));
                    System.out.println("Ciudad         " + ciudad);
                    System.out.println("Sector         " + sector);
                    tableWithLinesAndMaxWidth(filtradas);
                    System.out.print("Ingrese el código de la propiedad que desea más detalle(o vacío para regresar): ");
                    String cod = sc.nextLine();
                    if (!cod.isEmpty()) {
                        Propiedad p = pv.buscarPropiedad(cod, filtradas);
                        if (p != null) {
                            p.mostrarDetalles();
                            System.out.print("Desea realizar consulta (si/no):");
                            String respuesta = sc.nextLine();
                            if (respuesta.equals("si")) {
                                p.consultar();
                                Agente agente = Sistema.asignarAgente();
                                System.out.print("Ingrese su consulta:");
                                String pregunta = sc.nextLine();
                                consultas.add(new Consulta(LocalDate.now(), cod, agente, this, pregunta, Estado.ESPERANDO));
                                agente.agregarPropiedad(p);
                            }
                        } else {
                            System.out.println("código no válido");
                        }
                    }
                    break;

                }
                case 2: {
                    if (!consultas.isEmpty()) {
                        tableWithLinesAndMaxWidth2(consultas);
                        sc.nextLine();
                        System.out.print("Ingrese código de propiedad (o vacío para regresar):");
                        String cod = sc.nextLine();
                        if (!cod.isBlank() && existePropiedad(cod)) {
                            System.out.println("Conversación:");
                            mostrarConversacion(cod);
                            System.out.print("Desea agregar una pregunta o regresar (si/no):");
                            String resp = sc.nextLine();
                            if (resp.equals("si")) {
                                System.out.print("Ingrese la pregunta:");
                                String pregunta = sc.nextLine();
                                consultas.add(new Consulta(LocalDate.now(), cod, consultas.get(0).getAgente(), this, pregunta, Estado.ESPERANDO));
                            }
                        }

                    } else {
                        System.out.println("No ha hecho ninguna consulta");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Creando Alarma...");
                    double precio = 0;
                    String tipo = null, ciudad = null, sector = null;
                    System.out.print("Ingrese el precio:");
                    String price = sc.nextLine();
                    if (!price.isBlank()) {
                        precio = Double.parseDouble(price);
                    }
                }
                case 4:
                    sc.nextLine();
                    System.out.println("Calculadora de prestamos");
                    System.out.print("Seleccione el sistema de amortizacion(Aleman/frances): ");
                    String tipo = sc.nextLine();
                    System.out.print("Ingrese el costo del inmobiliario:");
                    double ci = sc.nextDouble();
                    System.out.print("Ingrese la tasa de interes:");
                    double ti = sc.nextDouble();
                    System.out.print("Ingrese el numero de cuotas mensuales:");
                    int cm = sc.nextInt();
                    if (tipo.equals("frances")) {
                        System.out.println("Sistema frances");
                        CalculadoraPrestamoFrances cf = new CalculadoraPrestamoFrances(ci, ti, cm);
                        cf.mostrarCuotas(cf.calculadoraPrestamo(ci, ti, cm));
                    } else if (tipo.equals("aleman")) {
                        System.out.println("Sistema Aleman");
                        CalculadoraPrestamoAleman ca = new CalculadoraPrestamoAleman(ci, ti, cm);
                        ca.mostrarCuotas(ca.calculadoraPrestamo(ci, ti, cm));
                    }
                    break;
            }

        } while (elec != 5);

    }

    public static void tableWithLinesAndMaxWidth(List<Propiedad> filtradas) {
        String[][] table = new String[filtradas.size() + 1][6];
        table[0][0] = "codigo";
        table[0][1] = "descripcion";
        table[0][2] = "precio";
        table[0][3] = "tamaño";
        table[0][4] = "ubicacion";
        table[0][5] = "consultada";

        int k = 1;
        for (Propiedad p : filtradas) {
            String consul;
            if (p.isConsultada()) {
                consul = "SI";
            } else {
                consul = "NO";
            }
            table[k][0] = p.getCodigo();
            table[k][1] = p.getDescripcion();
            table[k][2] = String.valueOf(p.getPrecio());
            table[k][3] = String.valueOf(p.getAncho() * p.getProfundidad());
            table[k][4] = p.getDireccion();
            table[k][5] = consul;
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

    public static void tableWithLinesAndMaxWidth2(List<Consulta> consultas) {
        String[][] table = new String[consultas.size() + 1][5];
        table[0][0] = "Fecha Inicio";
        table[0][1] = "Codigo Propiedad";
        table[0][2] = "Nombre Agente";
        table[0][3] = "Pregunta";
        table[0][4] = "Estado";

        int k = 1;
        for (Consulta c : consultas) {
            String state;
            if (c.getEstado() == Estado.ESPERANDO) {
                state = "Esperando";
            } else {
                state = "Respondido";
            }
            table[k][0] = String.valueOf(c.getFechaInicio());
            table[k][1] = c.getCodigoPropiedad();
            table[k][2] = c.getAgente().getNombre();
            table[k][3] = c.getPregunta();
            table[k][4] = state;
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

    public boolean existePropiedad(String cod) {
        for (Consulta c : consultas) {
            if (c.getCodigoPropiedad().equals(cod)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarConversacion(String cod) {
        for (Consulta c : consultas) {
            if (c.getCodigoPropiedad().equals(cod)) {
                String fechaPregunta = String.valueOf(c.getFechaInicio());
                String fechaRespuesta = String.valueOf(c.getFechaRespuesta());
                String pregunta = c.getPregunta();
                String respuesta = c.getRespuesta();
                if (pregunta != null) {
                    System.out.println(fechaPregunta + ": " + "Cliente: " + pregunta);
                }
                if (respuesta != null) {
                    System.out.println(fechaRespuesta + ": " + "Agente: " + respuesta);
                }
            }
        }
    }
}
