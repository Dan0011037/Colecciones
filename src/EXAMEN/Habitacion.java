package EXAMEN;

import java.util.Objects;

public abstract class Habitacion implements Reservable {
    private int numero;
    private double precioNoche;
    //no esta ocupada
    private boolean ocupada;

    public Habitacion(int numero, double precioNoche, boolean ocupada) {
        this.numero = numero;
        this.precioNoche = precioNoche;
        this.ocupada = ocupada;
    }

    public int getNumero() {return numero;
    }
    public void setNumero(int numero) {this.numero = numero;
    }
    public double getPrecioNoche() {return precioNoche;
    }
    public void setPrecioNoche(double precioNoche) {this.precioNoche = precioNoche;
    }
    public boolean isOcupada() {return ocupada;
    }
    public void setOcupada(boolean ocupada) {this.ocupada = ocupada;
    }

    public abstract double calcularPrecio(int noches);

    @Override
    //si la habitacion no esta ocupada se puede reservar y pasa a ser ocupada
    public boolean reservar(int noches) {
        // si no esta ocupada
        if (!ocupada) {
            ocupada=true;
            return true;
        }
        return false;
    }

    @Override
    //si la habitacion esta ocupada se puede cancelar y pasa a no estar ocupada (reservable)
    public boolean cancelar() {
        // si SI esta ocupada
        if (ocupada) {
            ocupada=false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", precioNoche=" + precioNoche +
                ", ocupada=" + ocupada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return numero == that.numero && Double.compare(precioNoche, that.precioNoche) == 0 && ocupada == that.ocupada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, precioNoche, ocupada);
    }
}
