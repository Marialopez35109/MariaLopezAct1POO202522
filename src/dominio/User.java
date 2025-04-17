package dominio;
import java.util.Date;

public class User {
        String nombreUser;
        String lugarNacimiento;
        //FotoPerfil fotoPerfil;
        String intereses;
        String LugarResidencia;
        Date fechaNacimiento;
        protected String urlPersonal;
        protected String email;
        protected String numeroCelular;
        private String password;

        //creacion constructor
        public  User (String nombreUser, String urlPersonal, String email, String numeroCelular, String intereses){
            this.nombreUser = nombreUser;
            this.urlPersonal = urlPersonal;
            this.email = email;
            this.numeroCelular = numeroCelular;
            this.intereses = intereses;
            this.fechaNacimiento = new Date();
        }

    //Creando getters y setters

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getLugarResidencia() {
        return LugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        LugarResidencia = lugarResidencia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUrlPersonal() {
        return urlPersonal;
    }

    public void setUrlPersonal(String urlPersonal) {
        this.urlPersonal = urlPersonal;
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


}
