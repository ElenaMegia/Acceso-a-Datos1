package com.example.acesoadatos1.Main;

import com.example.acesoadatos1.Objeto.Persona;

import java.util.ArrayList;

public class Variables {
    private ArrayList<Persona> listaPersona;
    private int NumPersona;

    public Variables(ArrayList<Persona> listaPersona, int numPersona) {
        this.listaPersona = listaPersona;
        NumPersona = numPersona;
    }

    public void PersonaIgual(String id) {

        for(int i = 0; i< listaPersona.size(); i++) {
            if (listaPersona.get(i).getID().equals(id)) {
                listaPersona.get(i).toString();
            }
        }
    }

    public ArrayList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(ArrayList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public int getNumPersona() {
        return NumPersona;
    }

    public void setNumPersona(int numObjeto) {
        NumPersona = numObjeto;
    }

    public void AddObjetos( Persona ob) {
            listaPersona.add(ob);
            NumPersona++;
    }


    public  void  ModificcarObjetos(Persona ob, int posi){
        Persona persona = listaPersona.get(posi);
        persona.setID(ob.getID());
        persona.setSexo(ob.getSexo());
        persona.setNombre(ob.getNombre());
        persona.setEdad(ob.getEdad());
        persona.setAltura(ob.getAltura());
    }

    public void EliminarObjeto( int posi){
        listaPersona.remove(posi);
    }

    public boolean BuscarObjeto(Persona ob1, String frase){
        boolean encontrado=false;
        for(int i = 0; i< listaPersona.size(); i++){
            if(ob1.getID().equals(frase)) {
                    encontrado=true;
            }
        }
        return encontrado;
    }
    @Override
    public String toString() {
        return "Variables{" +
                "listaObjeto=" + listaPersona +
                ", NumObjeto=" + NumPersona +
                '}';
    }
}
