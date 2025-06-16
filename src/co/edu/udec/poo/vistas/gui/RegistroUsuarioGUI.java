package co.edu.udec.poo.vistas.gui;

import javax.swing.*;
import java.awt.*;
import java.security.MessageDigest;
import java.util.HashMap;

public class RegistroUsuarioGUI extends JFrame {

    private JTextField emailField, nombreField, celularField, edadField;
    private JPasswordField passwordField;
    private JButton registrarButton;
    private HashMap<String, String> usuariosRegistrados = new HashMap<>();

    public RegistroUsuarioGUI() {
        setTitle("Registro de Usuario");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Nombre de usuario:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Número celular:"));
        celularField = new JTextField();
        add(celularField);

        add(new JLabel("Edad:"));
        edadField = new JTextField();
        add(edadField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registrarButton = new JButton("Registrar");
        add(new JLabel());
        add(registrarButton);

        registrarButton.addActionListener(e -> registrarUsuario());

        setVisible(true);
    }

    private void registrarUsuario() {
        String email = emailField.getText();
        String nombre = nombreField.getText();
        String celular = celularField.getText();
        String edadText = edadField.getText();
        String password = new String(passwordField.getPassword());

        if (!validarEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email inválido");
            return;
        }
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre vacío");
            return;
        }
        if (!celular.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Celular inválido");
            return;
        }
        int edad;
        try {
            edad = Integer.parseInt(edadText);
            if (edad < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad inválida");
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contraseña vacía");
            return;
        }

        String hash = hashPassword(password);
        usuariosRegistrados.put(email, hash);
        JOptionPane.showMessageDialog(this, "¡Usuario registrado exitosamente!");
        dispose();
        new LoginUsuarioGUI(usuariosRegistrados);
    }

    private boolean validarEmail(String email) {
        return email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : bytes) hex.append(String.format("%02x", b));
            return hex.toString();
        } catch (Exception e) {
            return null;
        }
    }
}