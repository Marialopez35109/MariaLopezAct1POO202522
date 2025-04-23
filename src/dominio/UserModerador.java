package dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class UserModerador extends User {
    protected static ArrayList<UserModerador> listaModeradores = new ArrayList<>();


    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------


    public void ConvertirseModerador() {
        String aceptarRechazar;
        String passwordIngresada;
        String emailIngresado="";
        String nombreIngresado="";
        System.out.println("¿Desea convertirse en moderador? Si es así,\n " +
                "presione 1 si no es así presione 2.");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese sus datos de usuario:");
            while (true) {
                System.out.print("Ingrese su email: ");
                emailIngresado = teclado.nextLine();
                if (!usuariosRegistrados.containsKey(emailIngresado)) {
                    System.out.println("Email no se encuentra registrado, vuelva a intentarlo");
                }else{
                    break;
                }
            }
            System.out.print("Ingrese su nombre de usuario: ");
            nombreIngresado = teclado.nextLine();

            System.out.println("Ingrese su contraseña:");
            passwordIngresada = teclado.nextLine();
            String passwordIngresadaHash = hashPassword(passwordIngresada);
            if(usuariosRegistrados.containsKey(emailIngresado)) {
                String hashRegistrado = usuariosRegistrados.get(emailIngresado);
                if(hashRegistrado.equals(passwordIngresadaHash)) {
                    System.out.println("Ahora eres moderador.");
                    this.setEmail(emailIngresado);
                    this.setNombreUser(nombreIngresado);
                    this.setEdad(getEdad());
                    listaModeradores.add(this);
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
    public void mostrarModeradores() {
        System.out.println("La cantidad de moderadores en el grupo es: " + listaModeradores.size());
        System.out.println("Los moderadores son:");
        for (UserModerador moderador : listaModeradores) {
            System.out.println("- " + moderador.getNombreUser());

        }
    }

}

