package Practica2_biblioteca;

public class Revista extends Documento{
    private int numeroEdicion;
    //con que frecuencia se publican revistas
    private String periodicidad;

    public Revista(String codigo, String titulo, String autor, boolean disponible, int numeroEdicion, String periodicidad) {
        super(codigo, titulo, autor, disponible);
        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }

    public int getNumeroEdicion() {return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {this.numeroEdicion = numeroEdicion;
    }

    public String getPeriodicidad() {return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {this.periodicidad = periodicidad;
    }

    @Override
    public double calcularMulta(int diasRetraso) {
        return diasRetraso*0.20;
    }
}
