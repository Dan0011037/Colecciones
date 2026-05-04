package Practica3_Videojuegos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Torneo {
    private String nombre;
    private String juego;

    Map<String, Participante> misParticipantes= new HashMap<String, Participante>();
    List<Partida> historialPartidas= new LinkedList<Partida>();
    List<Torneo> misTorneos= new LinkedList<Torneo>();


    public boolean inscribirParticipante(Participante participante){
        if (misParticipantes.containsKey(participante.getApodo())){
            System.out.println("El participante "+participante+" ya existe");
            return false;
        }else{
            //El apodo es la clave, el participante el valor
            misParticipantes.put(participante.getApodo(), participante);
            System.out.println("Registrado");
            return true;
        }
    }

    public Participante buscarParticipante(String apodo){
        if (misParticipantes.containsKey(apodo)){
            return misParticipantes.get(apodo);
        }else{
            System.out.println("El participante "+apodo+" no existe");
            return null;
        }
    }

    public boolean registrarVictorias(String apodo){
        if (misParticipantes.containsKey(apodo)){
            misParticipantes.get(apodo).registrarVictorias();
            return true;
        }else{
            System.out.println("No existe");
            return  false;
        }
    }

    public void agregarPartida(Partida p){
        historialPartidas.add(p);
        System.out.println("Partida agregada");
    }

    public void mostrarClasificacion(){
        for (Participante p : misParticipantes.values()){
            System.out.println(p.toString());
        }
    }

    public Participante mostrarLider(){
        // aun no se a comenzado a buscar
        Participante lider=null;
        //recorro todos mis participantes
        for (Participante p : misParticipantes.values()){
            // si el lider es null (es el primer valor, aun no se han visto mas participantes por lo que es el unico)
            // si el valor actual es mayor al del lider anterior, el valor actual pasa a ser el lider
            if (lider==null || p.getPuntuacion()>lider.getPuntuacion()){
                lider=p;
            }
        }
        return lider;
    }
}
