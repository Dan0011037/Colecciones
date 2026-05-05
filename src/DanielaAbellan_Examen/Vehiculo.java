package DanielaAbellan_Examen;

public abstract class Vehiculo implements Reparable{
    private String marca;
    private String matricula;
    private double precioHora;
    private boolean enReparacion;

    public Vehiculo(String marca, String matricula, double precioHora, boolean enReparacion) {
        this.marca = marca;
        this.matricula = matricula;
        this.precioHora = precioHora;
        this.enReparacion = enReparacion;
    }

    public String getMarca() {return marca;
    }
    public void setMarca(String marca) {this.marca = marca;
    }
    public String getMatricula() {return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public double getPrecioHora() {return precioHora;
    }
    public void setPrecioHora(double precioHora) {this.precioHora = precioHora;
    }
    public boolean isEnReparacion() {return enReparacion;
    }
    public void setEnReparacion(boolean enReparacion) {this.enReparacion = enReparacion;
    }

    public abstract double calcularCoste(int horas);

    @Override
    public boolean abrirOrden(int horasEstimadas) {
        //si no esta en reparacion
        if (!enReparacion) {
            System.out.println("Reparacion abierta correctamente");
            enReparacion=true;
            return true;
        }else{
            System.out.println("Este vehiculo ya esta en reparacion");
            return false;
        }
    }

    @Override
    public boolean cerrarOrden() {
        if (enReparacion) {
            System.out.println("Orden cerrada");
            enReparacion=false;
            return true;
        }else{
            System.out.println("Este vehiculo no esta en reparacion");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vehiculo: " +
                "marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precioHora=" + precioHora +
                ", enReparacion=" + enReparacion;
    }
}
