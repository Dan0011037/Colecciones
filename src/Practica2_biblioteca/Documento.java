package Practica2_biblioteca;

import EXAMEN.Reservable;

import java.util.Objects;

public abstract class Documento implements Prestable{
    private String codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public abstract double calcularMulta(int diasRetraso);

    public Documento(String codio, String titulo, String autor, boolean disponible) {
        this.codigo = codio;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    public String getCodigo() {return codigo;
    }
    public void setCodio(String codio) {this.codigo = codio;
    }
    public String getTitulo() {return titulo;
    }
    public void setTitulo(String titulo) {this.titulo = titulo;
    }
    public String getAutor() {return autor;
    }
    public void setAutor(String autor) {this.autor = autor;
    }
    public boolean isDisponible() {return disponible;
    }
    public void setDisponible(boolean disponible) {this.disponible = disponible;
    }

    @Override
    public boolean prestar(int dias) {
        if (disponible) {
            disponible = false;
            return true;
        }else  {
            System.out.println("No se puede prestar, ya esta alquilado");
            return false;
        }
    }

    @Override
    public boolean devolver() {
        if (!disponible) {
            disponible = true;
            return true;
        }else   {
            System.out.println("Este libro no esta alquilado, no se puede devolver");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(codigo, documento.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
