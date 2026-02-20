package Pagina3_Mapas;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainUbicacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Ubicacion> ubicaciones = new LinkedHashMap<>();

        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programacion."));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una monatña."));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañandote en la playa."));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto."));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente."));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque."));

        //montaña
        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 2);
        ubicaciones.get(1).addExit("Q", 0);

        //playa
        ubicaciones.get(2).addExit("N", 5);
        ubicaciones.get(2).addExit("Q", 0);

        //edificio
        ubicaciones.get(3).addExit("O", 1);
        ubicaciones.get(3).addExit("Q", 0);

        //puente
        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);
        ubicaciones.get(4).addExit("Q", 0);

        //bosque
        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);
        ubicaciones.get(5).addExit("Q", 0);

        int ubicacionActual = 1;
        boolean continuar= true;

        while(continuar){
            Ubicacion ubicacion = ubicaciones.get(ubicacionActual);
            System.out.println(ubicacion.getDescripcion());

            // finaliza
            if (ubicacionActual == 0){
                continuar = false;
            }else {
                System.out.print("Tus salidas validas son: ");
                for (String exits : ubicacion.getExits().keySet()){
                    System.out.print(exits + " ");
                }
                System.out.println();

                System.out.println("INPUT: ");
                String exits = scanner.nextLine().toUpperCase();

                if (ubicacion.getExits().containsKey(exits)){
                    ubicacionActual=ubicacion.getExits().get(exits);
                }else{
                    System.out.println("No puedes ir ahi");
                }
            }
            System.out.println("---");
        }
    }
}
