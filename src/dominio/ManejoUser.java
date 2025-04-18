package dominio;
import java.util.ArrayList;
import java.util.Scanner;
public class ManejoUser {
    ArrayList<PerfilUser> user;

    public ManejoUser() {
        this.user = new ArrayList<>();
    }

    public ArrayList<PerfilUser> getUser() {
        return user;
    }

    public void setUser(ArrayList<PerfilUser> user) {
        this.user = user;
    }

    public void PromedioEdadUser(ArrayList<PerfilUser> user){
    int sumarEdades=0;
    double promedio=0;
    for(PerfilUser u: user){
     sumarEdades += u.getEdad();
    }
    promedio = (double) sumarEdades /user.size();
    System.out.println("El promedio de edad de los usuarios registrados es "+promedio+".");
    }
    public void RegistrarUser(){
        String nombreUser;
        String email;
        String numeroCelular;
        String password;
        Scanner teclado =new Scanner(System.in);
        System.out.println("Ingrese el nombre de usuario:");
        nombreUser = teclado.nextLine();
        System.out.println("Ingrese el email de usuario:");
        email = teclado.nextLine();
        System.out.println("Ingrese su numero de celular");
        numeroCelular= teclado.nextLine();
        System.out.println("Ingrese el password de usuario:");
        password = teclado.nextLine();

    }
}
