package PracticaExamen;

import EXAMEN.Clientes;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class MainAlquiler {
    private static Agencia miAgencia=new Agencia();
    private static Scanner sc= new Scanner(System.in);

    public static void menu() {
        System.out.println("""
                --------------
                MENU ALQUILER
                --------------
                
                1. Gestionar alquiler
                2. Cancelar alquiler
                3. Listar alquileres
                4. Listar vehiculos
                5. Buscar Cliente por dni
                6. Buscar vehiculo por matricula
                7. Agregar vehiculo
                8. Registrar cliente
                9. Salir
                """);
    }

    public static void AgregarVehiculo(){
        System.out.println("--AGREGAR VEHICULO--");
        System.out.println("Matricula: ");
        String matricula= sc.nextLine();
        System.out.println("Precio por dia: ");
        double precio= sc.nextDouble();
        sc.nextLine();
        System.out.println("Ocupado: ");
        boolean ocupado= sc.nextBoolean();
        sc.nextLine();
        System.out.println("Tipo de vehiculo (Turismo/Furgoneta: ");
        String tipoVehiculo= sc.nextLine();

        if (tipoVehiculo.equalsIgnoreCase("Turismo")) {
            System.out.println("Plazas: ");
            int plazas= sc.nextInt();
            sc.nextLine();
            if (!miAgencia.misVehiculos.contains(matricula)) {
                System.out.println("Agregado con exito");
                miAgencia.agregarVehiculo(new VehiculoTurismo(matricula, precio, ocupado, plazas));
            }else  {
                System.out.println("Vehiculo existente");
                return;
            }
        } else if (tipoVehiculo.equalsIgnoreCase("Furgoneta")) {
            System.out.println("Carga maxima: ");
            double cargaMaxima = sc.nextDouble();
            sc.nextLine();
            if (!miAgencia.misVehiculos.contains(matricula)) {
                System.out.println("Agregado con exito");
                miAgencia.agregarVehiculo(new VahiculoFurgoneta(matricula, precio, ocupado, cargaMaxima));
            }else   {
                System.out.println("Vehiculo existente");
                return;
            }
        }else {
            System.out.println("No");
            return;
        }
    }

    public static void RegistrarCliente(){
        System.out.println("--REGISTRAR CLIENTE--");
        System.out.println("DNI: ");
        String dni= sc.nextLine();
        System.out.println("Nombre: ");
        String nombre= sc.nextLine();
        if (!miAgencia.misClientes.contains(dni)) {
            System.out.println("registrado con exito");
            miAgencia.registrarCliente(new Cliente(dni, nombre));
        }else {
            System.out.println("Cliente existente");
            return;
        }

    }

    public static void gestionarAlquiler(){
        System.out.println("--GESTION DE ALQUILER--");
        System.out.println("dni del cliente: ");
        String dni= sc.nextLine();
        if (!dni.equals(miAgencia.misClientes)) {
            System.out.println("Cliente no existe, desea añadirlo?:");
            String sino= sc.nextLine();
            if (sino.equalsIgnoreCase("si")){
                System.out.println("Nombre del cliente: ");
                String nombre = sc.nextLine();
                miAgencia.registrarCliente(new Cliente(dni, nombre));
            }
        }
        System.out.println("Matricula del vehiculo:");
        String matricula= sc.nextLine();
        System.out.println("Dias de alquile:");
        int dias= sc.nextInt();

        if (miAgencia.gestionarAlquiler(dni, matricula, dias)){
            System.out.println("Alquiler realizado con exito");
        }else{
            System.out.println("No se ha podido realizar");
        }
    }

    public static void cancelarAlquiler(){
        System.out.println("--CANCELAR ALQUILER--");
        System.out.println("Matricula:");
        String matricula= sc.nextLine();

        if (miAgencia.gestionarDevolucion(matricula)){
            System.out.println("Alquiler cancelado con exito");
        }else{
            System.out.println("No se ha podido cancelar");
        }
    }

    public static void listarAlquilers(){
        System.out.println("--LISTAR ALQUILER--");
        miAgencia.listarAlquileres();
    }

    public static void listarVehiculos(){
        System.out.println("--LISTAR VEHICULOS--");
        miAgencia.listarVehiculos();
    }

    public static void buscarClientePorDni(){
        System.out.println("--BUSCAR CLIENTE POR DNI:");
        System.out.println("Introduzca el dni:");
        String dni= sc.nextLine();
        for (Cliente cliente : miAgencia.misClientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println(cliente);
            }
        }
    }

    public static void buscarVehiculoPorMatricula(){
        System.out.println("--BUSCAR VEHICULO POR MATRICULA:");
        System.out.println("Introduzca el matricula:");
        String matricula = sc.nextLine();
        for (Vehiculo vehiculo : miAgencia.misVehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                System.out.println(vehiculo);
            }
        }
    }

    public static void main(String[] args) {

        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    gestionarAlquiler();
                    break;
                case 2:
                    cancelarAlquiler();
                    break;
                case 3:
                    listarAlquilers();
                    break;
                case 4:
                    listarVehiculos();
                    break;
                case 5:
                    buscarClientePorDni();
                    break;
                case 6:
                    buscarVehiculoPorMatricula();
                    break;
                case 7:
                    AgregarVehiculo();
                    break;
                case 8:
                    RegistrarCliente();
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("No disponible");
                    break;

            }
        }
    }
}
