
import Pagina1.Contacto;

import java.util.ArrayList;

public class Aeropuerto {
    ArrayList<Vuelos> misVuelos = new ArrayList<Vuelos>();

    public Aeropuerto(ArrayList<Vuelos> misVuelos) {
        this.misVuelos = misVuelos;
    }

    //busca el vuelo
    private int buscarVuelos(Vuelos vuelos) {
        return misVuelos.indexOf(vuelos);
    }

    //busca el vuelo del nuemor introducido y te devuelve su posicion (encontrado en el buscarVuelos de arriba)
    private int buscarVuelos(String numero) {
        for (Vuelos vuelos : misVuelos) {
            if (vuelos.getNumero().equals(numero)) {
                return buscarVuelos(vuelos);
            }
        }
        return -1;
    }

    //añadir nuevo vuelo
    public boolean anadirVuelo(Vuelos vuelos) {
        if (buscarVuelos(vuelos.getNumero()) >= 0) {
            return false;
        }
        misVuelos.add(vuelos);
        return true;
    }

    //eliminar vuelo por numero
    public boolean eliminarVuelo(String numero){
        for (int i = 0; i < misVuelos.size(); i++){
            if (misVuelos.get(i).getNumero().equals(numero));
            misVuelos.remove(i);
            return true;
        }
        return false;
    }

    //imprimir vuelos
    public void imprimirVuelos(){
        for (int i =0; i<misVuelos.size();i++){
            Vuelos vuelos = misVuelos.get(i);
            System.out.println(vuelos.getNumero() + ", " + vuelos.getOrigen() + ", " + vuelos.getDestino() + ", " + vuelos.getClase() + ", " + vuelos.getDia());
        }
    }

    //buscador
    public Vuelos buscadorVuelo(String numero){
        for (Vuelos vuelos : misVuelos) {
            if (vuelos.getNumero().equals(numero)) {
                return vuelos;
            }
        }
        return null;
    }

    public ArrayList<Vuelos> getMisVuelos(){
        return misVuelos;
    }

}
