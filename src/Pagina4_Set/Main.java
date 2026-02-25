package Pagina4_Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    private static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args){
        CuerpoCeleste planeta1 = new Planeta("Mercurio", 88);
        CuerpoCeleste planeta2 = new Planeta("Venus", 225);
        CuerpoCeleste planeta3 = new Planeta("La Tierra", 365);
        CuerpoCeleste planeta4 = new Planeta("Marte", 687);
        CuerpoCeleste planeta5 = new Planeta("Jupiter", 4332);
        CuerpoCeleste planeta6 = new Planeta("Saturno", 10759);
        CuerpoCeleste planeta7 = new Planeta("Urano", 30660);
        CuerpoCeleste planeta8 = new Planeta("Neptuno", 165);
        CuerpoCeleste planeta9 = new Planeta("Pluton", 248);
        CuerpoCeleste planeta0 = new Planeta("Pluton", 884);

        CuerpoCeleste enano = new PlanetaEnano("Pluton", 884);
        sistemaSolar.put("Mercurio", planeta1);
        sistemaSolar.put("Venus", planeta2);
        sistemaSolar.put("La Tierra", planeta3);
        sistemaSolar.put("Marte", planeta4);
        sistemaSolar.put("Jupiter", planeta5);
        sistemaSolar.put("Saturno", planeta6);
        sistemaSolar.put("Urano", planeta7);
        sistemaSolar.put("Neptuno", planeta8);
        sistemaSolar.put("Pluton", planeta9);
        sistemaSolar.put("Pluton", planeta0);

        sistemaSolar.put("Pluton",enano);

        planetas.add(planeta1);
        planetas.add(planeta2);
        planetas.add(planeta3);
        planetas.add(planeta4);
        planetas.add(planeta5);
        planetas.add(planeta6);
        planetas.add(planeta7);
        planetas.add(planeta8);
        planetas.add(planeta9);
        planetas.add(planeta0);

        planetas.add(enano);


        CuerpoCeleste luna1 = new Luna("Luna", 27);
        CuerpoCeleste luna2 = new Luna("Deimos", 1.3);
        CuerpoCeleste luna3 = new Luna("Phobos", 0.3);
        CuerpoCeleste luna4 = new Luna("Io", 1.8);
        CuerpoCeleste luna5 = new Luna("Europa", 3.5);
        CuerpoCeleste luna6 = new Luna("Ganymede", 7.1);
        CuerpoCeleste luna7 = new Luna("Callisto", 16.7);
        CuerpoCeleste lunaExtra_Tierra_Jupiter = new Luna("Tierra_Jupiter", 000);
        sistemaSolar.put("Luna", luna1);
        sistemaSolar.put("Deimos", luna2);
        sistemaSolar.put("Phobos", luna3);
        sistemaSolar.put("Io", luna4);
        sistemaSolar.put("Europa", luna5);
        sistemaSolar.put("Ganymede", luna6);
        sistemaSolar.put("Callisto", luna7);
        sistemaSolar.put("Tierra_Jupiter", lunaExtra_Tierra_Jupiter);

        planeta3.addSatelite(luna1);
        planeta4.addSatelite(luna2);
        planeta4.addSatelite(luna3);
        planeta5.addSatelite(luna4);
        planeta5.addSatelite(luna5);
        planeta5.addSatelite(luna6);
        planeta5.addSatelite(luna7);
        planeta3.addSatelite(lunaExtra_Tierra_Jupiter);
        planeta5.addSatelite(lunaExtra_Tierra_Jupiter);

        //imprimir planetas
        System.out.println("Planetas:");
        for (CuerpoCeleste p : planetas){
            System.out.println(p);
        }

        //lunas de marte
        System.out.println("---");
        System.out.println("Lunas de Marte:");
        CuerpoCeleste marte = sistemaSolar.get("Marte");
        for (CuerpoCeleste lunas : marte.getSatelite()){
            System.out.println(lunas);
        }

        //imprimir lunas
        System.out.println("---");
        System.out.println("Todas las lunas:");
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste pt : planetas){
            lunas.addAll(pt.getSatelite());
        }
        for (CuerpoCeleste todasLunas : lunas){
            System.out.println(todasLunas);
        }

        //diferencia lunas de tierra y lunas de jupiter
        System.out.println("---");
        HashSet<CuerpoCeleste> diferencia = new HashSet<>(planeta3.getSatelite());
        diferencia.removeAll(planeta5.getSatelite());
        System.out.println("Diferencia (lunas Tierra - lunas Jupiter" + diferencia);

        //interseccion lunas tierra y lunas jupiter
        System.out.println("---");
        Set<CuerpoCeleste> interseccion = new HashSet<>(planeta3.getSatelite());
        interseccion.retainAll(planeta5.getSatelite());
        System.out.println("interseccion: " + interseccion);

    }
}
