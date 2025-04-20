package dominio;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Scanner;

public class Articulo {
    UUID id= UUID.randomUUID();
    LocalDate fechaCreacion;
    User user;
    String resumen;
    String contenido;
    Comentario comentario;
    boolean estado;
    Scanner teclado = new Scanner(System.in);
    //Funciones y metodos

    public void crearArticulo() {
        System.out.println("El id del articlo es: "+ id);
        System.out.println("El autor del articulo es: " + user.getNombreUser());
    System.out.println("Ingrese el resumen del articulo:");
    resumen = teclado.nextLine();
    System.out.println("Ingrese el contenido del articulo:");
    contenido = teclado.nextLine();
    }
    public void crearComentario() {
        String aceptarRechazar;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea agregar un comentario? \n" +
                "si es asi presione 1, si no presione 2");
        aceptarRechazar = teclado.nextLine();
        if(aceptarRechazar.equals("1")){
            comentario.crearComentario();
        }else if(aceptarRechazar.equals("2")){
            System.out.println("No se agrego ningun comentario");
        }
    }
}
