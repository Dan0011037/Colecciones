package repaso;

import java.util.ArrayList;
import java.util.Scanner;


public class MainObras {
    private static Scanner scanner = new Scanner(System.in);
    private static Artistas artistasMain = new Artistas(new ArrayList<Artistas>());
    private static Obras obrasMain = new Obras(new ArrayList<Obras>());


    public static void menu() {
        System.out.println("""
                ================
                Galería de arte
                ================
                1. Añadir obra.
                2. Añadir artista.
                3. Buscar obra por nombre.
                4. Buscar obra por artista.
                5. Eliminar obra.
                6. Encontrar obra mas barata.
                7. Encontrar obra mas cara.
                8. Salir.
                """);
    }

    public static void artistas(){
        artistasMain.anadirArtista(new Artistas("Leonardo da Vinci" , "italiano"));
        artistasMain.anadirArtista(new Artistas("Pablo Picasso", "español"));
        artistasMain.anadirArtista(new Artistas("Auguste Rodin", "frances"));
    }

    public static void obras(){
        obrasMain.anadirObras(new Obras("Salvator Mundi", "óleo sobre madera", 450000000, 1500, artistasMain.queryArtistas("Leonardo da Vinci")));
        obrasMain.anadirObras(new Obras("La Gioconda", "óleo sobre madera", 870000000, 1503, artistasMain.queryArtistas("Leonardo da Vinci")));
        obrasMain.anadirObras(new Obras("El pensador", "escultura", 11000000, 1904, artistasMain.queryArtistas("Auguste Rodin")));
        obrasMain.anadirObras(new Obras("El sueño", "óleo sobre lienzo", 155000000, 1932, artistasMain.queryArtistas("Pablo Picasso")));
        obrasMain.anadirObras(new Obras("El Guernica", "óleo sobre lienzo", 2000000000, 1937, artistasMain.queryArtistas("Pablo Picasso")));
    }

    //encontrar obra más barata
    public static void obraBarata(){
        //Comprobamos que haya obras.
        if (obrasMain.getMisObras().isEmpty()){
            System.out.println("No hay ninguan obra");
            return;
        }
        //tomamos la primera obra como la mas barata
        Obras obraMASBarata = obrasMain.getMisObras().get(0);
        for (Obras obras : obrasMain.getMisObras()) {
            //miramos si el precio de la obra actual es mas barato que el de la primera
            if (obras.getPrecioAprox() < obraMASBarata.getPrecioAprox()) {
                //si es mas barata se actualiza
                obraMASBarata = obras;
            }
        }
        System.out.println(" ===Obra mas barata=== \nNombre obra: " + obraMASBarata.getNombreObra() + "\nTipo de obra: " + obraMASBarata.getTipoDeObra() + "\nPrecio aproximado: " + obraMASBarata.getPrecioAprox() + "\nAño de realizacion: " + obraMASBarata.getAnoDeRealizacion() + "\nArtista: " + obraMASBarata.getArtistas().getNombre());

    }

    //encontrar obra más moderna
    public static void obraModerna(){
        if (obrasMain.getMisObras().isEmpty()){
            System.out.println("No hay ninguan obra");
            return;
        }

        Obras obraMASModern = obrasMain.getMisObras().get(0);
        for (Obras obras : obrasMain.getMisObras()) {
            if (obras.getAnoDeRealizacion() < obraMASModern.getPrecioAprox()) {
                obraMASModern = obras;
            }
        }
        System.out.println(" ===Obra mas moderna=== \nNombre obra: " + obraMASModern.getNombreObra() + "\nTipo de obra: " + obraMASModern.getTipoDeObra() + "\nPrecio aproximado: " + obraMASModern.getPrecioAprox() + "\nAño de realizacion: " + obraMASModern.getAnoDeRealizacion() + "\nArtista: " + obraMASModern.getArtistas().getNombre());

    }

