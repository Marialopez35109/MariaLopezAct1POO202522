package dominio;
import java.util.ArrayList;

public class ManejoUser extends User {
    ArrayList<User> usuario;

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
    //Metodos y funciones
    //para añardir un usuario a la lista
    public void AñadirUser(User user) {
        if (usuario.contains(user)) { // Validación para evitar duplicados
            System.out.println("El usuario ya está registrado.");
        } else {
            usuario.add(user);
            System.out.println("Usuario agregado con éxito.");
        }
    }

    //para ver la cantidad y los usuarios registrados, junto con algunos datos
    public void UsersRegistrados() {
        if (usuario.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (User user: usuario) {
                System.out.println("Nombre: "+ user.getNombreUser() + "Email: "+ user.getEmail() + "Edad: "+ user.SolicitarEdad());
            }
            System.out.println("Cantidad de usuarios registrados:"+ usuario.size());
        }
    }
    public void PromedioEdadUser(ArrayList<User> user){
    int sumarEdades=0;
    double promedio=0;
    for(User u: user){
     sumarEdades += u.SolicitarEdad();
    }
    promedio = (double) sumarEdades /user.size();
    System.out.println("El promedio de edad de los usuarios registrados es "+promedio+".");
    }

}


