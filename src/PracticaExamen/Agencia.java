package PracticaExamen;

import java.util.*;

public class Agencia {
    List<Vehiculo> misVehiculos= new ArrayList<Vehiculo>();
    List<Alquiler> misAlquileres = new LinkedList<Alquiler>();
    Set<Cliente> misClientes= new HashSet<Cliente>();

    public Cliente buscarCliente(String dni){
        for (Cliente cliente : misClientes){
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

    public boolean registrarCliente(Cliente cliente){
        if (misClientes.contains(cliente)){
            System.out.println("Este cliente ya existe");
            return false;
        }else {
            misClientes.add(cliente);
            System.out.println("Cliente registrado");
            return true;
        }
    }

    public Vehiculo buscarVehiculo(String matricula){
        for (Vehiculo vehiculo : misVehiculos){
            if (vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }
        return null;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        if (misVehiculos.contains(vehiculo)){
            System.out.println("Este vehiculo ya existe");
            return false;
        }else  {
            misVehiculos.add(vehiculo);
            System.out.println("Vehiculo agregado");
            return true;
        }
    }

    public boolean gestionarAlquiler(String dni, String matricula, int dias){
        Cliente cliente = buscarCliente(dni);
        Vehiculo vehiculo = buscarVehiculo(dni);
        if (cliente == null || vehiculo == null){
            System.out.println("El cliente y/o vehiculo no existe");
            return false;
        }
        if (vehiculo.alquilar(dias)){
            misAlquileres.add(new Alquiler(cliente, vehiculo, dias));
            System.out.println("Alquiler agregado");
            return true;
        }else  {
            System.out.println("El vehiculo ya esta alquilado por lo que no se puede alquilar ahora");
            return false;
        }
    }

    public boolean gestionarDevolucion(String matricula){
        Vehiculo vehiculo = buscarVehiculo(matricula);
        for (Alquiler alquiler : misAlquileres){
            if (vehiculo.getMatricula().equals(matricula)){
                misAlquileres.remove(alquiler);
                System.out.println("Alquiler cancelado");
                return true;
            }
        }
        return false;
    }

    public void listarAlquileres(){
        for (int i = 0; i<misAlquileres.size();i++){
            Alquiler alquiler = misAlquileres.get(i);
            System.out.println("Alquiler{ " +
                    "Dias de alquiler: " + misAlquileres.get(i).getDias() +
                    ", Coste total: " + misAlquileres.get(i).getCosteTotal()
            + " }");
        }
    }

    public void listarVehiculos(){
        for (int i = 0; i<misVehiculos.size();i++){
            Vehiculo vehiculo = misVehiculos.get(i);
            System.out.println("Vehiculos{ " +
                    "Matricula: " + misVehiculos.get(i).getMatricula() +
                    ", Precio por dia: " + misVehiculos.get(i).getPrecioDia() +
                    ", Ocupabilidad: " +  misVehiculos.get(i).isDisponible()
            + " }");
        }
    }
}
