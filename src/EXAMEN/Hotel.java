package EXAMEN;

import java.util.*;

public class Hotel {
    List<Habitacion> misHabitaciones = new ArrayList<Habitacion>();
    List<Reserva> misReservas = new LinkedList<Reserva>();
    Set<Clientes> misClientes = new HashSet<Clientes>();


    public Clientes buscarCli(String dni){
        //por cada cliente de tipo Clientes dentro de la coleccion misClientes, compara si el dni introducido es igual al suyo, si si lo es me devuelve el cliente
        for (Clientes  cliente : misClientes){
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

    public boolean registrarCliente(Clientes cliente){
        if (misClientes.contains(cliente)){
            System.out.println("Cliente ya existe");
            return false;
        }else {
            misClientes.add(cliente);
            System.out.println("Cliente registrado");
            return true;
        }
    }

    public Habitacion buscarHab(int numero){
        //por cada habitacion de tipo Habitacion en la lista de misHabitaciones, compra si el numero introducido es igual al suyo, si lo es, me devuelve la habitacion
        for (Habitacion habitacion : misHabitaciones){
            if (habitacion.getNumero() == numero){
                return habitacion;
            }
        }
        return null;
    }

    public boolean agregarHabitacion(Habitacion habitacion){
        if (misHabitaciones.contains(habitacion)){
            System.out.println("Habitacion ya existe");
            return false;
        }else  {
            misHabitaciones.add(habitacion);
            System.out.println("Habitacion agregada");
            return true;
        }
    }

    public boolean reservarHab(String dni, int numero, int noches){
        Clientes cliente = buscarCli(dni);
        Habitacion habitacion = buscarHab(numero);

        if (cliente == null || habitacion == null){
            System.out.println("Habitacion y/o cliente no existe");
            return false;
        }


        if (habitacion.reservar(noches)){
            misReservas.add(new Reserva(cliente, habitacion, noches));
            System.out.println("Reserva agregada");
            return true;
        }else {
            System.out.println("Habitacion ocupada");
            return false;
        }
    }

    public boolean cancelarReserva(int numero){
        //busco la reserva especifica

        Reserva reservaEliminar = null;
        for (Reserva reserva : misReservas){
            // si el numero introducido es el mismo al de una reserva
            if (reserva.getHabitacion().getNumero() == numero){
                reservaEliminar = reserva;
                // al encontrarla se sale del bucle
                break;
            }
        }

        //si se encuentra esa reserva entonces se elimina de laa lista
        if (reservaEliminar != null){
            misReservas.remove(reservaEliminar);
            System.out.println("Reserva eliminada");
            return true;
        }else {
            System.out.println("Reserva no existe");
            return false;
        }
    }

    public void ImprimirReservas(){
        for (int i = 0; i<misReservas.size(); i++){
            Reserva reserva = misReservas.get(i);
            System.out.println("Reserva{" +
                    "habitacion=" + misReservas.get(i).getHabitacion() +
                    ", " + misReservas.get(i).getPrecioTotal());
        }
    }

    public void ImprimirHabitacionesDisponibles(){
        for (int i = 0; i<misHabitaciones.size(); i++){
            Habitacion habitacion = misHabitaciones.get(i);
            System.out.println("Habitacion{" +
                    "numero=" + misHabitaciones.get(i).getNumero() +
                    ", precioNoche=" + misHabitaciones.get(i).getPrecioNoche() +
                    ", ocupada=" + misHabitaciones.get(i).isOcupada() +
                    '}');
        }
    }
}