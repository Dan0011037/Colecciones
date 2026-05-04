package EXAMEN;

public class HabitacionSimple extends Habitacion{
    private boolean minibar=true;

    public HabitacionSimple(int numero, double precioNoche, boolean ocupada, boolean minibar) {
        super(numero, precioNoche, ocupada);
        this.minibar=minibar;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    @Override
    public double calcularPrecio(int noches){
        return this.getPrecioNoche()*noches;
    }
}
