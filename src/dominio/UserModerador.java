package dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class UserModerador extends User {
    ArrayList<UserModerador> listaModeradores= new ArrayList<>();


    //metodos y funciones
    @Override
    public void IniciarSesion() {
        String aceptarRechazar = "";
        System.out.println("Desea iniciar sesión como moderador?); \n" +
                "si es asi presione 1, si no presione 2");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese su email");
            email=teclado.nextLine();
            System.out.println("Ingrese su contraseña");
            password=teclado.nextLine();
        }if (aceptarRechazar.equals("2")){
           super.IniciarSesion();
        }

    }
public void SerModereador(){
    System.out.println("Ingrese sus datos de usuario:");
    System.out.println("Ingrese su email");
    email=teclado.nextLine();
    System.out.println("Ingrese su nombre de usuario");
    nombreUser=teclado.nextLine();
    System.out.println("Ingrese su contraseña");
    password=teclado.nextLine();
    }

    public void mostrarNombre(){
    System.out.println("Los moderadores son:" + getNombreUser());
    }

    public void ConvertirseModerador() {
        String aceptarRechazar;
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Desea convertirse en moderador? Si su respuesta es sí,\n " +
                "presione 1 si es no presione 2");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
           SerModereador();
        }
        if (aceptarRechazar.equals("2")) {
            System.out.println("Proceso terminado. No se creo moderador.");
        }
    }

}
