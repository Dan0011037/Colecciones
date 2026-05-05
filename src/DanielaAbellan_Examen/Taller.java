package DanielaAbellan_Examen;

import EXAMEN.Clientes;

import java.util.*;

public class Taller {
    List<Vehiculo> misVehiculos= new LinkedList<Vehiculo>();
    List<OrdenReparacion> misOrdenesReparacion= new ArrayList<OrdenReparacion>();
    Map<String, Cliente> misClientes= new HashMap<String, Cliente>();

    public Cliente buscarCli(String dni){
        if (misClientes.containsKey(dni)){
            return misClientes.get(dni);
        }else{
            System.out.println("Cliente con dni " + dni + " no existe");
            return null;
        }
    }

    public boolean registrarCliente(Cliente cliente){
        if (misClientes.containsKey(cliente.getDni())) {
            System.out.println("El cliente existe");
            return false;
        }else{
            misClientes.put(cliente.getDni(), cliente);
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

    public boolean agregarVeihculo(Vehiculo vehiculo){
        if (misVehiculos.contains(vehiculo)){
            System.out.println("Este vehiculo ya existe");
            return false;
        }else{
            misVehiculos.add(vehiculo);
            System.out.println("Vehiculo agregado");
            return true;
        }
    }

    public boolean crearOrdenReparacion(String dni, String matricula, int numHoras){
        Cliente cliente = buscarCli(dni);
        Vehiculo vehiculo = buscarVehiculo(matricula);

        if (cliente == null ||  vehiculo == null || vehiculo.isEnReparacion()){
            System.out.println("CLiente y/o vehiculo no existe o el vehiculo se encuentra en reparacion");
            return false;
        }
        if (vehiculo.abrirOrden(numHoras)){
            misOrdenesReparacion.add(new OrdenReparacion(cliente,vehiculo,numHoras));
            System.out.println("Orden reparacion agregada");
            return true;
        }else{
            System.out.println("El vehiculo no se encuentra en reparacion");
            return false;
        }
    }

    public boolean cerrarOrdenReparacion(String matricula){

        OrdenReparacion eliminarOrdenReparacion = null;
        for (OrdenReparacion ordenReparacion : misOrdenesReparacion){
            if (ordenReparacion.getVehiculo().getMatricula().equals(matricula)){
                eliminarOrdenReparacion =  ordenReparacion;
            }
            break;
        }
        if (eliminarOrdenReparacion!=null){
            misOrdenesReparacion.remove(eliminarOrdenReparacion);
            System.out.println("Orden reparacion eliminada");
            return true;
        }else{
            System.out.println("Vehiculo no encontrado");
            return false;
        }
    }

    public void listarOrdenes(){
        for (int i = 0; i<misOrdenesReparacion.size();i++){
            OrdenReparacion ordenReparacion = misOrdenesReparacion.get(i);
            System.out.println("Orden de reparacion:" +
                    "Vehiculo: " + ordenReparacion.getVehiculo() +
                    "Horas estimadas: " + ordenReparacion.getHorasEstimadas() +
                    "Coste total: " + ordenReparacion.getCosteTotal());
        }
    }

    public  void listarVehiculosDisponibles(){
        for (Vehiculo vehiculo : misVehiculos){
            if (!vehiculo.isEnReparacion()){
                System.out.println("Vehiculo: " +
                        " Marca: " + vehiculo.getMarca() +
                        " Matricula: " + vehiculo.getMatricula() +
                        " Precio por hora: " + vehiculo.getPrecioHora());
            }
        }
    }

    public void listarClientes(){
        for (Cliente cliente : misClientes.values()){
            System.out.println("Cliente: " +
                    ",DNI: " + cliente.getDni() +
                    ", Nombre: " + cliente.getNombre());
        }
    }

}
