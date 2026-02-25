package Pagina4_Set;

public class Planeta extends CuerpoCeleste{

    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    public boolean addSatelite(CuerpoCeleste satelite){
        if (satelite.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)){
            return super.addSatelite(satelite);
        }
        return false;
    }
}
