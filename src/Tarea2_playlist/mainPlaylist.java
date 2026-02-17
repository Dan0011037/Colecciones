package Tarea2_playlist;
import java.util.*;

public class mainPlaylist {
    private static Scanner scanner = new Scanner(System.in);
    private static Album album1 = new Album("New Jeans: 1st EP", "New Jeans");
    private static Album album2 = new Album("Super real me", "Illit");

    public static void imprimirLista(LinkedList<Cancion> canciones){
        Iterator<Cancion> iterator = canciones.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void menu(){
        System.out.println("0. Salir de la lista de reproduccion.");
        System.out.println("1. Reproducior siguiente cancion en la lista.");
        System.out.println("2. Reproducior la cancion previa en la lista.");
        System.out.println("3. Repetir la cancion actual.");
        System.out.println("4. Imprimir la lista de canciones en la playlist.");
        System.out.println("5. Volver a imprimir el menu.");
        System.out.println("6. Eliminar cancion actual.");
    }

    public static void play (LinkedList<Cancion> playlist){
        if (playlist.isEmpty()){
            System.out.println("Lista vacia.");
            return;
        }else {

            ListIterator<Cancion> iterator = playlist.listIterator();
            boolean continuar = true;
            boolean siguiente = true;
            int opcion;

            menu();
            Cancion actual = iterator.next();
            System.out.println("----");
            System.out.println("CANCION ACTUAL " + actual);
            System.out.println("----");

            while (continuar) {
                System.out.println("Elija: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Adios.");
                        continuar = false;
                        break;
                    case 1:
                        if (iterator.hasNext()) {
                            System.out.println("Escuchando: " + iterator.next());
                        } else System.out.println("No hay mas canciones.");
                        System.out.println("----");
                        break;
                    case 2:
                        if (iterator.hasPrevious()) {
                            System.out.println("Escuchando:" + iterator.previous());
                        }else System.out.println("No hay mas canciones.");
                        System.out.println("----");
                        break;
                    case 3:
                        if (iterator.hasPrevious()) {
                            Cancion repetirAnterior = iterator.previous();
                            System.out.println(repetirAnterior);
                            iterator.next();

                        } else {
                            if (iterator.hasNext()) {
                                Cancion repetirSiguiente = iterator.next();
                                System.out.println(repetirSiguiente);
                                iterator.previous();
                            }
                        }
                        break;
                    case 4:
                        imprimirLista(playlist);
                        System.out.println("----");
                        break;
                    case 5:
                        menu();
                        System.out.println("----");
                        break;
                    case 6:
                        System.out.println("Cancion actual eliminada");
                        iterator.remove();
                        break;
                    default:
                        System.out.println("No valido");
                        System.out.println("---");
                        break;
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Album> albums = new ArrayList<>();
        LinkedList<Cancion> playlist = new LinkedList<>();

        Album album1 = new Album("New Jeans: 1st EP", "New Jeans");
        album1.addSong("Attention", 2.59);
        album1.addSong("Hype Boy", 2.58);
        album1.addSong("Cookie", 3.55);
        album1.addSong("Hurt", 2.57);
        albums.add(album1);

        Album album2 = new Album("Super real me", "Illit");
        album2.addSong("My World",1.47);
        album2.addSong("Magnetic", 2.39);
        album2.addSong("Midnight fiction", 2.47);
        album2.addSong("Lucky girl syndrome",2.19);
        albums.add(album2);

        albums.get(0).addToPlaylist("Attention", playlist);
        albums.get(0).addToPlaylist("Hype Boy", playlist);
        albums.get(0).addToPlaylist("Cookie", playlist);
        albums.get(0).addToPlaylist("Hurt", playlist);
        albums.get(1).addToPlaylist("My World",playlist);
        albums.get(1).addToPlaylist("Magnetic",playlist);
        albums.get(1).addToPlaylist("Midnight fiction",playlist);
        albums.get(1).addToPlaylist("Lucky girl syndrome",playlist);

        play(playlist);
    }

}
