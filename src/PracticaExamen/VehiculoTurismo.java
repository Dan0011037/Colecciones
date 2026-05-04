package PracticaExamen;

public class VehiculoTurismo extends Vehiculo {
    private int plazas;

    public VehiculoTurismo(String matricula, double precioDia, boolean disponible, int plazas) {
        super(matricula, precioDia, disponible);
        this.plazas=plazas;
    }

    @Override
    public double calcularPrecio(int dias) {
        double precio = this.getPrecioDia()*dias;
        return precio;
    }
}
