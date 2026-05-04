package Practica2_biblioteca;

import EXAMEN.Hotel;

import java.io.*;
import java.util.Scanner;

public class FicheroBiblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static Biblioteca miBiblioteca;

    //para que tanto el main normal como el de fichero trabaje con la misma biblioteca
    public FicheroBiblioteca(Biblioteca biblioteca) {
        this.miBiblioteca=biblioteca;
    }

    public void guardarSocios() throws IOException{
        //abre el fichero, si no existe lo crea
        BufferedWriter bw = new BufferedWriter(new FileWriter("socios.txt"));
        // recorre misSocios, por cada socio escribe sus datos
        for (Socio socio : miBiblioteca.misSocios){
            bw.write(socio.getDni() + "," + socio.getNome() + "," + socio.getEmail());
            // salta a la siguiente linea
            bw.newLine();
        }
        bw.close();
    }

    public void cargarSocios() throws IOException{
        // abro socio.txt
        BufferedReader br = new BufferedReader(new FileReader("socios.txt"));
        String linea;
        // lee una linea cada vez, lo trocea por comas: datos[0] es dni, datos[1] es nombre, datos[2] es email
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            // con estos datos construye el objeto Socio y lo añade al Set. Cuando no quedan lineas devuelve null
            Socio socio = new Socio(datos[0], datos[1], datos[2]);
            miBiblioteca.misSocios.add(socio);
        }
        br.close();
    }

    public void guardarDocumentos() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("documentos.txt"));
        for (Documento documento : miBiblioteca.misDocumentos){
            if (documento instanceof Revista){
                bw.write("REVISTA," +documento.getCodigo() + "," + documento.getTitulo() + "," + documento.getAutor() + "," + documento.isDisponible() + ","+ ((Revista) documento).getNumeroEdicion() + "," + ((Revista) documento).getPeriodicidad());
                bw.newLine();
            }else if (documento instanceof Libro){
                bw.write("LIBRO," + documento.getCodigo() + "," + documento.getTitulo() + "," + documento.getAutor() + ","+ documento.isDisponible() +","+ ((Libro) documento).getNumeroPaginas() + "," + ((Libro) documento).getGenero());
                bw.newLine();
            }

        }
        bw.close();
    }

    public void cargarDocumentos() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("documentos.txt"));
        String linea;
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            boolean disponible= datos[4].equals("true");

            if (datos[0].equals("REVISTA")){
                Documento revista= new Revista(datos[1], datos[2], datos[3], disponible, Integer.parseInt(datos[5]), datos[6]);
                miBiblioteca.misDocumentos.add(revista);
            }else if (datos[0].equals("LIBRO")){
                Documento libro = new Libro(datos[1],datos[2],datos[3],disponible,Integer.parseInt(datos[5]), datos[6]);
                miBiblioteca.misDocumentos.add(libro);
            }
        }
        br.close();
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

    public static void registro(){
        miBiblioteca.registrarSocio(new Socio("78248038Z", "Daniela", "dabellancabrerizo@gmail.com"));
        miBiblioteca.registrarSocio(new Socio("792798039Y", "Maria", "Marieta@hotmal.es"));

        miBiblioteca.agregarDocumento(new Libro("111a", "La caca", "Yo", true, 45, "Misterio"));
        miBiblioteca.agregarDocumento(new Libro("111b", "El pipi", "Tu", false, 54, "Cacota"));
        miBiblioteca.agregarDocumento(new Revista("111c", "El reves", "Nosotros", true, 23, "Cada tres dias"));
        miBiblioteca.agregarDocumento(new Revista("111d", "No seee", "Vosotros", true, 14, "Cada tres meses"));

    }

    public static void main(String[] args) throws IOException{
        miBiblioteca = new Biblioteca();
        FicheroBiblioteca fichero = new FicheroBiblioteca(miBiblioteca);

        try{
            fichero.cargarSocios();
            fichero.cargarDocumentos();
        }catch (IOException e){
            System.out.println("No hay datos");
            registro();
        }


        boolean continuar = true;
        int opcion;

        while (continuar) {
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
    System.out.println("guardando...");
        fichero.guardarSocios();
        fichero.guardarDocumentos();
    }
}
