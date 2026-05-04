package EXAMEN;

public class HabitacionDoble extends Habitacion{
    private boolean vistas= false;

    public HabitacionDoble(int numero, double precioNoche, boolean ocupada, boolean vistas) {
        super(numero, precioNoche, ocupada);
        this.vistas=vistas;
    }

    public boolean isVistas() {return vistas;
    }

    public void setVistas(boolean vistas) {this.vistas = vistas;
    }


    @Override
    public double calcularPrecio(int noches) {
        double precioTotal= this.getPrecioNoche()*noches;
        if (this.vistas){
            //si tiene visitas incrementa por cinco el precio por cada noche reservada
            precioTotal+=(5*noches);
        }
        return precioTotal;
    }
}
