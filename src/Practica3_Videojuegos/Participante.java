package Practica3_Videojuegos;

public abstract class Participante implements Clasificable{
    private String apodo;
    private String pais;
    private int victorias =0;
    private int puntuacion=0;

    public Participante(String apodo, String pais, int victorias, int puntuacion) {
        this.apodo = apodo;
        this.pais = pais;
        this.victorias = victorias;
        this.puntuacion = puntuacion;
    }

    public String getApodo() {return apodo;
    }
    public void setApodo(String apodo) {this.apodo = apodo;
    }
    public String getPais() {return pais;
    }
    public void setPais(String pais) {this.pais = pais;
    }
    public int getVictorias() {return victorias;
    }
    public void setVictorias(int victorias) {this.victorias = victorias;
    }
    public int getPuntuacion() {return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {this.puntuacion = puntuacion;
    }

    public abstract int calcularBonus();

    @Override
    public void registrarVictorias() {
        victorias++;
        puntuacion+= 50+calcularBonus();
    }

    @Override
    public String toString() {
            return "Participante{" +
                    "apodo='" + apodo + '\'' +
                    ", pais='" + pais + '\'' +
                    ", victorias=" + victorias +
                    ", puntuacion=" + puntuacion +
                    '}';

    }
}
