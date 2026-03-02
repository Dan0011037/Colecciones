package repaso;

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

    /*
    -ArrayList
• Necesitas acceso por índice
• Recorres mucho
• Añades al final
NO CUANDO SE INSERTA POR EN MEDIO
List<String> lista = new ArrayList<>();

    -LinkedList
Lista enlazada; inserciones y eliminaciones rápidas en medio, acceso por índice más lento.
• Mucha inserción/eliminación intermedia
List<String> lista = new LinkedList<>();

    -Set
Colección que no permite elementos duplicados.
• equals() ,compara contenido
@Override
    public boolean equals(Object o) {
                // 1. ¿Son la misma instancia de memoria?
        if (this == o) return true;
                // 2. ¿Es nulo o de otra clase?
        if (o == null || getClass() != o.getClass()) return false;
                // 3. Comparar el atributo clave (DNI)
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

• hashCode() ,permite búsquedas rápidas en colecciones, devolviendo el nuemro que representa al objeto
@Override
    public int hashCode() {
        // Genera el hash basado solo en el DNI
        return Objects.hash(dni);
    }
(Si dos objetos son iguales por equals(), DEBEN tener el mismo hashCode().
Si se sobrescribe uno se debe sobrescribir el otro tambien)

    -HashSet
Set basado en hash; rápido, no mantiene orden.
• Solo importa que no haya duplicados
• No importa el orden
Set<String> set = new HashSet<>();

    -TreeSet
Set ordenado automáticamente según orden natural o Comparator.
public class Estudiante implements Comparable<Estudiante> {
    private int edad;

    @Override
    public int compareTo(Estudiante otro) {
        // Orden ascendente por edad
        return this.edad - otro.edad;
        // Truco: Si restas, si this.edad es mayor, da positivo (va después).
    }
}

    -Map
Estructura clave-valor; no permite claves duplicadas.
Map<String, Integer> mapa = new HashMap<>();

    -HashMap
Map rápido basado en hash; no mantiene orden.

    -TreeMap
Map ordenado por clave automáticamente.

    -----
    Si usas:
• HashSet
• HashMap
• LinkedHashSet
• LinkedHashMap
Entonces equals y hashCode son obligatorios.
    -----
     */

    /*
        --¿Cuándo usar List?--
Una List es:
 Colección ordenada
 Permite duplicados
 Acceso por índice

Ejemplo mental:
“Quiero una lista de tareas en orden”.
List<String> tareas = new ArrayList<>();

    -ArrayList-
• Rápido para acceder por índice
• Malo para insertar en medio

    -LinkedList-
• Bueno para insertar/eliminar al principio o medio
• Peor acceso por índice


        --¿Cuándo usar LinkedList?--
Casi nunca.
Solo si:
• Vas a insertar/eliminar mucho en medio
• No necesitas acceso frecuente por índice
En el 90% de casos → usa ArrayList.

LinkedList está sobrevalorada en teoría y poco usada en la vida real.


        --¿Cuándo usar Set?--
Un Set es:
 No permite duplicados
 No tiene índice
 La igualdad la define equals() + hashCode()

Ejemplo:
“Quiero un conjunto único de usuarios”.
Set<String> usuarios = new HashSet<>();

    HashSet
• No mantiene orden
• Muy rápido

    LinkedHashSet
• Mantiene orden de inserción

    TreeSet
• Ordena automáticamente

 Usa Set cuando:
• No quieres duplicados
• Te importa la unicidad


        --¿Cuándo usar Map?--
Un Map es:
 Clave → Valor
 No hay claves duplicadas

Ejemplo:
“Quiero buscar un planeta por su nombre”.
Map<String, Planeta> sistemaSolar = new HashMap<>();

    --HashMap--
• Muy rápido
• Sin orden

    --LinkedHashMap--
• Mantiene orden de inserción

    --TreeMap--
• Ordena por clave

 Usa Map cuando:
• Necesitas búsqueda rápida por clave
• Tienes relación clave → objeto
     */


    /*
        --Herencia--
Una clase hereda atributos y métodos de otra (relación “es un”).
// CLASE PADRE
public class Animal {
    protected String nombre; // protected para que los hijos lo vean
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }
    public void hacerSonido() {
        System.out.println("Sonido genérico...");
    }
}

// CLASE HIJA
public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre); // Llama al constructor de Animal
    }
    @Override // Sobrescritura: Cambiamos el comportamiento del padre
    public void hacerSonido() {
        System.out.println("¡Guau! Me llamo " + nombre);
    }
}


        --Polimorfismo--
Permite tratar objetos hijos como si fueran del tipo padre, ejecutando el metodo correspondiente al objeto real.
public class TestPolimorfismo {
    public static void main(String[] args) {
                // Un Animal que resulta ser un Perro
        Animal miMascota = new Perro("Bobby");
                // Ejecuta el metodo del Perro, no el del Animal (Enlace dinámico)
        miMascota.hacerSonido(); // Salida: ¡Guau! Me llamo Bobby
                // Puedes tener una lista de Animales con distintos tipos dentro
        List<Animal> refugio = new ArrayList<>();
        refugio.add(new Perro("Rex"));
        refugio.add(new Gato("Michi")); // Suponiendo que Gato existe

        for (Animal a : refugio) {
            a.hacerSonido(); // Cada uno responde a su manera
        }
    }
}


        --Clase abstracta--
Clase que no se puede instanciar y puede contener métodos sin implementar.
Cuándo usarla: Cuando quieres que todos los hijos compartan código (atributos/métodos normales)
 pero también tengan comportamientos obligatorios distintos.


        --Interface--
Contrato que obliga a implementar ciertos métodos sin definir cómo funcionan.
public interface Volador {
    void despegar(); // Por defecto son public y abstract
}
public class Avion extends Vehiculo implements Volador {
    @Override
    public void despegar() {
        System.out.println("Avión en pista...");
    }
}


        --Encapsulación--
Proteger los atributos usando private y acceder mediante métodos públicos.
public class CuentaBancaria {
    private double saldo; // Nadie puede tocarlo directamente
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }
    public double getSaldo() {
        return this.saldo;
    }
}


    --Composición--
Una clase contiene objetos de otra (relación “tiene un”).
public class Coche {
    private Motor motor; // Composición
    public Coche() {
        this.motor = new Motor();
    }
}


     */

}
