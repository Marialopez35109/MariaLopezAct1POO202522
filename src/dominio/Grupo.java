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
    ArrayList<String> subGrupos = new ArrayList<String>();
    LocalDate fechaCreacion = LocalDate.now();
    Scanner teclado = new Scanner(System.in);
    ArrayList<String> listaGrupos = new ArrayList<String>();

    public UserModerador getModerador() {
        return moderador;
    }

    public void setModerador(UserModerador moderador) {
        this.moderador = moderador;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ArrayList<String> getSubGrupos() {
        return subGrupos;
    }

    public void setSubGrupos(ArrayList<String> subGrupos) {
        this.subGrupos = subGrupos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Scanner getTeclado() {
        return teclado;
    }
    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ArrayList<String> getListaGrupos() {
        return listaGrupos;
    }
    public void setListaGrupos(ArrayList<String> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------

    public void crearGrupo() {
        String aceptarRechazar;
        System.out.println("¿Desea crear un grupo? Si la respuesta es sí \n presione 1, si es no presione 2.");
        aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese el nombre del grupo");
            nombreGrupo = teclado.nextLine();
            listaGrupos.add(nombreGrupo);
            System.out.println("Grupo creado exitosamente");

        }
        if (aceptarRechazar.equals("2")) {
            System.out.println("Proceso terminado. No se ha creado ningun grupo.");
        }
    }

    //para crear un articulo
    public void crearArticulo() {
        if (user != null) {
            Articulo articulo = new Articulo(user);
            articulo.crearArticulo();
            articulo.mostrarCantidadComentarios();
            articulo.darMeGusta();
            articulo.mostrarCantidadMeGusta();
        } else {
            System.out.println("No hay un usuario disponible para crear el artículo.");
        }
    }
    //para crear una noticia
    public void crearNoticia() {
        if (user != null) {
            Noticia noticia = new Noticia(user);
            noticia.crearNoticia();
        } else {
            System.out.println("No hay un usuario disponible para crear la noticia.");
        }
    }

    //para crear un grupo
    public void crearSubGrupo() {
        System.out.println("¿Desea crear un subgrupo? Si la respuesta es sí \n presione 1, si es no presione 2.");
        String aceptarRechazar = teclado.nextLine();
        if (aceptarRechazar.equals("1")) {
            System.out.println("Ingrese el nombre del subgrupo");
            String nombreSubgrupo = teclado.nextLine();
            subGrupos.add(nombreSubgrupo);
            System.out.println("Subgrupo creado exitosamente");
        }
        if (aceptarRechazar.equals("2")) {
            System.out.println("Proceso terminado. No se ha creado subgrupos.");
        }
    }
    //para saber la cantidad de articulos que hay en el grupo
    public void mostrarCantidadArticulos() {
        ArrayList<Articulo> cantidadArticulos = new ArrayList<>();
        cantidadArticulos.add(articulo);
        System.out.println("La cantidad de articulos en el grupo es: " + cantidadArticulos.size());
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
            userModerador.mostrarModeradores();
        }
        if(aceptarRechazar.equals("2")){
            System.out.println("No se mostrara la lista de moderadores");
        }
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
}
