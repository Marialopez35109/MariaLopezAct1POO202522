package co.edu.udec.poo.vistas.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class VentanaGestionUsuario extends JDialog {

    private JTextField campoEmail, campoNombre, campoCelular, campoEdad;
    private JButton btnBuscar, btnEliminar;
    private HashMap<String, String> usuariosRegistrados;

    public VentanaGestionUsuario(JFrame parent, HashMap<String, String> usuariosRegistrados) {
        super(parent, "Buscar / Eliminar Usuario", true);
        this.usuariosRegistrados = usuariosRegistrados;

        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 5, 5));

        campoEmail = new JTextField();
        campoNombre = new JTextField(); campoNombre.setEditable(false);
        campoCelular = new JTextField(); campoCelular.setEditable(false);
        campoEdad = new JTextField(); campoEdad.setEditable(false);

        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false); // Solo se habilita si encuentra el usuario


        add(new JLabel("Nombre:"));
        add(campoNombre);


        add(btnBuscar);
        add(btnEliminar);

        btnBuscar.addActionListener(e -> buscarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());

        setVisible(true);
    }

    private void buscarUsuario() {
        String email = campoEmail.getText().trim();

        if (!usuariosRegistrados.containsKey(email)) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            campoNombre.setText("");
            campoCelular.setText("");
            campoEdad.setText("");
            btnEliminar.setEnabled(false);
            return;
        }

        campoNombre.setText("Usuario encontrado");
        btnEliminar.setEnabled(true);
    }

    private void eliminarUsuario() {
        String email = campoEmail.getText().trim();

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            usuariosRegistrados.remove(email);
            JOptionPane.showMessageDialog(this, "Usuario eliminado");
            campoEmail.setText("");
            campoNombre.setText("");
            campoCelular.setText("");
            campoEdad.setText("");
            btnEliminar.setEnabled(false);
        }
    }
}