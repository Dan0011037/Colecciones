package repaso.Rol;

import java.util.ArrayList;

public class Jugadores {
    ArrayList<Jugadores> misJugadores = new ArrayList<Jugadores>();

    public enum TipoPersonaje {
        INVENTOR, GUERRERO, RASTREADOR, MAGO, SABIO, EXPLORADOR
    }
    private String nombre;
    private TipoPersonaje tipoDePersonaje;
    private int vida;
    private Mochila mochila;


    public Jugadores(String nombre, int vida, TipoPersonaje tipoDePersonaje, Mochila mochila) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipoDePersonaje = tipoDePersonaje;
        this.mochila = mochila;
    }

    public Jugadores(ArrayList<Jugadores> jugadores) {
    }

    public String getNombre() {return nombre.toUpperCase();}

    public Enum getTipoDePersonaje() {return tipoDePersonaje;}

    public int getVida() {return vida;}

    public Mochila getMochila() {
        return mochila;}

    public void imprimirJugadores(){
        for (int i =0; i<misJugadores.size();i++){
            Jugadores jugadores = misJugadores.get(i);
            System.out.println(jugadores.getNombre());
        }
    }

    public int buscarJugadores(Jugadores jugadores){
        return misJugadores.indexOf(jugadores);
    }

    public int buscarJugadores(String jugadores){
        for (int i=0; i< misJugadores.size();i++){
            if (misJugadores.get(i).getNombre().equals(jugadores)){
                return i;
            }
        }
        return -1;
    }

    public boolean anadirJugadores(Jugadores jugadores) {
        if (buscarJugadores(jugadores.getNombre()) >= 0) {
            return false;
        }
        misJugadores.add(jugadores);
        return true;
    }

    //buscador
    public Jugadores queryJugadores(String nombre) {
        for (Jugadores jugadores : misJugadores) {
            if (jugadores.getNombre().equals(nombre)) {
                return jugadores;
            }
        }
        return null;
    }
    public ArrayList<Jugadores> getMisJugadores(){
        return misJugadores;
    }
}
