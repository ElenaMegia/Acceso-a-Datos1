package com.example.acesoadatos1.gui;


import com.example.acesoadatos1.Objeto.Persona;

import javax.swing.*;
public class Ventana {
    public VentanaController tfBusqueda;
    JPanel panel;
    JLabel lbEstado;
    JTextField tfNombre;
    JTextField tfID;
    JTextField tfedad;
    JTextField tfaltura;

    JList lPersonas;
    JButton btEliminar;
    JButton btNuevo;
    JButton btModificar;
    JButton btGuardar;
    JButton btCancelar;
    JCheckBox cbsexo;
    DefaultListModel<Persona> dlmPersonas;

    public Ventana() {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        dlmPersonas = new DefaultListModel<>();
        lPersonas.setModel(dlmPersonas);

    }
}