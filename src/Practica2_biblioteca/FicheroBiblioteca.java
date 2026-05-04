package Practica2_biblioteca;

import EXAMEN.Hotel;

import java.io.*;

public class FicheroBiblioteca {
    private static Biblioteca miBiblioteca=new Biblioteca();

    public void guardarSocios() throws IOException{
        //abre el fichero, si no existe lo crea
        BufferedWriter bw = new BufferedWriter(new FileWriter("socios.txt"));
        // recorre misSocios, por cada socio escribe sus datos
        for (Socio socio : miBiblioteca.misSocios){
            bw.write(socio.getDni() + "," + socio.getNome() + "," + socio.getEmail());
            // salta a la siguiente linea
            bw.newLine();
        }
        bw.close();
    }

    public void cargarSocios() throws IOException{
        // abro socio.txt
        BufferedReader br = new BufferedReader(new FileReader("socios.txt"));
        String linea;
        // lee una linea cada vez, lo trocea por comas: datos[0] es dni, datos[1] es nombre, datos[2] es email
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            // con estos datos construye el objeto Socio y lo añade al Set. Cuando no quedan lineas devuelve null
            Socio socio = new Socio(datos[0], datos[1], datos[2]);
            miBiblioteca.misSocios.add(socio);
        }
        br.close();
    }

    public void guardarDocumentos() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("documentos.txt"));
        for (Documento documento : miBiblioteca.misDocumentos){
            if (documento instanceof Revista){
                bw.write("REVISTA," +documento.getCodigo() + "," + documento.getTitulo() + "," + documento.getAutor() + "," + documento.isDisponible() + ","+ ((Revista) documento).getNumeroEdicion() + "," + ((Revista) documento).getPeriodicidad());
                bw.newLine();
            }else if (documento instanceof Libro){
                bw.write("LIBRO," + documento.getCodigo() + "," + documento.getTitulo() + "," + documento.getAutor() + ","+ documento.isDisponible() +","+ ((Libro) documento).getNumeroPaginas() + "," + ((Libro) documento).getGenero());
                bw.newLine();
            }

        }
        bw.close();
    }

    public void cargarDocumentos() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("documentos.txt"));
        String linea;
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            boolean disponible= datos[4].equals("true");

            if (datos[0].equals("REVISTA")){
                Documento revista= new Revista(datos[1], datos[2], datos[3], disponible, Integer.parseInt(datos[5]), datos[6]);
                miBiblioteca.misDocumentos.add(revista);
            }else if (datos[0].equals("LIBRO")){
                Documento libro = new Libro(datos[1],datos[2],datos[3],disponible,Integer.parseInt(datos[5]), datos[6]);
                miBiblioteca.misDocumentos.add(libro);
            }
        }
        br.close();
    }

    public static void main(String[] args) throws IOException{
        FicheroBiblioteca fichero = new FicheroBiblioteca();
        fichero.cargarSocios();
        fichero.cargarDocumentos();
    }
}
