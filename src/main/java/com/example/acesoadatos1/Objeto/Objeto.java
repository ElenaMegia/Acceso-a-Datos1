package com.example.acesoadatos1.Objeto;

public class Objeto {
    private int numero;
    private String id;
    private String imagen;
    private double numerodecimal;
    private char letra;


    public Objeto() {
    }

    public Objeto(int numero, String id, String imagen, double numerodecimal, char letra) {
        this.numero = numero;
        this.id = id;
        this.imagen = imagen;
        this.numerodecimal = numerodecimal;
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getNumerodecimal() {
        return numerodecimal;
    }

    public void setNumerodecimal(double numerodecimal) {
        this.numerodecimal = numerodecimal;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }


    @Override
    public String toString() {
        return "Objeto{" +
                "numero=" + numero +
                ", ID='" + id + '\'' +
                ", imagen='" + imagen + '\'' +
                ", numerodecimal=" + numerodecimal +
                ", letra=" + letra +
                '}';
    }
}
