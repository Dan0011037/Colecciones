package DanielaAbellan_Examen;

import Practica2_biblioteca.FicheroBiblioteca;
import Practica2_biblioteca.Socio;

import java.io.*;
import java.util.Scanner;

public class MainReparacion {
    private static Taller miTaller = new Taller();
    private static Scanner sc = new Scanner(System.in);

    public static void menu(){
        System.out.println("""
                -----------------
                MENU DE OPCIONES
                -----------------
                0. Salir
                1. Abrir orden de reparacion
                2. Cerrar orden
                3. Listar ordenes de reparacion
                4. Listar vehiculos disponibles

                """);
    }

    public static void abrirOrden(){
        System.out.println("--APERTURA DE ORDENES--");
        System.out.println("DNI del cliente:");
        String dni = sc.nextLine();
        if (!miTaller.misClientes.containsKey(dni)){
            System.out.println("Cliente no existe, desea añadirlo?:");
            String sino= sc.nextLine();
            if (sino.equalsIgnoreCase("si")) {
                System.out.println("Nombre del socio: ");
                String nombre = sc.nextLine();
                miTaller.registrarCliente(new Cliente(dni,nombre));
            }
        }
        System.out.println("Matricula del vehiculo:");
        String matricula = sc.nextLine();
        System.out.println("Horas estimadas:");
        int horas = sc.nextInt();
        if (miTaller.crearOrdenReparacion(dni, matricula, horas)){
            System.out.println("Orden realizada!");
        }else{
            System.out.println("No se ha podido realizar la orden");
        }
    }

    public static void cerrarOrden(){
        System.out.println("--CIERRE DE ORDENES--");
        System.out.println("Matricula del vehiculo:");
        String matricula = sc.nextLine();
        if (miTaller.cerrarOrdenReparacion(matricula)){
            System.out.println("Orden cerrada");
        }else{
            System.out.println("No se ha podido cerrar la orden");
        }
    }

    public static void listarOrdenes(){
        System.out.println("--LISTA DE ORDENES--");
        miTaller.listarOrdenes();
    }

    public static void listarVehiculosDisponibles(){
        System.out.println("--LISTA DE VEHICULOS--");
        miTaller.listarVehiculosDisponibles();
    }

    public static void listarClientes(){
        System.out.println("--LISTA DE CLIENTES--");
        miTaller.listarClientes();
    }

    public static void registro(){
        miTaller.registrarCliente(new Cliente("Daniela Abellan", "782480638Z"));
        miTaller.registrarCliente(new Cliente("Eduardo", "00000000A"));

        miTaller.agregarVeihculo(new Industrial("marca1", "1234AB", 25.5, true, 5));
        miTaller.agregarVeihculo(new Industrial("marca2", "5678CD", 27, false, 2));
        miTaller.agregarVeihculo(new Turismo("marca3", "9012EF", 14.2, false, 5));
        miTaller.agregarVeihculo(new Turismo("marca4", "3456GH", 18, true, 5));
        miTaller.agregarVeihculo(new Industrial("marca6", "7890IJ", 20, false, 7));
    }

    public static void main(String[] args) throws IOException {
        FicheroReparacion fichero = new FicheroReparacion(miTaller);

        try{
            fichero.cargarOrdenes();
        }catch(IOException e) {
            System.out.println("No hay datos");
            registro();
        }


        boolean continuar = true;
        int opcion;
        registro();
        while (continuar) {
            System.out.println("--------------------- \n" +
                    "Clientes actuales: ");
            listarClientes();
            menu();
            System.out.println("Elija: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    abrirOrden();
                    break;
                case 2:
                    cerrarOrden();
                    break;
                case 3:
                    listarOrdenes();
                    break;
                case 4:
                    listarVehiculosDisponibles();
                    break;
                case 0:
                    System.out.println("Adios");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }
        System.out.println("guardando...");
        fichero.guardarOrdenes();
    }
}
