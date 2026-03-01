package repaso.Arte;

import java.util.ArrayList;

public class Artistas {
    private String nombre;
    private String nacionalidad;

    ArrayList<Artistas> misArtistas = new ArrayList<>();

    public Artistas(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Artistas(ArrayList<Artistas> misArtistas) {
        this.misArtistas = misArtistas;
    }

    private int buscarArtistas(Artistas artistas) {
        return misArtistas.indexOf(artistas);
    }

    //buscar por nombre de artista
    private int buscarArtistas(String nombre) {
        for (int i  = 0; i < misArtistas.size(); i++) {
            if (misArtistas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public boolean anadirArtista(Artistas artistas) {
        if (buscarArtistas(artistas.getNombre()) >= 0) {
            return false;
        }
         misArtistas.add(artistas);
        return true;
    }

    //buscador
    public Artistas queryArtistas(String nombre) {
        for (Artistas artistas : misArtistas) {
            if (artistas.getNombre().equals(nombre)) {
                return artistas;
            }
        }
        return null;
    }

    public ArrayList<Artistas> getMisArtistas(){
        return misArtistas;
    }
}
