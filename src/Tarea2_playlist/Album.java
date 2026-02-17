package Tarea2_playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<Cancion>();
    }

    private Cancion findSong(String titulo) {
        for (int i = 0; i < canciones.size(); i++) {
            // canción que está en la posición i
            Cancion cancion = canciones.get(i);
            if (cancion.getTitulo().equalsIgnoreCase(titulo)){
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong (String titulo, double duracion){
        if (findSong(titulo) ==  null){
            canciones.add(new Cancion(titulo,duracion));
            return true;
        }
        return false;
    }

    public boolean addToPlaylist (int numPista, LinkedList<Cancion> lista){
        if (numPista <= 0){
            lista.add(canciones.get(numPista));
            return true;
        }
        return false;
    }

    public boolean addToPlaylist(String titulo, LinkedList<Cancion> lista){
        Cancion cancion = findSong(titulo);
        if (cancion != null){
            lista.add(cancion);
            return true;
        }
        return false;
    }

    public void printPlaylist(){
        for (int i =0; i<canciones.size();i++){
            Cancion cancion = canciones.get(i);
            System.out.println(cancion.getTitulo() + ", " + cancion.getDuracion());
        }
    }
}


