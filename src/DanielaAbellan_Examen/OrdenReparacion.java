package DanielaAbellan_Examen;

import EXAMEN.Clientes;

public class OrdenReparacion {
    private int horasEstimadas;
    private double costeTotal;
    private Vehiculo vehiculo;

    public OrdenReparacion(Cliente cliente, Vehiculo vehiculo, int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
        this.costeTotal = vehiculo.calcularCoste(horasEstimadas);
        this.vehiculo = vehiculo;
    }

    public int getHorasEstimadas() {return horasEstimadas;
    }
    public void setHorasEstimadas(int horasEstimadas) {this.horasEstimadas = horasEstimadas;
    }
    public double getCosteTotal() {return costeTotal;
    }
    public void setCosteTotal(double costeTotal) {this.costeTotal = costeTotal;
    }
    public Vehiculo getVehiculo() {return this.vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {this.vehiculo = vehiculo;
    }

    public double calcularCoste(int horas){
        costeTotal=getCosteTotal()*horas;
        return costeTotal;
    }
}
