package Tarea2_playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class mainPlaylist {
    private static Album album1 = new Album("Nombre1", "Artista1");
    private static Album album2 = new Album("Nombre2", "Artista2");
    LinkedList<Cancion> cancion = new LinkedList<>();

    public static void menu() {
        System.out.println("0. Salir de la lista de reproduccion.");
        System.out.println("1. Reproducior siguiente cancion en la lista.");
        System.out.println("2. Reproducior la cancion previa en la lista");
        System.out.println("3. Repetir la cancion actual");
        System.out.println("4. Imprimir la lista de canciones en la playlist");
        System.out.println("5. Volver a imprimir el menu");
    }
}
