package PracticaExamen;

public class VahiculoFurgoneta extends Vehiculo{
    private double cargaMaxima;

    public VahiculoFurgoneta(String matricula, double precioDia, boolean disponible, double cargaMaxima) {
        super(matricula, precioDia, disponible);
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public double calcularPrecio(int dias) {
        double precio = this.getPrecioDia()*dias;
        if (cargaMaxima > 3000){
            precio += precio*0.1;
        }
        return precio;
    }
}
