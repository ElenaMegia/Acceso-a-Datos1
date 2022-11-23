package com.example.acesoadatos1.gui;
import com.example.acesoadatos1.Objeto.Persona;


import com.example.acesoadatos1.util.Util;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public class VentanaController implements ActionListener, KeyListener, ListSelectionListener {

    private boolean enabled;
    private String text;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private enum Accion {
        NUEVO, MODIFICAR;
    }

    private Ventana view;
    private VentanaModel model;
    private Accion accion;

    public VentanaController(Ventana view, VentanaModel model) {
        this.view = view;
        this.model = model;
        addActionListeners();
        addSelectionListeners();
        addKeyListener(this);
        refrescarLista();
    }

    private void addActionListeners() {

        view.btNuevo.addActionListener(this);
        view.btCancelar.addActionListener(this);
        view.btEliminar.addActionListener(this);
        view.btGuardar.addActionListener(this);
        view.btModificar.addActionListener(this);
    }

    private void addSelectionListeners() {
        view.lPersonas.addListSelectionListener(this);
    }

    private void addKeyListener(VentanaController ventanaController) {

        view.tfBusqueda.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String option = actionEvent.getActionCommand();

        switch (option) {
            case "Nuevo":
                accion = Accion.NUEVO;
                modoEdicion(true);
                limpiarGUI();
                view.lbEstado.setText("Nuevo");
                break;

            case "Modificar":
                accion = Accion.MODIFICAR;
                modoEdicion(true);
                view.lbEstado.setText("Modificar");
                break;

            case "Guardar":
                if (view.tfNombre.getText().equals("")) {
                  Util.mensajeError("El nombre es obligatorio");
                    return;
                }

                if (view.tfedad.getText().equals(""))
                    view.tfedad.setText("0");

                if (view.tfaltura.getText().equals(""))
                    view.tfaltura.setText("0");

                Persona nuevaPersona = new Persona();
                try {
                    nuevaPersona.setNombre(view.tfNombre.getText());
                    nuevaPersona.setID(view.tfID.getText());
                    nuevaPersona.setEdad((int) Util.parseEdad(view.tfedad.getText()));
                    nuevaPersona.setAltura(Util.parseAltura(view.tfaltura.getText()));
                    nuevaPersona.setSexo(view.cbsexo.getText().charAt(0));
                } catch (ParseException pe) {
                    Util.mensajeError("Formato no válido");
                    return;
                }

                switch (accion) {
                    case NUEVO:
                        model.addPersona(nuevaPersona);
                        break;
                    case MODIFICAR:
                        String matricula = view.lPersonas.getSelectedValue().toString();
                        model.modificarPersona(nuevaPersona, matricula);
                        break;
                    default:
                }
                try {
                    model.guardarAFichero();
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null,
                            "Error al escribir", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                refrescarLista();
                view.lbEstado.setText("Guardado");
                modoEdicion(false);
                break;
            case "Cancelar":
                modoEdicion(false);
                view.lbEstado.setText("Cancelado");
                break;
            case "Eliminar":
                // 1. Preguntar al usuario
                if (JOptionPane.showConfirmDialog(null,
                        "¿Está seguro?", "Eliminar", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.NO_OPTION)
                    return;

                // 2. Eliminar
                Persona p1 = (Persona) view.lPersonas.getSelectedValue();
                model.eliminarPersona(p1.getNombre());

                // 3. Refrescar
                refrescarLista();

                // 4. Guardar cambios en disco
                try {
                    model.guardarAFichero();
                } catch (IOException ioe) {
                    Util.mensajeError("Error al escribir");
                }
                break;
            default:
        }
    }

    /*
    Limpia las cajas de texto de la GUI
     */
    private void limpiarGUI() {

        view.tfNombre.setText("");
        view.tfID.setText("");
        view.tfedad.setText("");
        view.tfaltura.setText("");
        view.cbsexo.setText("");
    }

    private void modoEdicion(boolean edicion) {

        view.btNuevo.setEnabled(!edicion);
        view.btGuardar.setEnabled(edicion);
        view.btEliminar.setEnabled(!edicion);
        view.btModificar.setEnabled(!edicion);
        view.btCancelar.setEnabled(edicion);

        view.tfNombre.setEditable(edicion);
        view.tfID.setEditable(edicion);
        view.tfedad.setEditable(edicion);
        view.tfaltura.setEditable(edicion);

        view.tfBusqueda.setEnabled(!edicion);
        view.lPersonas.setEnabled(!edicion);
    }




    private void refrescarLista() {

        view.dlmPersonas.clear();
        for (Persona persona : model.obtenerPersonas()) {
            view.dlmPersonas.addElement(persona);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

        ArrayList<Persona> personas;
        String cadenaBusqueda = view.tfBusqueda.getText();

        if (cadenaBusqueda.length() < 3) {
            personas = new ArrayList<>(model.obtenerPersonas());
        }
        else {
            personas = model.obtenerPersonas(cadenaBusqueda);
        }

        view.dlmPersonas.clear();
        for (Persona persona : personas)
            view.dlmPersonas.addElement(persona);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        Persona persona = (Persona) view.lPersonas.getSelectedValue();
        if (persona == null)
            return;
        view.tfNombre.setText(persona.getNombre());
        view.tfID.setText(persona.getID());
        view.tfedad.setText(Util.formatEdad(persona.getEdad()));
        view.tfaltura.setText(Util.formatAltura(persona.getAltura()));
        view.cbsexo.setText(String.valueOf(persona.getSexo()));
        modoEdicion(false);
    }
}