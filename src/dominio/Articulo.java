package dominio;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;
import java.util.Scanner;
import java.util.ArrayList;

public class Articulo {
    UUID id = UUID.randomUUID();
    ArrayList<LocalDate> listafechaCreacion = new ArrayList<>();
    ArrayList<Comentario> listaComentario = new ArrayList<>();
    ArrayList<Integer> listaMeGusta = new ArrayList<>();
    User autor;
    String resumen;
    String contenido;
    boolean estado;
    boolean meGusta;
    HashMap<User, Articulo> listaArticulos = new HashMap<>();
    Scanner teclado = new Scanner(System.in);

    //CONSTRUCTOR

    public Articulo(User autor) {
        this.autor = autor;
    }

    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------
    public void crearArticulo() {
        System.out.println("¿Desea crear un articulo? Si es así,\n " +
                "presione 1 si no es así presione 2.");
        String aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("El id del articulo es: " + id);
            if (autor != null) {
                listaArticulos.put(autor, this);
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
        } else if (aceptarRechazar.equals("2")) {
            System.out.println("No se creó ningún artículo");
        }
    }

    public LocalDate mostrarFechaCreacion() {
        LocalDate fechaCreacion = LocalDate.now();
        listafechaCreacion.add(fechaCreacion);
        return fechaCreacion;
    }

    public void mostrarCantidadComentarios() {
        System.out.println("La cantidad de comentarios es: " + listaComentario.size());
    }

    public void darMeGusta() {
        System.out.println("¿Le gusta el articulo? \n" +
                "si es asi presione 1, si no presione 2");
        String aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("2")) {
            System.out.println("Ya le diste me gusta a este articulo");
        } else if(aceptarRechazar.equals("1")) {
            System.out.println("Le diste me gusta al articulo");
            listaMeGusta.add(1);
        }
    }

    public void mostrarCantidadMeGusta() {
        int contador = 0;
        if (contador < 20) {
            System.out.println("El articulo tiene menos de 20 gusta");
        }else if(contador == 20){
            System.out.println("El articulo tiene 20 o mas de 20 me gusta");

        }
    }
}
