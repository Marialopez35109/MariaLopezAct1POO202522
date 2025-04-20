package dominio;

import java.util.ArrayList;
import java.util.Scanner;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class User {
    protected  String email;
    protected  String password;
    protected  String passwordHash;
    protected String nombreUser;
    protected String numeroCelular;
    protected int edad;
    ArrayList<Grupo> gruposCreados;
    Scanner teclado = new Scanner(System.in);
    Map<String, String> usuariosRegistrados = new HashMap<>();

    //Constructor vacio

    public User() {}


    //Setter y Getter

    public String getEmail() {
        return email;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    //metodos y funciones
    public  void SolicitarEmail() {
        while (true) {
            System.out.println("Ingrese un email:");
            email = teclado.nextLine();
            if (ValidarEmail()) {
                break;
            } else {
                System.out.println("El email no es valido, intente nuevamente");
            }
        }

    }
    public boolean ValidarEmail() {
        boolean esValido = false;
        if (email == null || email.isEmpty()) {
            System.out.println("El email no puede estar vacio");
            return false;
        }
        String patronEmail = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        esValido = email.matches(patronEmail);
        if (esValido) {
            System.out.println("El email es valido");
        }
        return esValido;
    }

    public void SolicitarNombreUser() {
        System.out.println("Ingrese un nombre de usuario: ");
        nombreUser = teclado.nextLine();
        if (nombreUser == null || nombreUser.isEmpty()) {
            System.out.println("El nombre de usuario no puede estar vacio");
            return;
        }
    }

    public void SolicitarNumeroCelular() {
        while (true) {
            System.out.println("Ingrese un numero de celular: ");
            numeroCelular = teclado.nextLine();
            if (numeroCelular.length() == 10 && numeroCelular.matches("\\d+")) { //Para validar que el numero de celular tenga 10 digitos y sea numerico
                break;
            } else {
                System.out.println("El numero de celular no es valido, debe tener 10 digitos");
            }
        }
    }

    public int SolicitarEdad(){
        System.out.println("Ingrese su edad: ");
        edad = teclado.nextInt();
        teclado.nextLine();
        if (edad < 0) {
            System.out.println("La edad no puede ser negativa");
        }
        return (edad);
    }

    public void SolicitarPassword() {
        while (true) {
            System.out.println("Ingrese su contraseña: ");
            password = teclado.nextLine();
            passwordHash = hashPassword(password);
            if (!(password == null || password.isEmpty())) {
                System.out.println("Contraseña registrada correctamente");
                break;
            } else {
                System.out.println("La contraseña no puede ser nula estar vacía");
            }
        }
    }
    //Hashear la contraseña
    private String hashPassword(String password) {
        try {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hash= md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b: hash){
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        }catch (Exception e){
        }
        return null;
    }
    public void RegistrarUser() {
        SolicitarEmail();
        SolicitarNombreUser();
        SolicitarNumeroCelular();
        SolicitarEdad();
        SolicitarPassword();
        DataBase(email, passwordHash);
    }
    public void DataBase(String email, String passwordHash) {
    usuariosRegistrados.put(email, passwordHash);
    System.out.println(usuariosRegistrados);
    }
    public void IniciarSesion() {
        String passwordIngresadaHash=null;
        String emailIngresado="";
        String passwordIngresada=null;
        Scanner teclado= new Scanner(System.in);

        System.out.print("Ingrese su email: ");
        emailIngresado = teclado.nextLine();
        System.out.print("Ingrese su contraseña: ");
        passwordIngresada = teclado.nextLine();
        passwordIngresadaHash = hashPassword(passwordIngresada);
        if (usuariosRegistrados.containsKey(emailIngresado)) {
            emailIngresado.equals(email);
        }if (usuariosRegistrados.containsValue(passwordIngresadaHash) ){
            passwordIngresadaHash.equals(passwordHash);
            System.out.println("Inicio de sesión exitoso");
            DataBase(emailIngresado, passwordIngresadaHash);
        }else {
            System.out.println("Email o contraseña incorrectos");
            DataBase(emailIngresado, passwordIngresadaHash);
        }
    }
}





