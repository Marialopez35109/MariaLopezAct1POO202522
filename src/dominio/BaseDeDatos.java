package dominio;
import java.util.HashMap;
import java.util.ArrayList;
public class BaseDeDatos {
    protected HashMap<String, String> listaDatos = new HashMap<>();
    protected HashMap<String, Integer> listaEdad = new HashMap<>();
    protected ArrayList<User> usuarios = new ArrayList<>();
    protected ArrayList<Articulo> articulos = new ArrayList<>();
    protected HashMap<String, ArrayList<Articulo>> mapUserArticulos = new HashMap<>();

    public void baseDatosArticulos(User user) {
        Articulo articulo = new Articulo(user); // Pasar el usuario como autor
        articulo.crearArticulo(); // Crear el artículo
        if (mapUserArticulos.containsKey(user.getNombreUser())) {
            mapUserArticulos.get(user.getNombreUser()).add(articulo);
        } else {
            ArrayList<Articulo> listaArticulos = new ArrayList<>();
            listaArticulos.add(articulo);
            mapUserArticulos.put(user.getNombreUser(), listaArticulos);
        }
    }
}
