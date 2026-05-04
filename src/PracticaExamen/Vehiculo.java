package PracticaExamen;

public abstract class Vehiculo implements Alquilable {
    private String matricula;
    private double precioDia;
    private boolean disponible;

    public Vehiculo(String matricula, double precioDia, boolean disponible) {
        this.matricula = matricula;
        this.precioDia = precioDia;
        this.disponible = disponible;
    }

    public String getMatricula() {return matricula;
    }

    public void setMatricula(String matricula) {this.matricula = matricula;
    }

    public double getPrecioDia() {return precioDia;
    }

    public void setPrecioDia(double precioDia) {this.precioDia = precioDia;
    }

    public boolean isDisponible() {return disponible;
    }

    public void setDisponible(boolean disponible) {this.disponible = disponible;
    }

    public abstract double calcularPrecio(int dias);

    @Override
    public boolean alquilar(int dias) {
        //si esta disponible se puede alquilar y pasa a no estar disponible
        if (disponible==true) {
            disponible=false;
            return true;
        }else return false;

    }

    @Override
    public boolean devolver() {
        // si no esta disponible (esta alquilado) se puede devolver y pasa a estar disponible
        if (disponible==false){
            disponible=true;
            return true;
        }else return false;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", precioDia=" + precioDia +
                ", disponible=" + disponible +
                '}';
    }
}
