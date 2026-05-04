package PracticaExamen;

public class Alquiler {
    private int dias;
    private static Vehiculo vehiculo;
    private static Cliente cliente;
    private double costeTotal;

    public Alquiler(Cliente cliente, Vehiculo vehiculo,  int dias) {
        this.dias = dias;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        // el coste se debe calcular dependiendo del metodo de calcular el precio de la clase vehículo, el alquiler solo registra este resultado
        this.costeTotal = vehiculo.calcularPrecio(dias);
    }

    public int getDias() {return dias;
    }
    public void setDias(int dias) {this.dias = dias;
    }
    public static Vehiculo getVehiculo() {return vehiculo;
    }
    public static void setVehiculo(Vehiculo vehiculo) {Alquiler.vehiculo = vehiculo;
    }
    public static Cliente getCliente() {return cliente;
    }
    public static void setCliente(Cliente cliente) {Alquiler.cliente = cliente;
    }
    public double getCosteTotal() {return costeTotal;
    }
    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }


}
