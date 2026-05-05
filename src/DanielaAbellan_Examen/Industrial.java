package DanielaAbellan_Examen;

public class Industrial extends Vehiculo{
    private double capacidadToneladas;

    public Industrial(String marca, String matricula, double precioHora, boolean enReparacion, double capacidadToneladas) {
        super(marca, matricula, precioHora, enReparacion);
        this.capacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {return capacidadToneladas;
    }
    public void setCapacidadToneladas(double capacidadToneladas) {this.capacidadToneladas = capacidadToneladas;
    }


    @Override
    public double calcularCoste(int horas) {
        double precioIndustral= horas*5;
        if (capacidadToneladas >=3){
            precioIndustral=capacidadToneladas;
        }
        return precioIndustral;
    }
}
