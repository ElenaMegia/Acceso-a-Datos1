package com.example.acesoadatos1.lanzador;

import com.example.acesoadatos1.gui.Ventana;
import com.example.acesoadatos1.gui.VentanaController;
import com.example.acesoadatos1.gui.VentanaModel;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lanzador {

    public static void lanzador(String args[]) {

        try {
            Ventana view = new Ventana();
            VentanaModel model = new VentanaModel();
            VentanaController controller =
                    new VentanaController(view, model);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null,
                    "Error al cargar de disco. El fichero no existe", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null,
                    "Error al escribir en disco. El formato no es válido", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,
                    "Error de lectura de disco", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}