import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Lugares {

    public static void main(String[] args){
        LinkedList<String> lugares = new LinkedList<String>();

        lugares.add("Roma");
        lugares.add("París");
        lugares.add("Amsterdam");
        lugares.add("Toronto");
        lugares.add("Miami");
        String primero = lugares.getFirst();
        String ultimo = lugares.getLast();

        printList(lugares);
        visitarLugar(lugares);
    }


    public static void printList(LinkedList<String> lugares) {
        Iterator<String> it = lugares.iterator();
        while (it.hasNext()) {
            System.out.println("Nodo: " + it.next());
        }
        System.out.println("-----");
    }

    private static boolean addInOrder(LinkedList<String> lugares, String newItem) {
        ListIterator<String> it = lugares.listIterator();
        while (it.hasNext()) {
            int comparacion = it.next().compareTo(newItem);

            if (comparacion == 0) {
                //no queremos añadir porque no queremos tener duplicados
                System.out.println("el lugar " + newItem + " ya está incluido");
                return false;
            } else if (comparacion > 0) { //newItem es más pequeño
                it.previous();
                it.add(newItem);
                return true;
            }
        }
        it.add(newItem);
        return true;
    }

    public static void visitarLugar(LinkedList<String> lugares) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        ListIterator<String> it = lugares.listIterator();

        if (lugares.isEmpty()) {
            System.out.println("No hay lugares visitados");
            return;
        } else {
            System.out.println("Visitando " + it.next());
            imprimirMenu();
        }

        boolean haciaAdelante = true;
        while(continuar) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Se acabaron las vacaciones");
                    continuar = false;
                    break;
                case 1:
                    if (!haciaAdelante) {
                        if (it.hasNext())
                            it.next();
                        haciaAdelante = true;
                    }
                    if (it.hasNext()) {
                        System.out.println("Visitando " + it.next());
                    } else {
                        System.out.println("Ya no hay más ciudades");
                        haciaAdelante = false;
                    }
                    break;
                case 2:
                    if(haciaAdelante) {
                        if (it.hasPrevious())
                            it.previous();
                        haciaAdelante = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("Visitando " + it.previous());
                    } else {
                        System.out.println("Primera ciudad");
                        haciaAdelante = true;
                    }
                    break;
                case 3:
                    imprimirMenu();
                    break;
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("0 - Para salir\n" +
                "1 - para ir a la siguiente ciudad\n" +
                "2 - para ir a la ciudad anterior\n" +
                "3 - imprimir el menú");
    }









}
