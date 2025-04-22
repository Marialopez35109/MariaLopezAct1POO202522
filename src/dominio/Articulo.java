package dominio;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;
import java.util.Scanner;
import java.util.ArrayList;

public class Articulo {
    UUID id= UUID.randomUUID();
    ArrayList<LocalDate> listafechaCreacion = new ArrayList<>();
    ArrayList<Comentario> listaComentario = new ArrayList<>();
    User autor;
    String resumen;
    String contenido;
    boolean estado;
    Scanner teclado = new Scanner(System.in);

    //CONSTRUCTOR

    public Articulo() {
    }

    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------
    public void crearArticulo() {

        System.out.println("El id del articlo es: "+ id);
        if(autor != null){
        System.out.println("El autor del articulo es: " + autor.getNombreUser());
        }
        System.out.println("Ingrese el resumen del articulo:");
        resumen = teclado.nextLine();
        System.out.println("Ingrese el contenido del articulo:");
        contenido = teclado.nextLine();
        System.out.println(mostrarFechaCreacion());
        Comentario comentario = new Comentario();
        comentario.crearComentario();
        listaComentario.add(comentario);
    }

    public LocalDate mostrarFechaCreacion() {
        LocalDate fechaCreacion  = LocalDate.now();
        listafechaCreacion.add(fechaCreacion);
        return LocalDate.now() ;
    }
}
