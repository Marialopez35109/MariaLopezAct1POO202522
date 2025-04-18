package dominio;
import java.net.URI;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Date;

public class PerfilUser {
    String lugarNacimiento;
    //FotoPerfil fotoPerfil;
    String intereses;
    String lugarResidencia;
    Date fechaNacimiento;
    protected String urlPersonal;
    int edad=0;

    public PerfilUser(String lugarNacimiento, String intereses,String lugarResidencia, Date fechaNacimiento, int edad){
        this.lugarNacimiento = lugarNacimiento;
        this.intereses = intereses;
        this.lugarResidencia = lugarResidencia;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;

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
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}


