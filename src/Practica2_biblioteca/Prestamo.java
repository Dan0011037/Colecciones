package Practica2_biblioteca;

public class Prestamo{
    private String fechaPrestamo;
    private int diasPrestamo;
    private double multaTotal;
    private Documento documento;


    public Prestamo(Socio socio, Documento documento, int diasPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.diasPrestamo = diasPrestamo;
        this.multaTotal = multaTotal;
        this.documento = documento;
    }

    public String getFechaPrestamo() {return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {this.fechaPrestamo = fechaPrestamo;
    }

    public int getDiasPrestamo() {return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {this.diasPrestamo = diasPrestamo;
    }

    public double getMultaTotal() {return multaTotal;
    }

    public void setMultaTotal(double multaTotal) {this.multaTotal = multaTotal;
    }

    public Documento getDocumento() {return documento;
    }

    public void setDocumento(Documento documento) {this.documento = documento;
    }

    public double calcularMulta(int diasRetraso) {
        multaTotal = documento.calcularMulta(diasRetraso);
        return multaTotal;
    }


}
