package repaso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainRol {
    private static Scanner scanner = new Scanner(System.in);
    private static Jugadores jugadoresMain= new Jugadores(new ArrayList<>());
    private static Jugadores jugadorActual;

    public static void menu(){
        System.out.println("""
                ================
                menu
                ================
                1. Imprimir todos tus datos.
                2. Jugar.
                3. Salir.
                """);
    }

    public static void jugadores(){
        Mochila mochilaSergio = new Mochila("fórmula, microscopio, microorganismo, automata");
        jugadoresMain.anadirJugadores(new Jugadores("Sergio", 90, Jugadores.TipoPersonaje.INVENTOR, mochilaSergio));

        Mochila mochilaMarga = new Mochila("escudo, ballesta, hacha, unicornio");
        jugadoresMain.anadirJugadores(new Jugadores("Marga", 80, Jugadores.TipoPersonaje.GUERRERO, mochilaMarga));

        Mochila mochilaMiquel = new Mochila("lupa, escoba, dragón, brújula");
        jugadoresMain.anadirJugadores(new Jugadores("Miquel", 85, Jugadores.TipoPersonaje.RASTREADOR, mochilaMiquel));

        Mochila mochilaClaudia = new Mochila("varita, hechizo, libro, gata");
        jugadoresMain.anadirJugadores(new Jugadores("Marga", 110, Jugadores.TipoPersonaje.MAGO, mochilaClaudia));

        Mochila mochilaCarlos = new Mochila("varita, conjuro, sombrero, búho");
        jugadoresMain.anadirJugadores(new Jugadores("Carlos", 95 , Jugadores.TipoPersonaje.SABIO, mochilaCarlos));

        Mochila mochilaAlexia = new Mochila("látigo, semillas, hacha, yegua");
        jugadoresMain.anadirJugadores(new Jugadores("Alexia", 100, Jugadores.TipoPersonaje.EXPLORADOR, mochilaAlexia));
    }

    //imprimir jugadores
    public static void imprimirJugadores() {

        if (jugadoresMain.getMisJugadores().isEmpty()){
            System.out.println("No hay jugadores");
            return;
        }
        jugadores();
        jugadoresMain.imprimirJugadores();
    }

    public static void seleccionJugador(){
        System.out.println("Ingrese el nombre del jugador 1: ");
        String nombre = scanner.nextLine().toUpperCase();
        jugadorActual = jugadoresMain.queryJugadores(nombre);

        while (jugadorActual == null){
            System.out.println("No existe el jugador");
            nombre = scanner.nextLine().toUpperCase();
            jugadorActual = jugadoresMain.queryJugadores(nombre);
        }
        System.out.println("Jugador 1: " + jugadorActual.getNombre());
    }

    public static void jugar(){

        System.out.println("Ingrese el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine().toUpperCase();
        Jugadores jugadorActual2 = jugadoresMain.queryJugadores(nombre2);

        //si es nulo o tiene el mismo nombre que J1
        while (jugadorActual2 == null || jugadorActual2.getNombre().equals(jugadorActual)){
            System.out.println("No disponible, vuelvalo a intenar: ");
            nombre2 = scanner.nextLine().toUpperCase();
            jugadorActual2 = jugadoresMain.queryJugadores(nombre2);
        }
        System.out.println("Jugador 2: " + jugadorActual2.getNombre());

        System.out.println("==========\n-Jugador 1: " + jugadorActual.getNombre() + "\n-Jugador 2: " + jugadorActual2.getNombre() + "\n==========\n");

        int victorias1 = 0;
        int victorias2 = 0;

        // se repetirá hasta que alguno de los dos llegue a 2 puntos
        while(victorias1 < 2 && victorias2 < 2){
            System.out.println(jugadorActual.getNombre() + ", elija una herramienta: "+ jugadorActual.getMochila().imprimirHerramientas());
            //trim hace que si se añade algun espacio por error al introducir el elemento lo detecte en vez de saltar un error
            String herramienta1 = scanner.nextLine().toLowerCase().trim();
            while (!jugadorActual.getMochila().getHerramientas().contains(herramienta1)) {
                System.out.println("Herramienta no encontrada, introduzca una valida: ");
                herramienta1 = scanner.nextLine();
            }

            System.out.println(jugadorActual2.getNombre() + ", elija una herramienta: "+ jugadorActual2.getMochila().imprimirHerramientas());
            String  herramienta2 = scanner.nextLine().toLowerCase().trim();
            while (!jugadorActual2.getMochila().getHerramientas().contains(herramienta2)) {
                System.out.println("Herramienta no encontrada, introduce una valida: ");
                herramienta2 = scanner.nextLine();
            }

            int valorHerramienta1 = (int) (Math.random()*4)+1;
            int valorHerramienta2 = (int) (Math.random()*4)+1;
            System.out.println("\n"+jugadorActual.getNombre() +": " + valorHerramienta1 + "\n" + jugadorActual2.getNombre() +": " + valorHerramienta2);
            if (valorHerramienta1 > valorHerramienta2){
                System.out.println("Gana " + jugadorActual.getNombre());
                jugadorActual.getMochila().eliminarHerramienta(herramienta1);
                victorias1++;
            } else if (valorHerramienta1 < valorHerramienta2) {
                System.out.println("Gana " + jugadorActual2.getNombre());
                jugadorActual2.getMochila().eliminarHerramienta(herramienta2);
                victorias2++;
            }else {
                System.out.println("empate.");
            }

            System.out.println("\nVictorias " + jugadorActual.getNombre() +": " + victorias1 + "\nVictorias " +jugadorActual2.getNombre()+ ": " + victorias2+"\n");
        }
        if (victorias1 ==2){
            System.out.println("Gana " + jugadorActual.getNombre());
        }else if (victorias2 ==2){
            System.out.println("Gana " + jugadorActual.getNombre());
        }

    }

    public static void main(String args[]) {
        jugadores();
        System.out.println("Lista de jugadores disponibles: ");
        jugadoresMain.imprimirJugadores();

        seleccionJugador();

        boolean continuar = true;
        int opcion;
        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println(jugadorActual.getNombre() + "(" + jugadorActual.getTipoDePersonaje() + "): " + jugadorActual.getVida() + ", " + jugadorActual.getMochila());
                    break;
                case 2:
                    jugar();
                    continuar = false;
                    System.out.println("-------");
                    break;
                case 3:
                    System.out.println("Adios");
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