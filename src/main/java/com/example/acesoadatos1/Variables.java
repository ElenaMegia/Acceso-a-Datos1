package com.example.acesoadatos1;

import java.util.Arrays;

public class Variables {
    private Objeto[] objeto;
    private int NumObjeto;

    public Variables(Objeto[] objeto, int numObjeto) {
        objeto = new Objeto[100];
        NumObjeto = numObjeto;
    }

    public Objeto[] getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto[] objeto) {
        this.objeto = objeto;
    }

    public int getNumObjeto() {
        return NumObjeto;
    }

    public void setNumObjeto(int numObjeto) {
        NumObjeto = numObjeto;
    }

    public void AddObjetos( Objeto ob) {
        if(NumObjeto < objeto.length) {
            objeto[NumObjeto]=ob;
            NumObjeto++;
        }
    }

    @Override
    public String toString() {
        return "Variables{" +
                "objeto=" + Arrays.toString(objeto) +
                ", NumObjeto=" + NumObjeto +
                '}';
    }
}
