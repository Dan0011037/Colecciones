package Pagina1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainContactos {
    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefonoMovil = new TelefonoMovil(new ArrayList<Contacto>());

    public static void menu() {
        System.out.println("0. salir");
        System.out.println("1. Imprimir contactos");
        System.out.println("2. Agregar nuevo contacto");
        System.out.println("3. Actualizar contacto existente");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Buscar contacto");
        System.out.println("6. Volver a imprimir lista de opciones");
    }

    public static void imprimirContactos() {
        telefonoMovil.printContacto();
    }

    public static void anyadirContacto() {
        System.out.println("Nombre del contacto:");
        String nombre = scanner.nextLine();
        System.out.println("Numero del contacto:");
        String numero = scanner.nextLine();

        Contacto contacto = new Contacto(nombre, numero);
        if (telefonoMovil.addNewContact(contacto)) {
            System.out.println("Contacto añadido con exito");
        }else {
            System.out.println("Este contacto YA existe.");
            System.out.println("No se puede añadir");
        }
    }

    public static void actualizarContacto() {
        System.out.println("Contacto antiguo: ");
        String nombre = scanner.nextLine();
        System.out.println("Numero de contacto antiguo: ");
        String numero = scanner.nextLine();

        Contacto contacto = telefonoMovil.queryContacto(nombre);
        if (contacto == null){
            System.out.println("Este contacto no existe.");
            return;
        }

            System.out.println("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Nuevo numero: ");
        String nuevoNumero = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nuevoNombre, nuevoNumero);

        if (telefonoMovil.updateContact(telefonoMovil.queryContacto(nombre), nuevoContacto)) {
            System.out.println("Contacto actualizado con exito.");
        } else {
            System.out.println("Este contacto no existe.");
        }

    }

    public static void eliminarContacto() {
        System.out.println("Nombre que quiere eliminar: ");
        String nombre = scanner.nextLine();

        if (telefonoMovil.removeContact(telefonoMovil.queryContacto(nombre))) {
            System.out.println("Contacto eliminado con exito.");
        } else {
            System.out.println("Este contacto no existe.");
        }
    }

    public static void buscarContacto() {
        System.out.println("Nombre del contacto: ");
        String nombre = scanner.nextLine();
        Contacto contacto = telefonoMovil.queryContacto(nombre);

        if (contacto == null) {
            System.out.println("Este contacto no existe.");
        } else {
            System.out.println("Nombre: " + contacto.getName() + ", telefono: " + contacto.getPhoneNumber());
        }
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu();
            System.out.println("Elija: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Adios.");
                    continuar = false;
                    break;
                case 1:
                    imprimirContactos();
                    System.out.println("-------");
                    break;
                case 2:
                    anyadirContacto();
                    System.out.println("-------");
                    break;
                case 3:
                    actualizarContacto();
                    System.out.println("-------");
                    break;
                case 4:
                    eliminarContacto();
                    System.out.println("-------");
                    break;
                case 5:
                    buscarContacto();
                    System.out.println("-------");
                    break;
                case 6:
                    System.out.println("-------");
                    break;
                default:
                    System.out.println("No valido");
                    System.out.println("---");
                    break;
            }
        }
        /*
        Ejemplo contactos:
        Daniela, 687043968
        Anon, 666666666
        Oscar, 673702903
         */
    }
}
