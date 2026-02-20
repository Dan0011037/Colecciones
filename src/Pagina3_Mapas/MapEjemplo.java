package Pagina3_Mapas;

import java.util.HashMap;
import java.util.Map;

public class MapEjemplo {
    public static void main(String[] args) {
        Map<String, String> idiomas = new HashMap<>();
        idiomas.put("es", "Español");
        idiomas.put("en", "English EEUU");
        idiomas.put("ca", "English Canadá");
        idiomas.put("de", "Aleman");
        idiomas.put("fr", "Francés");
        System.out.println(idiomas.put("it", "Italian"));
        System.out.println(idiomas.put("it", "Italiano"));

        System.out.println("-");
        String valor = idiomas.get("it");
        System.out.println(valor);

        System.out.println("-");
        if (idiomas.containsKey("es")) {
            System.out.println("La clave es ya existe");
        }else System.out.println("La clave no exista");
        if (idiomas.containsValue("Español")) {
            System.out.println("El idioma español ya existe");
        }else System.out.println("El idioma no existe");

        System.out.println("-");
        for(String key: idiomas.keySet()) {
            System.out.println(key + " " + idiomas.get(key));
        }

        System.out.println("-");
        for (Map.Entry<String, String> entradaMapa: idiomas.entrySet()) {
            System.out.println(entradaMapa.getKey() + " " + entradaMapa.getValue());
        }

        System.out.println("-");
        //Forma 1
        // boolean eliminado = idiomas.remove("fr","Francés");

        //Forma 2
        if (idiomas.remove("de", "Ingles")) {
            System.out.println("de ha sido eliminado");
        } else {
            System.out.println("No existe un par clave-valor con de-Ingles");
        }

        System.out.println("-");
        idiomas.replace("es", "Spain");
        idiomas.replace("en", "English", "English EEUU");
        for(String key: idiomas.keySet()) {
            System.out.println(key + " " + idiomas.get(key));
        }
    }
}
