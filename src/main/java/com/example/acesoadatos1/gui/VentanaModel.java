package com.example.acesoadatos1.gui;


import com.example.acesoadatos1.Objeto.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class VentanaModel {

    private HashMap<String, Persona> personas;
    private final String RUTA_FICHERO =
            System.getProperty("user.home") + File.separator + "persona.dat";

    public VentanaModel() throws FileNotFoundException, ClassNotFoundException,
            IOException {

        File fichero = new File(RUTA_FICHERO);
        if (fichero.exists()) {
            cargarDeFichero();
        }
        else {
            personas = new HashMap<>();
        }
    }

    public void addPersona(Persona persona) {

        personas.put(persona.getNombre(), persona);
    }

    public void modificarPersona(Persona nuevaPersona, String nombre) {

        Persona persona = personas.get(nombre);
        persona.setNombre(nuevaPersona.getNombre());
        persona.setID(nuevaPersona.getID());
        persona.setEdad(nuevaPersona.getEdad());
        persona.setAltura(nuevaPersona.getAltura());
        persona.setSexo(nuevaPersona.getSexo());
    }

    public void eliminarPersona(String Nombre) {
        personas.remove(Nombre);
    }


    public Persona obtenerCoche(String Nombre) {
        return null;
    }

    public ArrayList<Persona> obtenerPersonas(String busqueda) {
        ArrayList<Persona> personasEncontradas = new ArrayList<>();

        for (Persona persona : obtenerPersonas()) {
            if ((persona.getNombre().contains(busqueda))
                    || (persona.getID().contains(busqueda))) {
                personasEncontradas.add(persona);
            }
        }
        return personasEncontradas;
    }

    public Collection<Persona> obtenerPersonas() {

        return personas.values();
    }

    public void guardarAFichero() throws IOException {

        ObjectOutputStream serializador = null;

        serializador = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO));
        serializador.writeObject(personas);
        if (serializador != null)
            serializador.close();
    }

    public void cargarDeFichero() throws FileNotFoundException,
            ClassNotFoundException, IOException {

        ObjectInputStream deserializador = null;

        deserializador = new ObjectInputStream(new FileInputStream(RUTA_FICHERO));
        personas = (HashMap<String, Persona>) deserializador.readObject();
        if (deserializador == null)
            deserializador.close();
    }
}
