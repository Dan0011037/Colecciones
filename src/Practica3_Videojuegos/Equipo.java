package Practica3_Videojuegos;

public class Equipo extends Participante{
    private String nombreEquipo;
    private int numIntegrantes;

    public Equipo(String apodo, String pais, int victorias, int puntuacion, String nombreEquipo, int numIntegrantes) {
        super(apodo, pais, victorias, puntuacion);
        this.nombreEquipo = nombreEquipo;
        this.numIntegrantes = numIntegrantes;
    }

    public String getNombreEquipo() {return nombreEquipo;
    }
    public void setNombreEquipo(String nombreEquipo) {this.nombreEquipo = nombreEquipo;
    }
    public int getNumIntegrantes() {return numIntegrantes;
    }
    public void setNumIntegrantes(int numIntegrantes) {
        this.numIntegrantes = numIntegrantes;
    }

    // 5 puntos por cada integrante del equipo
    @Override
    public int calcularBonus() {
        return numIntegrantes*5;
    }
}
