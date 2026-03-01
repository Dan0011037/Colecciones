package repaso.Arte;

import java.util.ArrayList;

public class Obras {
    private String nombreObra;
    private String tipoDeObra;
    private int precioAprox;
    private int anoDeRealizacion;
    private Artistas artistas;

    ArrayList<Obras> misObras = new ArrayList<>();
    public Obras(String nombreObra, String tipoDeObra, int precioAprox, int anoDeRealizacion, Artistas artistas) {
        this.nombreObra = nombreObra;
        this.tipoDeObra = tipoDeObra;
        this.precioAprox = precioAprox;
        this.anoDeRealizacion = anoDeRealizacion;
        this.artistas = artistas;
    }

    public String getNombreObra() {
        return nombreObra;}

    public String getTipoDeObra() {
        return tipoDeObra;}

    public int getPrecioAprox() {
        return precioAprox;}

    public int getAnoDeRealizacion() {
        return anoDeRealizacion;}

    public Artistas getArtistas() {
        return artistas;
    }

    public Obras(ArrayList<Obras> misObras) {
        this.misObras = misObras;
    }

    private int buscarObras(Obras obras) {
        return misObras.indexOf(obras);
    }

    //buscar por nombre de obra
    private int buscarObras(String nombre) {
        for (int i  = 0; i < misObras.size(); i++) {
            if (misObras.get(i).getNombreObra().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    //añadir obra
    public boolean anadirObras(Obras obras) {
        if (buscarObras(obras.getNombreObra()) >= 0) {
            return false;
        }
        misObras.add(obras);
        return true;
    }

    //eliminar obra
    public boolean eliminarObras(String nombre) {
            for (int i = 0; i < misObras.size(); i++){
                if (misObras.get(i).getNombreObra().equals(nombre)){
                    misObras.remove(i);
                    return true;
                }
            }
            return false;
    }

    //buscador obra
    public Obras queryObras(String nombre){
        for (Obras obras : misObras) {
            if (obras.getNombreObra().equals(nombre)) {
                return obras;
            }
        }
        return null;
    }

    public ArrayList<Obras> getMisObras(){
        return misObras;
    }

}
