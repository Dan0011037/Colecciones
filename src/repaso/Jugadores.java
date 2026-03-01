package repaso;

import repaso.Aeropuerto.Vuelos;

import java.util.ArrayList;

public class Jugadores {
    ArrayList<Jugadores> misJugadores = new ArrayList<Jugadores>();
    private String nombre;
    private String tipoDePersonaje;
    private int vida;
    private Mochila mochila;

    public Jugadores(String nombre, int vida, String tipoDePersonaje, Mochila mochila) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipoDePersonaje = tipoDePersonaje;
        this.mochila = mochila;
    }

    public String getNombre() {return nombre;}

    public String getTipoDePersonaje() {return tipoDePersonaje;}

    public int getVida() {return vida;}
    public void setVida(int vida) {this.vida = vida; }

    public Mochila getMochila() {
        return mochila;}

    public void imprimirJugadores(){
        for (int i =0; i<misJugadores.size();i++){
            Jugadores jugadores = misJugadores.get(i);
            System.out.println(jugadores.getNombre() + " (" + jugadores.getTipoDePersonaje() + "): " + jugadores.getVida() + ", " + jugadores.getMochila());
        }
    }
}
