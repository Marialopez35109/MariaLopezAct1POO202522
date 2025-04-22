package dominio;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class BaseDeDatos {
protected HashMap<String, String> listaDatos= new HashMap<>();
protected HashMap<String, Integer> listaEdad= new HashMap<>();
public void BaseDeDatos() {
    User user= new User();
    listaDatos.put(user.nombreUser, user.email);
    listaEdad.put(user.nombreUser, user.edad);
    listaDatos.put(user.nombreUser, user.numeroCelular);

}
    protected ArrayList<User> usuarios = new ArrayList<>();
    protected ArrayList<Articulo> articulos = new ArrayList<>();
    protected Map<User, ArrayList<Articulo>> mapUserArticulos = new HashMap<>();
public void baseDatosArticulos(){

}

}
