package dominio;

import java.util.Date;

public class Noticia extends Articulo {
    Date fechaCaducidad;
    public void crearNoticia() {
        System.out.println("Ingrese el contenido de la noticia:");
        contenido = teclado.nextLine();
    }
}
