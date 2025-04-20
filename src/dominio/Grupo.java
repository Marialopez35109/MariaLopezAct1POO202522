package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {
    UserModerador moderador;
    User user;
    String nombreGrupo;
    Articulo articulo;
    Noticia noticia;
    Grupo grupo;
    ArrayList<Grupo> subGrupos = new ArrayList<>();
    LocalDate fechaCreacion;
    Scanner teclado = new Scanner(System.in);
    //Metodos y funciones

    //para saber la cantidad de articulos que hay en el grupo
    public void mostrarCantidadArticulos() {
        ArrayList<Articulo> cantidadArticulos = new ArrayList<>();
        cantidadArticulos.add(articulo);
        System.out.println("La cantidad de articulos en el grupo es: " + cantidadArticulos.size());
    }

    //Para saber la cantidad de miembros
    public void mostrarCantidadMiembros() {
        ArrayList<User> cantidadMiembros = new ArrayList<>();
        cantidadMiembros.add(user);
        System.out.println("La cantidad de miembros en el grupo es: " + cantidadMiembros.size());
        if (cantidadMiembros.size() >= 100) {
            System.out.println("El grupo tiene mas de 100 miembros");
        }
        if (cantidadMiembros.size() <= 50) {
            System.out.println("El grupo tiene menos de 50 miembros");
        }
    }

    //Para saber la cantidad de moderadores
    public void mostrarListaModeradores() {
        ArrayList<UserModerador> listaModeradores = new ArrayList<>();
        String aceptarRechazar;
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Desea ver la lista de moderadores? Si si respuesta es sí presione 1,\n" +
                "si es no presione 2");
        aceptarRechazar = teclado.nextLine();
        if(aceptarRechazar.equals("1")){
            UserModerador userModerador=new UserModerador();
            userModerador.mostrarNombre();
        }
        listaModeradores.add(moderador);
        System.out.println("La cantidad de moderadores en el grupo es: " + listaModeradores.size());
    }

    //para crear un articulo
    public void crearArticulo() {
        Articulo articulo = new Articulo();
        articulo.crearArticulo();
    }

    //para crear una noticia
    public void crearNoticia() {
        Noticia noticia = new Noticia();
        noticia.crearNoticia();
    }

    //para crear un grupo
    public void crearSubGrupo() {
        Grupo subgrupo = new Grupo();
        String aceptarRechazar;
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Desea crear un subgrupo? Si la respuesta es sí \n presione 1, si es no presione 2.");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese el nombre del subgrupo");
            nombreGrupo = teclado.nextLine();
            subGrupos.add(subgrupo);
            System.out.println("Subgrupo creado exitosamente");
        }
        if (aceptarRechazar.equals("2")) {
            System.out.println("Proceso terminado. No se ha creado subgrupos.");
        }
    }

    public void mostrarSubruposCreados() {
        String subGruposCreados = null;
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Desea ver la cantidad de subgrupos que tiene el grupo? \n " +
                "si la respuesta es si presione 1 \n" +
                " si la respuesta es no presione 2");
        subGruposCreados = teclado.nextLine();
        if (subGruposCreados.equals("1")) {
            System.out.println("La cantidad de subgrupos en el grupo son: " + subGrupos.size());
        }
        if (subGruposCreados.equals("2")) {
            System.out.println("saliendo...");
        }

    }

}
