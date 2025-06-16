package co.edu.udec.poo.vistas.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class VentanaPrincipal extends JFrame {

    private JMenuBar barraDeMenu;
    private JMenu menuUsuarios;
    private JMenuItem itemAgregarUsuario, itemBuscarUsuario, itemEditarUsuario,
            itemEliminarUsuario, itemLoginUsuario, itemRecordarClaveUsuario,
            itemCambiarClaveUsuario, itemSalirUsuario;

    private HashMap<String, String> usuariosRegistrados = new HashMap<>();

    public VentanaPrincipal() {
        setTitle("Ventana Principal");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraDeMenu = new JMenuBar();
        menuUsuarios = new JMenu("Usuarios");

        // Crear ítems
        itemAgregarUsuario = new JMenuItem("Agregar...");
        itemBuscarUsuario = new JMenuItem("Buscar...");
        itemEditarUsuario = new JMenuItem("Modificar...");
        itemEliminarUsuario = new JMenuItem("Eliminar...");
        itemLoginUsuario = new JMenuItem("Iniciar sesión...");
        itemRecordarClaveUsuario = new JMenuItem("Recordar password...");
        itemCambiarClaveUsuario = new JMenuItem("Cambiar clave...");
        itemSalirUsuario = new JMenuItem("Salir");

        // Acciones de ítems
        itemAgregarUsuario.addActionListener(e -> new RegistroUsuarioGUI()); // Abre registro
        itemLoginUsuario.addActionListener(e -> new LoginUsuarioGUI(usuariosRegistrados)); // Abre login
        itemBuscarUsuario.addActionListener(e -> new VentanaGestionUsuario(this, usuariosRegistrados));
        itemEliminarUsuario.addActionListener(e -> new VentanaGestionUsuario(this, usuariosRegistrados));
        itemSalirUsuario.addActionListener(e -> System.exit(0)); // Salir de la aplicación

        // Armar menú
        menuUsuarios.add(itemAgregarUsuario);
        menuUsuarios.add(itemBuscarUsuario);
        menuUsuarios.add(itemEditarUsuario);
        menuUsuarios.add(itemEliminarUsuario);
        menuUsuarios.addSeparator();
        menuUsuarios.add(itemLoginUsuario);
        menuUsuarios.add(itemRecordarClaveUsuario);
        menuUsuarios.add(itemCambiarClaveUsuario);
        menuUsuarios.add(itemSalirUsuario);

        barraDeMenu.add(menuUsuarios);
        setJMenuBar(barraDeMenu);



        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}