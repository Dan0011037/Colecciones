package repaso.Aeropuerto;

public class Vuelos {
    private String numero;
    private String origen;
    private String destino;
    private String dia;
    public enum TipoClase {turista, primera};
    private TipoClase clase;

    public Vuelos(String numero, String origen, String destino, TipoClase clase, String dia) {
        setNumero(numero);
        this.origen = origen;
        setDia(dia);
        this.clase = clase;
        this.destino = destino;
    }

    public String getNumero() {
        return numero;
    }

    public TipoClase getClase() {
        return clase;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        //solo letras
        if (origen.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            this.origen = origen;
        }else {
            System.out.println("Introduzca un origen valido.");
        }

    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        if (destino.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            this.destino = destino;
        }else {
            System.out.println("Introduzca un destino valido.");
        }
    }

    public String getDia() {
        return dia;
    }

    public void setNumero(String numero) {
        // d{4} (4 digitos) - d{2} (2 digitos)
        if (numero.matches("\\d{4}-\\d{2}")){
        this.numero = numero;
        }else{
            System.out.println("Formato de numero invalido");
            return;
        }
    }

    public void setDia(String dia) {
        if (dia.matches("\\d{2}-\\d{2}")){
            this.dia = dia;
        }else{
            System.out.println("Formato de dia invalido");
            return;
        }

    }

    public static Vuelos CrearVuelo(String numero, String origen,String destino , TipoClase clase, String dia){
        return new Vuelos(numero,origen,destino,clase,dia);
    }
}
