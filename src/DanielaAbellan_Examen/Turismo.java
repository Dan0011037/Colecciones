package DanielaAbellan_Examen;

public class Turismo extends Vehiculo{
    private int puertas;

    public Turismo(String marca, String matricula, double precioHora, boolean enReparacion, int puertas) {
        super(marca, matricula, precioHora, enReparacion);
        this.puertas = puertas;
    }

    public int getPuertas() {return puertas;
    }
    public void setPuertas(int puertas) {this.puertas = puertas;
    }


    @Override
    public double calcularCoste(int horas) {
        return getPrecioHora() * horas;
    }
}
