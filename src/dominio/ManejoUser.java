package dominio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ManejoUser extends User {
    ArrayList<User> usuario;
    ArrayList<Grupo> gruposCreados;
    //Constructor
    public ManejoUser() {
        this.usuario = new ArrayList<>();
    }
    //Setter y Getter
    public ArrayList<User> getUser() {
        return usuario;
    }
    public void setUser(ArrayList<User> user) {
        this.usuario = user;
    }
    //-------------------------------------------- METODOS Y FUNCIONES ----------------------------------------------------------

    //para ver la cantidad y los usuarios registrados, junto con algunos datos
    public void UsersRegistrados() {
        System.out.println("Desea ver la cantidad de usuarios registrados en la red social?); \n" +
                "si es asi presione 1, si no presione 2");
        String aceptarRechazar = teclado.nextLine();
        if (usuario.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else if(aceptarRechazar.equals("1")) {
            System.out.println("Usuarios registrados:");
            for (User user: usuario) {
                System.out.println("Nombre: " + user.getNombreUser());
            }
            System.out.println("Cantidad de usuarios registrados:"+ usuario.size());
        } else if (aceptarRechazar.equals("2")) {
            System.out.println("Proceso terminado. No se ha mostrado la cantidad de usuarios registrados.");
        }
    }
    public void PromedioEdadUser() {
        if (usuario.isEmpty()) {
            System.out.println("No hay usuarios registrados para calcular el promedio de edad.");
            return;
        }

        int sumarEdades = 0;
        double promedio = 0;
        for (User u : usuario) {
            sumarEdades += u.getEdad();
        }
        promedio = (double) sumarEdades / usuario.size();
        System.out.println("El promedio de edad de los usuarios registrados es " + promedio + ".");
    }


    public void consultarCantidadGruposUsuario(ArrayList<Grupo> grupos) {
        System.out.println("Desea ver la cantidad de grupos creados por usuario?); \n" +
                "si es asi presione 1, si no presione 2");
        String aceptarRechazar = teclado.nextLine();
        HashMap<String, Integer> gruposPorUsuario = new HashMap<>();
        if (grupos == null || grupos.isEmpty()) {
            System.out.println("No hay grupos creados para este usuario.");
            return;
        }
        for (Grupo grupo : grupos) {
            if (grupo.getUser() != null) {
                String nombreUsuario = grupo.getUser().getNombreUser();
                gruposPorUsuario.put(nombreUsuario, gruposPorUsuario.getOrDefault(nombreUsuario, 0) + 1);
            }
        }

        System.out.println("Cantidad de grupos creados por cada usuario:");
        for (String usuario : gruposPorUsuario.keySet()) {
            System.out.println("Usuario: " + usuario + ", Grupos creados: " + gruposPorUsuario.get(usuario));
        }
    }
}


