import Pagina1.Contacto;
import Pagina3_Mapas.Ubicacion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainVuelos {
    private static Scanner scanner = new Scanner(System.in);
    private static Aeropuerto aeropuerto = new Aeropuerto(new ArrayList<Vuelos>());

    public static void menu() {
        System.out.println("===================================== \n VUELOS DEL AEROPUERTO DE VALENCIA \n=====================================");
        System.out.println("1 - Imprimir todos los vuelos");
        System.out.println("2 - Buscar un numero de vuelo");
        System.out.println("3 - Buscar vuelo por clave");
        System.out.println("4 - Añadir nuevo vuelo");
        System.out.println("5 - Borrar vuelo por numero");
        System.out.println("0 - SALIR");
        System.out.println("---------------");
    }

    public static void vuelos(){
        aeropuerto.anadirVuelo(new Vuelos("2023-02", "Valencia", "Tenerife", Vuelos.TipoClase.turista, "20-08"));
        aeropuerto.anadirVuelo(new Vuelos("2023-01", "Valencia", "Menorca", Vuelos.TipoClase.turista, "15-08"));
        aeropuerto.anadirVuelo(new Vuelos("2023-03", "París", "Valencia", Vuelos.TipoClase.primera, "15-08"));
        aeropuerto.anadirVuelo(new Vuelos("2023-04", "Atenas", "Valencia", Vuelos.TipoClase.primera, "20-08"));
    }

    // imprime vuelos
    public static void imprimirVuelos() {
        vuelos();
        aeropuerto.imprimirVuelos();
    }

    public static void buscarNumero() {
        System.out.println("Numero del vuelo: ");
        String numero = scanner.nextLine();
        Vuelos vuelos = aeropuerto.buscadorVuelo(numero);

        if (vuelos == null) {
            System.out.println("Este vuelo no existe.");
        } else {
            System.out.println("Numero: " + vuelos.getNumero() + ", Origen: " + vuelos.getOrigen() + ", Destino: " + vuelos.getDestino() + ", Clase: " + vuelos.getClase() + ", Dia: " + vuelos.getDia());
        }
    }

    public static void buscarClave(){
        if (aeropuerto.getMisVuelos().isEmpty()){
            System.out.println("La lista de vuelos está vacía");
            return;
        }

        System.out.println("Clave: ");
        String clave = scanner.nextLine().toLowerCase();

        if (clave.equalsIgnoreCase("numero")|| clave.equalsIgnoreCase("origen")||
                clave.equalsIgnoreCase("destino")|| clave.equalsIgnoreCase("clase")||
                clave.equalsIgnoreCase("dia")) {
            //para cada objeto de tipo Vuelos(llamado v) que este dentro de la lista de vuelos del aeropurto
            for (Vuelos v: aeropuerto.getMisVuelos()){
                switch (clave) {
                    case "numero": System.out.println(v.getNumero()); break;
                    case "origen": System.out.println(v.getOrigen()); break;
                    case "destino": System.out.println(v.getDestino()); break;
                    case "clase": System.out.println(v.getClase()); break;
                    case "dia": System.out.println(v.getDia()); break;
                }
            }
        } else {
            System.out.println("Error: La clave '" + clave + "' no es válida.");
        }
    }

    //añade vuelos
    public static void anadirVuelos() {
        String numero, dia, origen, destino;
        Vuelos.TipoClase clase;
        //numero
        do {
            System.out.println("Numero (XXXX-XX):");
             numero = scanner.nextLine();
             //se repite hasta que no se introduzca el formato correcto
        } while (!numero.matches("\\d{4}-\\d{2}"));

        //origen
        do {
            System.out.println("Origen:");
            origen = scanner.nextLine();
        } while (!origen.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));

        //destino
        do {
            System.out.println("Destino: ");
            destino = scanner.nextLine();
        } while (!destino.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));

        //clase
        System.out.println("Clase (turista, primera): ");
        clase = Vuelos.TipoClase.valueOf(scanner.nextLine());

        //dia
        do {
            System.out.println("Dia (DD-MM): ");
            dia = scanner.nextLine();
        } while (!dia.matches("\\d{2}-\\d{2}"));


        Vuelos vuelos = new Vuelos(numero, origen, destino, clase, dia);
        if (aeropuerto.anadirVuelo(vuelos)) {
            System.out.println("Vuelo añadido a la lista");
        }else {
            System.out.println("Este vuelo YA existe.");
            System.out.println("No se puede añadir");
        }
    }

    //eliminar vuelo
    public static void eliminarVuelo() {
        System.out.println("Numero que quiere eliminar: ");
        String numero = scanner.nextLine();

        if (aeropuerto.eliminarVuelo(aeropuerto.buscadorVuelo(numero))) {
            System.out.println("Vuelo eliminado con exito.");
        } else {
            System.out.println("Este vuelo no existe.");
        }
    }

    //main
    public static void main(String args[]){

        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    vuelos();
                    imprimirVuelos();
                    System.out.println("-------");
                    break;
                case 2:
                    buscarNumero();
                    System.out.println("-------");
                    break;
                case 3:
                    buscarClave();
                    System.out.println("-------");
                    break;
                case 4:
                    anadirVuelos();
                    System.out.println("-------");
                    break;
                case 5:
                    eliminarVuelo();
                    System.out.println("-------");
                    break;
                case 0:
                    continuar = false;
                    System.out.println("-------");
                    break;
                default:
                    System.out.println("No valido");
                    System.out.println("---");
                    break;
            }
        }
    }
}
