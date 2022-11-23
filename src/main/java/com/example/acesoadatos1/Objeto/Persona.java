package com.example.acesoadatos1.Objeto;

public class Persona {
    private int edad;
    private String ID;
    private String Nombre;
    private double altura;
    private char sexo;


    public Persona() {
    }

    public Persona(int edad, String ID, String nombre, double altura, char sexo) {
        this.edad = edad;
        this.ID = ID;
        this.Nombre = nombre;
        this.altura = altura;
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", id='" + ID + '\'' +
                ", nombre='" + Nombre + '\'' +
                ", altura=" + altura +
                ", sexo=" + sexo +
                '}';
    }
}