    //buscar obra por artista
    public static void buscarArtista() {
        if (artistasMain.getMisArtistas().isEmpty()){
            System.out.println("La lista de repaso.Artistas está vacía");
            return;
        }
        System.out.println("Nombre del artista: ");
        String nombre = scanner.nextLine();
        Artistas artistas = MainObras.artistasMain.queryArtistas(nombre);

        if (artistas == null) {
            System.out.println("Este artrista no existe.");
        } else {
            System.out.println("Nombre: " + artistas.getNombre() + "\nNacionalidad: " + artistas.getNacionalidad() +
            "\n repaso.Obras: ");
            boolean tieneObras = false;
            for (Obras obrasArtista: obrasMain.getMisObras()){
                if (obrasArtista.getArtistas().getNombre().equals(nombre)){
                    System.out.println(obrasArtista.getNombreObra());
                    tieneObras = true;
                }
            }
        }
    }

    //buscar obra por nombre
    public static void buscarObras() {
        if (obrasMain.getMisObras().isEmpty()){
            System.out.println("La lista de obras esta vacía");
            return;
        }
        System.out.println("Nombre de la obra: ");
        String nombre = scanner.nextLine();
        Obras obras = obrasMain.queryObras(nombre);

        if (obras == null) {
            System.out.println("Este obra no existe.");
        } else {
            System.out.println("Nombre obra: " + obras.getNombreObra() + "\nTipo de obra: " + obras.getTipoDeObra() + "\nPrecio aproximado: " + obras.getPrecioAprox() + "\nAño de realizacion: " + obras.getAnoDeRealizacion() + "\nArtista: " + obras.getArtistas().getNombre());
        }
    }

    //añadir obras
    public static void anadirObras() {
        System.out.println("Nombre del obra: ");
        String nombre = scanner.nextLine();

        System.out.println("Tipo de obra: ");
        String tipo = scanner.nextLine();

        System.out.println("Precio aproximado: ");
        int precioAprox = scanner.nextInt();

        System.out.println("Ano de realizacion: ");
        int anoDeRealizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Artista: ");
        String artista = scanner.nextLine();
        Artistas artistaEncontrado = artistasMain.queryArtistas(artista);

        if (artistaEncontrado == null) {
            System.out.println("El artista no existe.");
        }else {
            Obras nuevaObra = new Obras(nombre, tipo, precioAprox, anoDeRealizacion, artistaEncontrado);
            if (obrasMain.anadirObras(nuevaObra)) {
                System.out.println("Obra añadida a la lista");
            }else {
                System.out.println("Esta obra YA existe.");
                System.out.println("No se puede añadir");
            }
        }
    }

    //añadir artista
    public static void anadirArtista() {
        System.out.println("Nombre del artista: ");
        String nombre = scanner.nextLine();

        System.out.println("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        Artistas nuevoArtista = new Artistas(nombre, nacionalidad);
        if (artistasMain.anadirArtista(nuevoArtista)) {
            System.out.println("Artista añadido a la lista");
        }else {
            System.out.println("Este artista YA existe.");
            System.out.println("No se puede añadir");
        }
    }

    //eliminar obra
    public static void eliminarObras() {
        System.out.println("Nombre de la obra que desea eliminar: ");
        String nombre = scanner.nextLine();

        if (obrasMain.eliminarObras(nombre)) {
            System.out.println("obra eliminada con exito.");
        } else {
            System.out.println("Esta obra no existe.");
        }
    }

    // main
    public static void main(String args[]) {
        artistas();
        obras();
        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    anadirObras();
                    System.out.println("-------");
                    break;
                case 2:
                    anadirArtista();
                    System.out.println("-------");
                    break;
                case 3:
                    buscarObras();
                    System.out.println("-------");
                    break;
                case 4:
                    buscarArtista();
                    System.out.println("-------");
                    break;
                case 5:
                    eliminarObras();
                    System.out.println("-------");
                    break;
                case 6:
                    obraBarata();
                    System.out.println("-------");
                    break;
                case 7:
                    obraModerna();
                    System.out.println("-------");
                    break;
                case 8:
                   continuar = false;
                   break;
                default:
                    System.out.println("No valido");
                    System.out.println("---");
                    break;
            }
        }
    }
}
