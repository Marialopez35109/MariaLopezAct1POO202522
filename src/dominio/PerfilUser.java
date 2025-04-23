package dominio;
import java.net.URI;
import java.awt.Desktop;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class PerfilUser {
    String intereses;
    String lugarNacimiento;
    String lugarResidencia;
    LocalDate fechaNacimiento;
    //String fotoPerfil;

    public void crearPerfil() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese sus intereses:");
        intereses = teclado.nextLine();
        System.out.println("Ingrese su lugar de nacimiento:");
        lugarNacimiento = teclado.nextLine();
        System.out.println("Ingrese su lugar de residencia:");
        lugarResidencia = teclado.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
        fechaNacimiento = LocalDate.parse(teclado.nextLine());
    }
}


