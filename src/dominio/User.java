package dominio;
import java.util.ArrayList;
public class User {
        String nombreUser;
        public String email;
        protected String numeroCelular;
        private String password;
       // Arraylist<Grupo> gruposCreados;
        PerfilUser perfilUser;

        //creacion constructor
        public  User (String nombreUser, String email){
            this.nombreUser = nombreUser;
            this.email = email;
        }

    //Creando getters y setters

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PerfilUser getPerfilUser() {
        return perfilUser;
    }

    public void setPerfilUser(PerfilUser perfilUser) {
        this.perfilUser = perfilUser;
    }
}
