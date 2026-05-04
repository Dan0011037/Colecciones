package Practica2_biblioteca;

import java.util.Objects;

public class Socio {
    private String dni;
    private String nome;
    private String email;

    public Socio(String dni, String nome, String email) {
        this.dni = dni;
        this.nome = nome;
        this.email = email;
    }

    public String getDni() {return dni;
    }
    public void setDni(String dni) {this.dni = dni;
    }
    public String getNome() {return nome;
    }
    public void setNome(String nome) {this.nome = nome;
    }
    public String getEmail() {return email;
    }
    public void setEmail(String email) {this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(dni, socio.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
