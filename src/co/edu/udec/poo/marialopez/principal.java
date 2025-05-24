package co.edu.udec.poo.marialopez;
import co.edu.udec.poo.modelo.crud.UserCrud;
import dominio.Grupo;
import dominio.ManejoUser;
import dominio.User;
import dominio.UserModerador;

public class principal {
    public static void main(String[] args) {
        User userRegis1 = new User();
        ManejoUser manejoUser = new ManejoUser();
        UserModerador userModerador = new UserModerador();
        UserCrud userCrud = new UserCrud();

        System.out.println("Registrarse:");
        userRegis1.RegistrarUser();
        try{
            userCrud.agregar(userRegis1);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        try {
            userCrud.editar(userRegis1);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try{
            userCrud.eliminar(userRegis1);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try{
            userCrud.listarTodo();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try{
            userCrud.contar();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Iniciar Sesión:");
        userModerador.ConvertirseModerador();
        userModerador.IniciarSesion();
        userRegis1.crearPerfilUser();

        Grupo grupo1= new Grupo();
        userRegis1.crearGrupo();
        grupo1.crearSubGrupo();
        grupo1.mostrarSubruposCreados();
        grupo1.mostrarCantidadMiembros();
        grupo1.setUser(userRegis1);
        grupo1.crearArticulo();
        grupo1.crearNoticia();
        grupo1.mostrarCantidadArticulos();
        grupo1.mostrarListaModeradores();
        userRegis1.mostrarGruposCreadosUser();
        manejoUser.PromedioEdadUser();
        manejoUser.UsersRegistrados();

    }
}