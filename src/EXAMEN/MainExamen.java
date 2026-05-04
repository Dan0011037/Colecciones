package EXAMEN;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExamen {
    private static Hotel miHotel = new Hotel();
    private static Scanner sc = new Scanner(System.in);

    public static void Clientes(){
        miHotel.registrarCliente(new Clientes("78248038Z", "Daniela"));
        miHotel.registrarCliente(new Clientes("78248039Z", "Martin"));
    }

    public static void Habitaciones(){
        miHotel.agregarHabitacion(new HabitacionSimple(1, 12, false, true));
        miHotel.agregarHabitacion(new HabitacionSimple(2, 12, true, true));
        miHotel.agregarHabitacion(new HabitacionDoble(3, 18, false, true));
        miHotel.agregarHabitacion(new HabitacionDoble(4, 18, true, false));
    }

    public static void menu(){
        System.out.println("""
                -----------------
                MENU DE OPCIONES
                -----------------
                1. Reservar habitacion.
                2. Cancelar habitacion.
                3. Listar reservas.
                4. Listar las habitaciones disponibles.
                5. Salir.

                """);
    }
    public static void reservarHabitacion(){

        System.out.println("RESERVA DE HABITACION");
        System.out.println("DNI del cliente: ");
        String dni = sc.nextLine();
        if (!dni.equals(miHotel.misClientes)){
            System.out.println("Cliente no existe, desea añadirlo?:");
            String sino= sc.nextLine();
            if (sino.equalsIgnoreCase("si")){
                System.out.println("Nombre del cliente: ");
                String nombre = sc.nextLine();
                miHotel.registrarCliente(new Clientes(dni, nombre));
            }
        }
        System.out.println("Numero de la habitacion: ");
        int numero = sc.nextInt();
        System.out.println("Numero de noches de instancia: ");
        int noches = sc.nextInt();

        if (miHotel.reservarHab(dni,  numero, noches)) {
            System.out.println("Habitacion Reservada con exito");

        }else System.out.println("No se ha podido reservar");
    }


    public static void cancelarReserva() {
        System.out.println("CANCELAR RESERVA");
        System.out.println("Numero de la habitacion:");
        int numero = sc.nextInt();

        if (miHotel.cancelarReserva(numero)) {
            System.out.println("Habitacion cancelada con exito");
        }else System.out.println("No se ha podido cancelar");
    }

    public static void listarReservas(){
        miHotel.ImprimirReservas();
    }
    public static void listarLasHabitaciones(){
        miHotel.ImprimirHabitacionesDisponibles();
    }

    public static void main(String[] args) {
        Clientes();
        Habitaciones();

        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    reservarHabitacion();
                    break;
                case 2:
                    cancelarReserva();
                    break;
                case 3:
                    listarReservas();
                    break;
                case 4:
                    listarLasHabitaciones();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("No valido");
                    System.out.println("---");
                    break;
            }
        }
    }
}
