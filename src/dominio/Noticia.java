package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Noticia extends Articulo {
    LocalDate fechaCaducidad;
    LocalDate fechaCreacion;
    int fechaLimite = 1;
    HashMap<User, Noticia> listaNoticia = new HashMap<>();
    public Noticia() {
        this.fechaCreacion = LocalDate.now();
        this.fechaCaducidad = fechaCreacion.plusDays(fechaLimite);
        this.estado = false;
    }

    public void crearNoticia() {
        System.out.println("Ingrese el contenido de la noticia:");
        contenido = teclado.nextLine();

    }

    public void borrarNoticia() {
        if (fechaCaducidad.isAfter(fechaCreacion)) {
        }
    }
}


