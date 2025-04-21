package dominio;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class UserModerador extends User {
    ArrayList<UserModerador> listaModeradores = new ArrayList<>();


    //metodos y funciones

    public void mostrarNombre() {
        System.out.println("Los moderadores son:" + getNombreUser());
    }

    public void ConvertirseModerador() {
        String aceptarRechazar;
        String password="";

        System.out.println("¿Desea convertirse en moderador? Si su respuesta es sí,\n " +
                "presione 1 si es no presione 2");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese sus datos de usuario:");
            System.out.println("Ingrese su email:");
            String emailIngresado = teclado.nextLine();
            System.out.println("Ingrese su contraseña:");
            String passwordIngresada = teclado.nextLine();
            String passwordIngresadaHash = hashPassword(passwordIngresada);
            if(usuariosRegistrados.containsKey(emailIngresado)) {
                String hashRegistrado = usuariosRegistrados.get(emailIngresado);
                if(hashRegistrado.equals(passwordIngresadaHash)) {
                    System.out.println("Ahora eres moderador.");
                    UserModerador userModerador = new UserModerador();
                    userModerador.setEmail(getEmail());
                    userModerador.setNombreUser(getNombreUser());
                    userModerador.setEdad(getEdad());
                    userModerador.setNumeroCelular(getNumeroCelular());
                    listaModeradores.add(userModerador);
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            }
        }
        if (aceptarRechazar.equals("2")) {
            System.out.println("Proceso terminado. No se creo moderador.");
        }
    }

    public void IniciarSesion() {
        String password="";
        String aceptarRechazar = "";
        String passwordIngresadaHash=null;
        String emailIngresado = "";
        String passwordIngresada = "";
        System.out.println("Desea iniciar sesión como moderador?); \n" +
                "si es asi presione 1, si no presione 2");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese su email: ");
            emailIngresado = teclado.nextLine();
            System.out.println("Ingrese su contraseña: ");
            passwordIngresada = teclado.nextLine();
        }if (usuariosRegistrados.containsKey(emailIngresado)) {
            emailIngresado.equals(email);
        }if (usuariosRegistrados.containsValue(passwordIngresada)) {
            passwordIngresada.equals(password);
            System.out.println("Se inicio sesión como moderador");
        }
        if (aceptarRechazar.equals("2")) {
            System.out.println("Iniciar sesion como usuario normal");
            super.IniciarSesion();
        }

    }
}
