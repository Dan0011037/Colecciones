package Practica3_Videojuegos;

public class Partida {
    private String juego;
    private int duracionMinutos;
    private int puntosTotales;

    public Partida(String juego, int duracionMinutos, int puntosTotales) {
        this.juego = juego;
        this.duracionMinutos = duracionMinutos;
        this.puntosTotales = puntosTotales;
    }

    public String getJuego() {return juego;
    }
    public void setJuego(String juego) {this.juego = juego;
    }
    public int getDuracionMinutos() {return duracionMinutos;
    }
    public void setDuracionMinutos(int duracionMinutos) {this.duracionMinutos = duracionMinutos;
    }
    public int getPuntosTotales() {return puntosTotales;
    }
    public void setPuntosTotales(int puntosTotales) {this.puntosTotales = puntosTotales;
    }

    // devuelve 1 punto extra por cada minuto que dure la partida
    public int calcularPuntos(){
        return  puntosTotales + duracionMinutos;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "juego='" + juego + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", puntosTotales=" + puntosTotales +
                '}';
    }
}
