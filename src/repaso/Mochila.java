package repaso;

import java.util.ArrayList;

public class Mochila {
    private ArrayList<String> herramientas;

    public Mochila(String textoHerramientas) {
        this.herramientas = new  ArrayList<>();

        /*split busca la coma en el texto y corta la frase en trozos
        si pone "hachca, escudo" crea un Array temporal ["hacha", "escudo"]*/
        String[] texto = textoHerramientas.split(",");
        for (String s : texto) {
            /* trim quita los espacios vacios que quedan detras de las comas, toLowerCase lo pasa toodo a minuiscua */
            String herramienta = s.trim().toLowerCase();
            //guarda la palabra limpia en el array definitivo
            this.herramientas.add(herramienta);
        }
    }

    /* recorre el array y une los datos en una sola frase
    toma la herramienta, le pega una coma y espacio, va a la siguiente... y asi sucesivamente
     */
    public String imprimirHerramientas() {
        return String.join(", ", herramientas);
    }
    public ArrayList<String> getHerramientas() {return herramientas;}

}
