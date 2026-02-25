package Pagina4_Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {

    public enum TipoCuerpoCeleste{
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }

    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelite;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satelite = new HashSet<>();
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;}

    public String getNombre() {
        return nombre;}

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;}

    public Set<CuerpoCeleste> getSatelite() {
        return new HashSet<>(satelite);
    }

    public boolean addSatelite(CuerpoCeleste satelite){
        return this.satelite.add(satelite);
    }

    public boolean equals(Object obejot){
        if (this == obejot){
            return true;
        } else if (obejot == null || getClass() != obejot.getClass()) return false;
        CuerpoCeleste igual = (CuerpoCeleste) obejot;
        return nombre.equals(igual.getNombre()) && tipoCuerpo.equals(igual.getTipoCuerpo());
    }

    public int hashCode(){;
        return this.nombre.hashCode() + this.tipoCuerpo.hashCode() + 31;
    }

    public String toString() {
        return "Nombre: " + getNombre() + " - Tipo: " + getTipoCuerpo() + " - Periodo Orbital: " + getPeriodoOrbital();
    }
}
