package Practica2_biblioteca;

public class Libro extends Documento{
    private int numeroPaginas;
    public String genero;

    public Libro(String codigo, String titulo, String autor, boolean disponible, int numeroPaginas, String genero) {
        super(codigo, titulo, autor, disponible);
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    public int getNumeroPaginas() {return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {this.numeroPaginas = numeroPaginas;
    }

    public String getGenero() {return genero;
    }

    public void setGenero(String genero) {this.genero = genero;
    }

    @Override
    public double calcularMulta(int diasRetraso) {
        //por cada dia de retraso se incrementa 0.50
        return diasRetraso*0.50;
    }
}
