package com.example.acesoadatos1.util;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.ParseException;


public class Util {


    private static final String PATRON_EDAD = "##";
    private static final String PATRON_ALTURA = "##,##";



    public static String formatAltura(double altura) {
        DecimalFormat df = new DecimalFormat(PATRON_ALTURA);
        return df.format(altura);
    }
    public static String formatEdad(int edad) {
        DecimalFormat df = new DecimalFormat(PATRON_EDAD);
        return df.format(edad);
    }

    public static float parseEdad(String edad) throws ParseException {
        DecimalFormat df = new DecimalFormat(PATRON_EDAD);
        return df.parse(edad).intValue();

    }
    public static double parseAltura(String altura)throws ParseException {
        DecimalFormat df = new DecimalFormat(PATRON_ALTURA);
        return df.parse(altura).doubleValue();

    }

    public static void mensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje,
                titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje,
                titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int mensajeConfirmacion(String mensaje, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensaje,
                titulo, JOptionPane.YES_NO_OPTION);
    }


}