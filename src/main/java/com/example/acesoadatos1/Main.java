package com.example.acesoadatos1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void menu(Variables variable, Objeto ob, int option) {
        switch (option) {
            case 1:

                switchOptions(variable, ob); //Vuelta al menu
                break;
            case 2:

                switchOptions(variable, ob); //Vuelta al menu
                break;
            case 3:

                switchOptions(variable, ob);//Vuelta al menu
                break;
            case 0:
                exit(); //Salida del programa
                break;
        }
    }

    public static void switchOptions(Variables variable, Objeto ob) throws InputMismatchException { //Metodo para imprimir menu e introducir la opción deseada
        boolean repeat = false;
        do {

            try {

                repeat = false;
                System.out.println("Bienvenido");
                System.out.println("\nMenu:\n"
                        + "1º Añadir un nuevo objeto.\n"
                        + "2º Modificar objeto.\n"
                        + "3º Eliminar objeto.\n"
                        + "0º Salir\n"
                        + "Porfavor escriba la opción deseada: ");

                int choice = keyboard.nextInt();
                if (choice < 0 || choice > 3)
                    throw new OutofRangeException("Error. Tienes que introducir un número entre 0 y 3"); //Excepcion introducida para comprobar que los valores esten entre 0 y 5
                menu(variable, ob, choice);
            } catch (OutofRangeException exc2) {
                System.out.println(exc2.getMessage());
                repeat = true;
            } catch (InputMismatchException exc3) {
                keyboard.nextLine();
                System.out.println("Error. Tienes que introducir un número."); //Excepcion introducida para comprobar que el valor introducido sea un numero, si no se volvera a pedir un valor
                repeat = true;
            }
        } while (repeat);
    }


    public static void leerObjetos(Variables variable, String route) throws FileNotFoundException {
        File f = new File(route);
        Scanner nombre_f = new Scanner(f);

        while (nombre_f.hasNext()) {
            int numero = nombre_f.nextInt();
            String frase = nombre_f.next();
            String imagen = nombre_f.next();
            double numerodecimal = nombre_f.nextDouble();
            char letra = nombre_f.next().charAt(0);
            Objeto objetos = new Objeto(numero, frase, imagen, numerodecimal, letra);
            variable.AddObjetos(objetos);
        }//end of while
        nombre_f.close();
    }//end method

    public void generateFile(Variables variables, Objeto objeto, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName), true));

            for (int i = 0; i < variables.getNumObjeto(); i++) {
                Objeto objeto1 = variables.getObjeto()[i];
                writer.write(objeto1.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void exit() { //Metodo para salir del programa
        System.out.println("Gracias por usar nuestro programa. ¡Hasta pronto!");
    }

}