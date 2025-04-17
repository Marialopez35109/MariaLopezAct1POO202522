package co.edu.udec.poo.marialopez;

public class principal {
    public static void main (String[] args){
        int [] numeros = new int [4];
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;

        System.out.println("el valor de la primero posiciones es:" + numeros[0] + ".");
        //iteracion de arrys
        for (int i =0; i<numeros.length;i++){
            System.out.println("El valor es:" +numeros[i] +".");
        }
    }
}
