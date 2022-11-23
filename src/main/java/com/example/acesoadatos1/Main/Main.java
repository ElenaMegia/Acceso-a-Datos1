package com.example.acesoadatos1.Main;

import com.example.acesoadatos1.Objeto.Persona;
import com.example.acesoadatos1.OutofRangeException;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    final  Scanner keyboard = new Scanner(System.in);
    private  String Filename;
    public  void main(String[] args) {

    }

    public void menu(Variables variable, int option) throws IOException {
        switch (option) {
            case 1:
                deleteFile(Filename);
                Persona ob1= introducirObjeto();
                variable.AddObjetos(ob1);
                generateFile(variable, Filename);
                switchOptions(variable); //Vuelta al menu
                break;
            case 2:
                deleteFile(Filename);
                Persona ob2= introducirObjeto();
                System.out.println("Introduce la posicion del objeto que quiere modificar");
                int posicion= keyboard.nextInt();
                variable.ModificcarObjetos(ob2, posicion);
                generateFile(variable, Filename);
                switchOptions(variable); //Vuelta al menu
                break;
            case 3:
                deleteFile(Filename);
                System.out.println("Introduce la posicion del objeto que quiere eliminar");
                int posi= keyboard.nextInt();
                variable.EliminarObjeto(posi);
                generateFile(variable, Filename);
                switchOptions(variable);//Vuelta al menu
                break;
            case 4:

                switchOptions(variable);//Vuelta al menu
                break;
            case 5:
                System.out.println("Introduce la Id del objeto que desea buscar");
                String id= keyboard.nextLine();
                variable.PersonaIgual(id);
                switchOptions(variable);//Vuelta al menu
                break;
            case 6:

                switchOptions(variable);//Vuelta al menu
                break;
            case 0:
                exit(); //Salida del programa
                break;
        }
    }


    private Persona introducirObjeto() {
        return null;
    }

    public  void switchOptions(Variables variable) throws InputMismatchException { //Metodo para imprimir menu e introducir la opción deseada
        boolean repeat = false;
        do {

            try {

                repeat = false;
                System.out.println("Bienvenido");
                System.out.println("\nMenu:\n"
                        + "1º Añadir un nuevo objeto.\n"
                        + "2º Modificar objeto.\n"
                        + "3º Eliminar objeto.\n"
                        + "4º Guardar datos en otra ruta.\n"
                        + "5º Busqueda de objeto por ID.\n"
                        + "6º Guardar datos en ruta alternativa.\n"
                        + "7º Cambiar ruta de guardado de datos.\n"
                        + "0º Salir\n"
                        + "Porfavor escriba la opción deseada: ");

                int choice = keyboard.nextInt();
                if (choice < 0 || choice > 7)
                    throw new OutofRangeException("Error. Tienes que introducir un número entre 0 y 3"); //Excepcion introducida para comprobar que los valores esten entre 0 y 5
                menu(variable, choice);
            } catch (OutofRangeException exc2) {
                System.out.println(exc2.getMessage());
                repeat = true;
            } catch (InputMismatchException exc3) {
                keyboard.nextLine();
                System.out.println("Error. Tienes que introducir un número."); //Excepcion introducida para comprobar que el valor introducido sea un numero, si no se volvera a pedir un valor
                repeat = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (repeat);
    }


    public  void leerObjetos(Variables variable, String route) throws FileNotFoundException {
        File f = new File(route);
        Scanner nombre_f = new Scanner(f);

        while (nombre_f.hasNext()) {
            int numero = nombre_f.nextInt();
            String frase = nombre_f.next();
            String imagen = nombre_f.next();
            double numerodecimal = nombre_f.nextDouble();
            char letra = nombre_f.next().charAt(0);
            Persona objetos = new Persona(numero, frase, imagen, numerodecimal, letra);
            variable.AddObjetos(objetos);
        }//end of while
        nombre_f.close();
    }//end method

    public  void generateFile(Variables variables, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName), true));

            for (int i = 0; i < variables.getNumPersona(); i++) {
                Persona persona1 = variables.getListaPersona().get(i);
                writer.write(persona1.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void newObjeto(Persona ob){

    }

    public  void modificarObjeto(Persona ob){

    }

    public  void eliminarObjeto(Persona ob){

    }


    public  void exit() { //Metodo para salir del programa
        System.out.println("Gracias por usar nuestro programa. ¡Hasta pronto!");
    }
    public  void deleteFile(String FileName) throws IOException{
        new FileWriter(FileName, false).close();
    }
}