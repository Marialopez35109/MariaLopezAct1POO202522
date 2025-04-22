package co.edu.udec.poo.marialopez;
import dominio.Grupo;
import dominio.ManejoUser;
import dominio.User;
import dominio.UserModerador;

public class principal {
    public static void main(String[] args) {
        User userRegis1 = new User();
        ManejoUser manejoUser = new ManejoUser();
        UserModerador userModerador = new UserModerador();

        System.out.println("Registrarse:");
        userRegis1.RegistrarUser();
        manejoUser.AñadirUser(userRegis1);

        System.out.println("Iniciar Sesión:");
        userModerador.ConvertirseModerador();
        userModerador.IniciarSesion();

        Grupo grupo1= new Grupo();
        grupo1.crearSubGrupo();
        grupo1.mostrarSubruposCreados();
        grupo1.mostrarCantidadMiembros();
        grupo1.crearArticulo();
        grupo1.crearNoticia();
        grupo1.mostrarCantidadArticulos();
        grupo1.mostrarListaModeradores();


    }
}