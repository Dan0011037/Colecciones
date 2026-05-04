package Practica3_Videojuegos;

import Practica2_biblioteca.Biblioteca;

import java.util.Scanner;

public class MainVideojuegos {
    private static Torneo miTorneo = new Torneo();
    private static Scanner sc = new Scanner(System.in);

    public static void menu(){
        System.out.println("""
                ------------------
                MENU DE  OPCIONES
                ------------------
                1. Inscribir participante
                2. Registrar victoria
                3. Mostrar clasificacion
                4. Mostrar lider del torneo
                5. Agregar partida al historial
                6. Salir
                """);
    }

    public static void registro(){
     miTorneo.inscribirParticipante(new Jugador("Daniela", "España", 0, 0, 19, Jugador.rangoJugadores.MAESTRO));
     miTorneo.inscribirParticipante(new Jugador("Martin", "Francia", 0, 0, 13, Jugador.rangoJugadores.DIAMANTE));
     miTorneo.inscribirParticipante(new Equipo("ProGamer", "Noruega", 0, 0, "ProGamer", 3));
     miTorneo.inscribirParticipante(new Equipo("Lalala", "Venezuela", 0, 0, "Lalala", 6));
    }

    public static void inscribirParticipante(){
        System.out.println("--INSCRIPCION DE PARTICIPANTES--");
        System.out.println("Apodo: ");
        String apodo = sc.nextLine();
        System.out.println("Pais:");
        String pais = sc.nextLine();

        System.out.println("¿'individual' o en 'equipo'?");
        String jugador = sc.nextLine();
        if (jugador.equalsIgnoreCase("individual")){
            System.out.println("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            System.out.println("Rango de jugador" +
                    "\n MAESTRO, DIAMANTE, ORO, PLATA, BRONCE, HIERRO: ");
            Jugador.rangoJugadores rango= Jugador.rangoJugadores.valueOf(sc.nextLine().toUpperCase());
            miTorneo.inscribirParticipante(new Jugador(apodo, pais, 0, 0, edad, rango));
            System.out.println("Jugador inscrito con exito");

        }else if (jugador.equalsIgnoreCase("equipo")){
            System.out.println("Nombre equipo:");
            String nombreEquipo = sc.nextLine();
            System.out.println("Numero de integrantes:");
            int numIntegrantes = sc.nextInt();
            sc.nextLine();
            miTorneo.inscribirParticipante(new Equipo(apodo, pais, 0, 0, nombreEquipo, numIntegrantes));
            System.out.println("Equipo inscrito con exito");
        }else {
            System.out.println("No permitido, intentelo de nuevo");
            return;
        }
    }

    public static void registrarVictoria(){
        System.out.println("--REGISTRO DE VICTORIA--");
        System.out.println("Apodo del participante:");
        String apodo = sc.nextLine();
        if (miTorneo.misParticipantes.containsKey(apodo)){
            miTorneo.registrarVictorias(apodo);
        }else{
            System.out.println("El participante no existe");
        }
    }

    public static void mostrarClasificacion(){
        miTorneo.mostrarClasificacion();
    }

    public static void mostrarLider(){
        System.out.println(miTorneo.mostrarLider().getApodo() + miTorneo.mostrarLider().getPais() + miTorneo.mostrarLider().getPuntuacion() + miTorneo.mostrarLider().getVictorias());

    }

    public static void agregarPartida(){
        System.out.println("--NUEVA PARTIDA--");
        System.out.println("Tipo de juego:");
        String tipoJuego = sc.nextLine();
        System.out.println("Duracion:");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.println("Puntos totales:");
        int puntosTotales = sc.nextInt();
        sc.nextLine();
        miTorneo.agregarPartida(new Partida(tipoJuego, duracion, puntosTotales));
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
                    inscribirParticipante();
                    break;
                case 2:
                    registrarVictoria();
                    break;
                case 3:
                    mostrarClasificacion();
                    break;
                case 4:
                    mostrarLider();
                    break;
                case 5:
                    agregarPartida();
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }
}
