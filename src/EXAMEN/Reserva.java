package EXAMEN;

public class Reserva {
    private double precioTotal;
    private int noches;
    private Habitacion habitacion;

    public Reserva(Clientes cliente, Habitacion habitacion, int noches) {
        // el precio se debe calcular dependiendo del metodo de calcular el precio de la clase habitacion, la reserva solo registra este resultado
        this.precioTotal = habitacion.calcularPrecio(noches);
        this.noches = noches;
        this.habitacion = habitacion;
    }

    public double getPrecioTotal() {return this.precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;
    }

    public int getNoches() {return noches;
    }

    public void setNoches(int noches) {this.noches = noches;
    }

    public Habitacion getHabitacion() {return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {this.habitacion = habitacion;
    }

    public double calcularPrecio(int noches){
        precioTotal*=noches;
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precioTotal=" + precioTotal +
                ", noches=" + noches +
                ", habitacion=" + habitacion +
                '}';
    }
}
