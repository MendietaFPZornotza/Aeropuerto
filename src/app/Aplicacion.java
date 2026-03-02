package app;

import java.io.*;
import java.util.*;

public class Aplicacion {
	//GitHubProba
	//Bigarren push-a
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Vuelo> listaVuelos = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    // ============================================================
    // MENÚ (estático)
    // ============================================================
    public static void menuPrincipal() {

        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1 – Cargar vuelos desde archivo");
            System.out.println("2 – Listar vuelos");
            System.out.println("3 – Agregar un pasajero a un vuelo");
            System.out.println("4 – Buscar vuelo y modificar número de pasajeros");
            System.out.println("5 – Guardar en nuevo archivo");
            System.out.println("6 – Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    listaVuelos = leerArchivo("C:\\Users\\lorea\\Downloads\\Aeropuerto\\src\\Vuelos.txt");
                    break;
                    
                case 2:
                    imprimirVuelos(listaVuelos);
                    break;
                    
                case 3:
                    agregarPasajeroVuelo(listaVuelos);
                    break;
             
                case 4:
                    Vuelo v = buscarVuelo(listaVuelos);
                    if (v == null) {
                        System.out.println("El vuelo no existe.");
                        break;
                    }
                    int nuevo = solicitarNumeroPasajeros();
                    v.setNumeroPasajeros(nuevo);
                    imprimirInforme(v);
                    break;

                case 5:
                    guardarArchivo("Vuelos_nuevo.txt", listaVuelos);
                    break;
              
                case 6:
                    System.out.println("¡Adiós!");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
               
            }   

        } while (opcion != 6);
    }

    // ============================================================
    // PROCEDIMIENTOS
    // ============================================================

    public static ArrayList<Vuelo> leerArchivo(String nombre) {
        ArrayList<Vuelo> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombre));
            br.readLine(); // saltar cabecera

            String line;
            while ((line = br.readLine()) != null) {

                String[] z = line.split(":");

                String codigo = z[0];
                String codigoPiloto = z[1];
                int num = Integer.parseInt(z[2]);
                int precio = Integer.parseInt(z[3]);

                Piloto p = crearPilotoAutomatico(codigoPiloto);

                lista.add(new Vuelo(codigo, p, num, precio));
            }
            br.close();
            System.out.println("¡Vuelos cargados!");

        } catch (Exception e) {
            System.out.println("Error al leer el archivo.");
        }

        return lista;
    }

    public static Piloto crearPilotoAutomatico(String codigoPiloto) {
        return new Piloto(
                "Piloto" + codigoPiloto,
                "Test",
                "000" + codigoPiloto,
                codigoPiloto,
                100
        );
    }
    
    public static void imprimirInforme(Vuelo h) {
        System.out.println("==== INFORME ====");
        System.out.println("VUELO: " + h.getCodigoVuelo());
        System.out.println("Piloto: " + h.getPiloto().getNombre());
        System.out.println("Número de pasajeros: " + h.getNumeroPasajeros());
        System.out.println("Precio final: " + h.obtenerPrecioVuelo());
        System.out.println("==================\n");
    }
    
    public static void imprimirVuelos(ArrayList<Vuelo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vuelos cargados.");
            return;
        }
        System.out.println("\n===== Vuelos =====");
        for (Vuelo v : lista) System.out.println(v);
    }

    public static Vuelo buscarVuelo(ArrayList<Vuelo> lista) {
        System.out.print("Escribe el código del vuelo: ");
        String codigo = sc.nextLine();
       
        for (Vuelo v : lista)
            if (v.getCodigoVuelo().equalsIgnoreCase(codigo))
                return v;
       
        return null;
    }

    public static int solicitarNumeroPasajeros() {
        int num;

        do {
            System.out.print("Introduce el número de pasajeros (1-500): ");
            num = sc.nextInt();
            sc.nextLine(); // limpiar buffer
        } while (num < 1 || num > 500);

        return num;
    }

    public static void guardarArchivo(String nombre, ArrayList<Vuelo> lista) {
        try {
            PrintWriter pw = new PrintWriter(nombre);
            pw.println("codigoVuelo:codigoPiloto:numeroPasajeros:precioPorPasajero");

            for (Vuelo v : lista)
                pw.println(v.getCodigoVuelo() + ":" +
                           v.getPiloto().getCodigoPiloto() + ":" +
                           v.getNumeroPasajeros() + ":" +
                           v.getPrecioPorPasajero());

            pw.close();

            System.out.println("¡Archivo actualizado!");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo.");
        }
    }
    
    public static void agregarPasajeroVuelo(ArrayList<Vuelo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vuelos cargados.");
            return;
        }

        // Solicitar código del vuelo
        System.out.print("Introduce el código del vuelo para agregar pasajero: ");
        String codigo = sc.nextLine();
      
        Vuelo v = null;
        for (Vuelo aux : lista) {
            if (aux.getCodigoVuelo().equalsIgnoreCase(codigo)) {
                v = aux;
                break;
            }
        }

        if (v == null) {
            System.out.println("El vuelo no existe.");
            return;
        }

        // Solicitar datos del pasajero
        System.out.print("Introduce el nombre del pasajero: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el apellido del pasajero: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce el DNI/ID del pasajero: ");
        String id = sc.nextLine();
        
        System.out.print("Introduce la nacionalidad del pasajero: ");
        String nacionalidad = sc.nextLine();

        // Crear pasajero y agregar a la lista
        Viajero p = new Viajero(nombre, apellido, id, nacionalidad);
        if (v.agregarPasajero(p)) 
            System.out.println("Pasajero agregado correctamente: " + p.getNombre() + " " + p.getApellido());
        else 
            System.out.println("¡No se puede agregar el pasajero!");
    }
}

