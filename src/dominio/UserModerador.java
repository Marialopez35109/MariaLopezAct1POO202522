package dominio;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class UserModerador extends User {
    ArrayList<UserModerador> listaModeradores = new ArrayList<>();


    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------

    public void mostrarNombre() {
        System.out.println("Los moderadores son:" + getNombreUser());
    }

    public void ConvertirseModerador() {
        String aceptarRechazar;
        String password="";
        String passwordIngresada;
        String emailIngresado;

        System.out.println("¿Desea convertirse en moderador? Si su respuesta es sí,\n " +
                "presione 1 si es no presione 2");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese sus datos de usuario:");
            System.out.println("Ingrese su email:");
            emailIngresado = teclado.nextLine();
            System.out.println("Ingrese su contraseña:");
            passwordIngresada = teclado.nextLine();
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
        String passwordIngresada = "";
        String emailIngresado;

        System.out.println("Desea iniciar sesión como moderador?); \n" +
                "si es asi presione 1, si no presione 2");
        aceptarRechazar = teclado.nextLine();
        while (true) {
            System.out.print("Ingrese su email: ");
            emailIngresado = teclado.nextLine();
            if (!usuariosRegistrados.containsKey(emailIngresado)) {
                System.out.println("Email no se encuentra registrado, vuelva a intentarlo");
            }else{
                break;
            }
        }
        int intentos = 0;
        int maxIntentos = 3;

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
}

