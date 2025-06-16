package co.edu.udec.poo.vistas.gui;

import javax.swing.*;
import java.awt.*;
import java.security.MessageDigest;
import java.util.HashMap;

public class LoginUsuarioGUI extends JFrame {
    private JTextField emailLoginField;
    private JPasswordField passwordLoginField;
    private JButton loginButton;
    private HashMap<String, String> usuariosRegistrados;
    private int intentos = 0;
    private final int maxIntentos = 3;

    public LoginUsuarioGUI(HashMap<String, String> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;

        setTitle("Inicio de Sesión");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailLoginField = new JTextField();
        add(emailLoginField);

        add(new JLabel("Contraseña:"));
        passwordLoginField = new JPasswordField();
        add(passwordLoginField);

        loginButton = new JButton("Iniciar Sesión");
        add(new JLabel());
        add(loginButton);

        loginButton.addActionListener(e -> iniciarSesion());

        setVisible(true);
    }

    private void iniciarSesion() {
        String email = emailLoginField.getText();
        String password = new String(passwordLoginField.getPassword());

        if (!usuariosRegistrados.containsKey(email)) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            return;
        }

        String hashed = hashPassword(password);
        String original = usuariosRegistrados.get(email);

        if (hashed.equals(original)) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!");
            dispose();
            new VentanaPrincipal();
        } else {
            intentos++;
            if (intentos < maxIntentos) {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Intento " + intentos);
            } else {
                JOptionPane.showMessageDialog(this, "Demasiados intentos fallidos.");
                loginButton.setEnabled(false);
            }
        }
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