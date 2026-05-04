package EXAMEN;

import java.util.Objects;

public class Clientes {
    private String dni;
    private String nombre;

    public Clientes(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {return dni;
    }

    public void setDni(String dni) {this.dni = dni;
    }

    public String getNombre() {return nombre;
    }

    public void setNombre(String nombre) {this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(dni, clientes.dni) && Objects.equals(nombre, clientes.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre);
    }
}
