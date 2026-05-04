package Practica2_biblioteca;

import java.util.*;

public class Biblioteca {
    List<Documento> misDocumentos=new ArrayList<Documento>();
    List<Prestamo> misPrestamos = new LinkedList<Prestamo>();
    Set<Socio> misSocios = new HashSet<Socio>();

    public boolean registrarSocio(Socio socio) {
        if (misSocios.contains(socio)) {
            System.out.println("Socio existente");
            return false;
        }else{
            System.out.println("Socio agregado");
            misSocios.add(socio);
            return true;
        }
    }

    public Socio buscarSocio(String dni) {
        for (Socio socio : misSocios){
            if (socio.getDni().equals(dni)){
                return socio;
            }
        }
        return null;
    }

    public boolean agregarDocumento(Documento documento) {
        if (misDocumentos.contains(documento)) {
            System.out.println("Documento existente");
            return false;
        }else{
            System.out.println("Documento agregado");
            misDocumentos.add(documento);
            return true;
        }
    }

    public Documento buscarDocumento(String codigo) {
        for (Documento documento : misDocumentos){
            if (documento.getCodigo().equals(codigo)){
                return documento;
            }
        }
        return null;
    }

    public boolean realizarPrestamo(String dni, String codigo, int dias){
        Socio socio = buscarSocio(dni);
        Documento documento = buscarDocumento(codigo);
        if (socio== null || documento == null || !documento.isDisponible()){
            System.out.println("Socio y/o documento no encontrado o no disponible");
            return false;
        }

        if (documento.prestar(dias)){
            misPrestamos.add(new Prestamo(socio, documento, dias));
            System.out.println("Prestamo realizado");
            return true;
        }else {
            System.out.println("Prestamo no se puede realizar");
            return false;
        }
    }

    public double devolverDocumento(String codigo, int diasRetraso) {
        //busco el documento que pertenece al codigo que le paso
        Documento documento = buscarDocumento(codigo);
        double multa;
        // si recorro toda la lista y no encuentra el prestamo, devolver sigue siendo null
        Prestamo devolver = null;
        //busco el prestamo dentro de mi lista
        for (Prestamo prestamo : misPrestamos){
            // si el documento asociado al prestamo es el mismo al que yo le he pasado entonces ese es el prestamo que deseo devolver
            if (prestamo.getDocumento().getCodigo().equals(codigo)){
                devolver = prestamo;
                // en cuanto encuentro el prestamo salgo del bucle
                break;
            }
        }

        /* si el prestamo que deseo devolver no es nulo (existe) entonces devuelvo el documento (lo que lo hace pasar a ser disponible),
        elimino el prestamo indicado de mi lista de prestamos, y calculo su multa dependiendo de sus dias de retraso
         */
        if (devolver != null){
            documento.devolver();
            misPrestamos.remove(devolver);
            multa = devolver.calcularMulta(diasRetraso);
            return multa;
        }else {
            System.out.println("Prestamo no encontrado");
        }
        // algo ha ido mal en caso de que no exista el prestamo
        return -1;
    }

    public void listarDisponibles(){
        for (Documento documento : misDocumentos){
            if (documento.isDisponible()){
                System.out.println("Documento: " + documento.getCodigo() + "(" + documento.getTitulo() + "), autor: " + documento.getAutor());
            }
        }
    }

    public void listarPrestamos(){
        for (int i  = 0; i<misPrestamos.size(); i++){
            Prestamo prestamo = misPrestamos.get(i);
            System.out.println("Prestamo:" +
                    prestamo.getDocumento().getTitulo() + "("+ prestamo.getDocumento().getAutor() + "), " +
                    prestamo.getDocumento().getCodigo() + ", Prestado el: " + prestamo.getFechaPrestamo() +
                    ", Dias de prestacion: " + prestamo.getDiasPrestamo());
        }
    }
}
