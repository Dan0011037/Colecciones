package Practica2_biblioteca;

import EXAMEN.Hotel;

import java.util.Scanner;

public class MainBiblioteca {
    private static Biblioteca miBiblioteca = new Biblioteca();
    private static Scanner sc = new Scanner(System.in);

    public static void registro(){
        miBiblioteca.registrarSocio(new Socio("78248038Z", "Daniela", "dabellancabrerizo@gmail.com"));
        miBiblioteca.registrarSocio(new Socio("22222222J" , "Pepe", "pepito@gmail.com"));

        miBiblioteca.agregarDocumento(new Libro("111a", "La caca", "Yo", true, 45, "Misterio"));
        miBiblioteca.agregarDocumento(new Libro("111b", "El pipi", "Tu", false, 54, "Cacota"));
        miBiblioteca.agregarDocumento(new Revista("111c", "El reves", "Nosotros", true, 23, "Cada tres dias"));
        miBiblioteca.agregarDocumento(new Revista("111d", "No seee", "Vosotros", true, 14, "Cada tres meses"));
    }

    public static void menu(){
        System.out.println("""
                ------------------
                MENU DE  OPCIONES
                ------------------
                1. Realizar prestamo
                2. Devolver documento
                3. Listar prestamos activos
                4. Listar documentos disponibles
                5. Buscar socio por DNI
                6. Salir
                """);
    }

    public static void realizarPrestamo(){
        System.out.println("--REALIZAR PRESTAMENTO--");
        System.out.println("DNI del socio:");
        String dni = sc.nextLine();
        if (!miBiblioteca.misSocios.contains(dni)){
            System.out.println("Cliente no existe, desea añadirlo?:");
            String sino= sc.nextLine();
            if (sino.equalsIgnoreCase("si")) {
                System.out.println("Nombre del socio: ");
                String nombre = sc.nextLine();
                System.out.println("Email:");
                String email = sc.nextLine();
                miBiblioteca.registrarSocio(new Socio(dni, nombre, email));
            }
        }
        System.out.println("Codigo de documento: ");
        String codigo = sc.nextLine();
        System.out.println("Dias de prestacion: ");
        int dias = sc.nextInt();

        if (miBiblioteca.realizarPrestamo(dni,codigo,dias)){
            System.out.println("Prestamo realizado exitosamente");
        }else  {
            System.out.println("No se ha podido realizar prestamo");
            return;
        }
    }

    public static void devolverDocumento(){
        System.out.println("--DEVOLVER DOCUMENTO--");
        System.out.println("Codigo de documento: ");
        String codigo = sc.nextLine();
        System.out.println("Dias de retraso: ");
        int dias = sc.nextInt();

        double devolucion= miBiblioteca.devolverDocumento(codigo,dias);
        if ( devolucion == -1){
            System.out.println("No se ha podido devolver documento");
        }else if (devolucion == 0){
            System.out.println("Devuelto correctamente sin multa");
        }else {
            System.out.println("Devuelto con multa de " + devolucion + "€");
        }

    }

    public static void listarPrestamosActivos(){
        System.out.println("--PRESTAMOS ACTIVOS--");
        miBiblioteca.listarPrestamos();
    }

    public static void listarDocumentosDisponibles(){
        System.out.println("--DOCUMENTOS DISPONIBLES--");
        miBiblioteca.listarDisponibles();
    }

    public static void buscarSocioDNI(){
        System.out.println("DNI del socio:");
        String dni = sc.nextLine();
        for (Socio socio : miBiblioteca.misSocios) {
            if (socio.getDni().equals(dni)) {
                System.out.println("Nombre: " + socio.getNome() + "\n DNI: "+ socio.getDni() + "\n Email: " + socio.getEmail());
            }
        }
    }

    public static void main(String[] args) {
        registro();
        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    realizarPrestamo();
                    break;
                case 2:
                    devolverDocumento();
                    break;
                case 3:
                    listarPrestamosActivos();
                    break;
                case 4:
                    listarDocumentosDisponibles();
                    break;
                case 5:
                    buscarSocioDNI();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Introduzca un numero valido");
                    break;
            }

        }
    }
}
