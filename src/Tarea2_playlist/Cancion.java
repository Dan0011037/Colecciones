package Tarea2_playlist;

public class Cancion {
    private String titulo;
    private double duracion;

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }
    public double getDuracion(){
        return duracion;
    }

    public String toString(){
        return this.titulo + ": " + this.duracion;
    }


}
