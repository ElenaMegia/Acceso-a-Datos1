package com.example.acesoadatos1;

import com.example.acesoadatos1.Objeto.Objeto;

import java.util.ArrayList;
import java.util.Arrays;

public class Variables {
    private ArrayList<Objeto> listaObjeto;
    private int NumObjeto;

    public Variables(ArrayList<Objeto> listaObjeto, int numObjeto) {
        this.listaObjeto = listaObjeto;
        NumObjeto = numObjeto;
    }

    public ArrayList<Objeto> getListaObjeto() {
        return listaObjeto;
    }

    public void setListaObjeto(ArrayList<Objeto> listaObjeto) {
        this.listaObjeto = listaObjeto;
    }

    public int getNumObjeto() {
        return NumObjeto;
    }

    public void setNumObjeto(int numObjeto) {
        NumObjeto = numObjeto;
    }

    public void AddObjetos( Objeto ob) {
            listaObjeto.add(ob);
            NumObjeto++;
    }


    public  void  ModificcarObjetos(Objeto ob, int posi){
        Objeto objeto=listaObjeto.get(posi);
        objeto.setFrase(ob.getFrase());
        objeto.setLetra(ob.getLetra());
        objeto.setImagen(ob.getImagen());
        objeto.setNumero(ob.getNumero());
        objeto.setNumerodecimal(ob.getNumerodecimal());
    }

    public void EliminarObjeto( int posi){
        listaObjeto.remove(posi);
    }

    public boolean BuscarObjeto(Objeto ob1, String frase){
        boolean encontrado=false;
        for(int i=0; i<listaObjeto.size(); i++){
            if(ob1.getFrase().equals(frase)) {
                    encontrado=true;
            }
        }
        return encontrado;
    }
    @Override
    public String toString() {
        return "Variables{" +
                "listaObjeto=" + listaObjeto +
                ", NumObjeto=" + NumObjeto +
                '}';
    }
}
