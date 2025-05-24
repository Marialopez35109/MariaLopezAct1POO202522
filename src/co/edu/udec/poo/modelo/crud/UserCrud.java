package co.edu.udec.poo.modelo.crud;

import dominio.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserCrud {
    private ArrayList<User> emails;
    Scanner teclado = new Scanner(System.in);

    public UserCrud() {
        this.emails = new ArrayList<>();
    }

    // METODOS CRUD
    public void agregar(User user) throws Exception {
        for (User u : emails) {
            if (u.getEmail().equals(user.getEmail())) {
                throw new Exception("El usuario ya está registrado.");
            } else {
                emails.add(user);
                System.out.println("Usuario agregado con éxito.");

            }
        }

    }

    public static void buscar(User user) throws Exception {

    }

    public void editar(User user) throws Exception {
        System.out.println("¿Desea editar su email de usuario?\n " +
                "presione 1 para editar, presione 2 para saltar.");
        String aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese su viejo email:");
            String emailViejo = teclado.nextLine();
            User emailAntiguo = new User(emailViejo);
            emails.add(emailAntiguo);
            System.out.println("Ingrese el nuevo email:");
            String nuevoEmail = teclado.nextLine();
            for (int u = 0; u < emails.size(); u++) {
                if (emails.get(u) == null) {
                    throw new Exception("El usuario no existe");
                } else {
                    emails.get(u).setEmail(nuevoEmail);
                    System.out.println("Usuario editado");
                    break;
                }
            }

        } else if (aceptarRechazar.equals("2"))
            System.out.println("No se edito ningun usuario");
    }

    public void eliminar(User user) throws Exception {
        System.out.println("¿Desea eliminar su email de usuario?\n " +
                "presione 1 para eliminar, presione 2 para saltar.");
        String aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese su email:");
            String emailEliminar = teclado.nextLine();

            for (User u : emails) {
                if (u.getEmail().equals(emailEliminar)) {
                    emails.remove(u);
                    System.out.println("Usuario eliminado");
                    break;

                }
            }
        } else if (aceptarRechazar.equals("2"))
            System.out.println("No se eliminó ningun usuario");

    }

    public ArrayList<User> listarTodo() throws Exception {
        if (emails.isEmpty()) {
            throw new Exception("No hay usuarios registrados.");
        } else {
            for (User u : emails) {
                System.out.println("La lista de emails es: "+ u.getEmail());
            }
            return emails;
        }
    }
    public int contar() throws Exception {
        System.out.println(emails.size());
        return emails.size();
    }

}









