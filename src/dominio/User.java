package dominio;

import co.edu.udec.poo.modelo.crud.UserCrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class User {
    protected String email;
    protected String passwordHash;
    protected String nombreUser;
    protected String numeroCelular;
    protected int edad;
    protected ArrayList<LocalDate> ultimoInicioSesion;
    ArrayList<Grupo> gruposCreados= new ArrayList<>();
    Scanner teclado = new Scanner(System.in);
    static Map<String, String> usuariosRegistrados = new HashMap<>();
    //CONSTRUCTOR

    public User() {
    }
    public User(String email) {
        this.email = email;
    }


    //SETTERS Y GETTERS

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Grupo> getGruposCreados() {
        return gruposCreados;
    }

    public void setGruposCreados(ArrayList<Grupo> gruposCreados) {
        this.gruposCreados = gruposCreados;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public static Map<String, String> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static void setUsuariosRegistrados(Map<String, String> usuariosRegistrados) {
        User.usuariosRegistrados = usuariosRegistrados;
    }

    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------

    public void SolicitarEmail() {
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
                System.out.println("El numero de celular no es valido, vuelva a intentarlo");
            }
        }
    }

    public int SolicitarEdad() {
        System.out.println("Ingrese su edad: ");
        edad = teclado.nextInt();
        teclado.nextLine();
        if (edad < 0) {
            System.out.println("La edad no puede ser negativa");
        }return (edad);
    }

    public void SolicitarPassword() {
        String password;
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
    protected String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            System.out.println("Error al hashear la contraseña: " + e.getMessage());
        }

        return null;
    }

    public void RegistrarUser() {
        SolicitarEmail();
        SolicitarNombreUser();
        SolicitarNumeroCelular();
        SolicitarEdad();
        SolicitarPassword();
        usuariosRegistrados.put(email, passwordHash);

    }

    public void IniciarSesion() {
        String emailIngresado;
        String passwordIngresada;
        String passwordIngresadaHash = null;
        int intentos = 0;
        int maxIntentos = 3;

        while (true) {
            System.out.print("Ingrese su email: ");
            emailIngresado = teclado.nextLine();
            if (!usuariosRegistrados.containsKey(emailIngresado)) {
                System.out.println("Email no se encuentra registrado, vuelva a intentarlo");
            }else{
                break;
            }
        }
            while (intentos < maxIntentos) {
                System.out.print("Ingrese su contraseña: ");
                passwordIngresada = teclado.nextLine();
                passwordIngresadaHash = hashPassword(passwordIngresada);
                String hashRegistrado = usuariosRegistrados.get(emailIngresado);
                if (hashRegistrado.equals(passwordIngresadaHash)) {
                    System.out.println("Inicio de sesión exitoso");
                    return;
                } else {
                    intentos++;
                    if (intentos < maxIntentos) {
                        System.out.println("Contraseña incorrecta, intente nuevamente. Intento " + intentos + " de " + maxIntentos);

                    }
                }
            }
            System.out.println("Demasiados intentos fallidos. Intente más tarde.");
        }

        public void crearPerfilUser(){
            System.out.println("¿Desea crear un perfil o saltar este paso?\n " +
                    "presione 1 para crear, presione 2 para saltar.");
            String aceptarRechazar = teclado.nextLine();
            if (aceptarRechazar.equals("1")) {
                PerfilUser perfil = new PerfilUser();
                perfil.crearPerfil();
            } else if (aceptarRechazar.equals("2")) {
                System.out.println("Se ha saltado la creación del perfil.");
            }
        }
    public void crearGrupo() {
        Grupo grupo = new Grupo();
        grupo.crearGrupo();
    }
    public void mostrarGruposCreadosUser() {
        if (gruposCreados == null) {
            System.out.println("No hay grupos creados para este usuario.");
            return;
        }
        ManejoUser manejoUser = new ManejoUser();
        manejoUser.consultarCantidadGruposUsuario(gruposCreados);
    }

}






