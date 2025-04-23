package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Noticia extends Articulo {
    LocalDate fechaCaducidad;
    LocalDate fechaCreacion;
    int fechaLimite = 1;
    HashMap<User, Noticia> listaNoticia = new HashMap<>();

    public Noticia(User autor) {
        super(autor); // Llama al constructor de Articulo con el autor
        this.fechaCreacion = LocalDate.now();
        this.fechaCaducidad = fechaCreacion.plusDays(fechaLimite);
        this.estado = false;
    }

    public void crearNoticia() {
        System.out.println("¿Desea crear una noticia? Si es así,\n " +
                "presione 1 si no es así presione 2.");
        String aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("El id de la noticia es: " + id);
            if (autor != null) {
                listaNoticia.put(autor, this);
                System.out.println("El autor de la noticia es: " + autor.getNombreUser());
            }
            System.out.println("Ingrese el contenido de la noticia:");
            contenido = teclado.nextLine();
            System.out.println("La fecha de caducidad es: " + fechaCaducidad);
        } else if (aceptarRechazar.equals("2")) {
            System.out.println("No se creo ninguna noticia");
        }
    }

    public void borrarNoticia() {
        if (fechaCaducidad.isBefore(LocalDate.now())) {
            listaNoticia.entrySet().removeIf(entry -> entry.getValue().fechaCaducidad.isBefore(LocalDate.now()));
            System.out.println("Se han eliminado las noticias caducadas.");

        } else {
            System.out.println("La noticia aún no ha caducado.");
        }
    }
}


