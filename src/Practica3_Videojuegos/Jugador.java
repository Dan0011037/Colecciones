package Practica3_Videojuegos;

public class Jugador extends Participante {
    public enum rangoJugadores {MAESTRO, DIAMANTE, ORO, PLATA, BRONCE, HIERRO}
    private int edad;
    private rangoJugadores rango;

    public Jugador(String apodo, String pais, int victorias, int puntuacion, int edad, rangoJugadores rango) {
        super(apodo, pais, victorias, puntuacion);
        this.edad = edad;
        this.rango = rango;
    }

    public int getEdad() {return edad;
    }
    public void setEdad(int edad) {this.edad = edad;
    }
    public rangoJugadores getRango() {return rango;
    }
    public void setRango(rangoJugadores rango) {this.rango = rango;
    }


    @Override
    public int calcularBonus() {
        int bonus = 0;
        if (rango == rangoJugadores.DIAMANTE) {
            bonus += 10;
        }else if (rango == rangoJugadores.MAESTRO) {
            bonus += 20;
        }
        return bonus;
    }


}
