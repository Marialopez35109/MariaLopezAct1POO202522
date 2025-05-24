package dominio;

import java.time.LocalDate;
import java.util.Scanner;

public class Comentario {
    User user;
    String texto;
    LocalDate fechaCreacion;
    boolean estado;

    public void crearComentario() {
        String aceptarRechazar;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea agregar un comentario? \n" +
                "si es asi presione 1, si no presione 2");
        aceptarRechazar = teclado.nextLine();
        if(aceptarRechazar.equals("1")){
            System.out.println("Ingrese el texto del comentario:");
            texto = teclado.nextLine();
            fechaCreacion = LocalDate.now();
            System.out.println("Fecha: " + fechaCreacion);
        }else if(aceptarRechazar.equals("2")){
            System.out.println("No se agrego ningun comentario");
        }
    }
}
