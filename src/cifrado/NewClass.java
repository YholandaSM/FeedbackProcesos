/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class NewClass {

    static final String MIN = "abcdefghijklmnopqrstuvwxyz";
    static final String MAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Integer desplazamiento;
    static String textoEncriptado;

    public static void main(String[] args) {

        String opcion = "";
        do {

            Scanner teclado = new Scanner(System.in);
            Scanner sOpcion = new Scanner(System.in);
            String texto = null;

            System.out.println("Introduce un texto: ");
            texto = teclado.nextLine();

            System.out.println("Introduce valor de desplazamiento: ");

            desplazamiento = teclado.nextInt();

            System.out.println("¿Quiere codificar(C) o descodificar(D) ?. Pulse cualquier tecla"
                    + " si quiere salir del programa");
            opcion = sOpcion.nextLine();

            if (opcion.equalsIgnoreCase("C")) {
                char array[] = texto.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    array[i] = (char) (array[i] + desplazamiento);
                }

                String encriptado = String.valueOf(array);

                System.out.println("El texto encriptado es " + encriptado);
            } else if (opcion.equalsIgnoreCase("D")) {
                char array[] = texto.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    array[i] = (char) (array[i] - desplazamiento);
                }
                 String desencriptado = String.valueOf(array);
                System.out.println("El texto encriptado es " + desencriptado);

            } else {
                System.exit(0);
            }
        } while (!opcion.equals("S"));

    }

    static private String codificar(String texto) {
        textoEncriptado = "";
        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < MIN.length(); j++) {

                //Comparamos con las minúsculas
                if (texto.charAt(i) == MIN.charAt(j)) {
                    if (j + desplazamiento >= MIN.length()) {
                        textoEncriptado += MIN.charAt((j + desplazamiento) % MIN.length());
                    } else {
                        textoEncriptado += MIN.charAt(j + desplazamiento);

                    }
                    //Comparamos con las mayúsculas
                } else if (texto.charAt(i) == MAY.charAt(j)) {
                    if (j + desplazamiento >= MAY.length()) {
                        textoEncriptado += MAY.charAt((j + desplazamiento) % MAY.length());
                    } else {
                        textoEncriptado += MAY.charAt(j + desplazamiento);

                    }
                }

            }

        }//fin segundo for

        return textoEncriptado;

    }//fin primer for

    static private String descodificar(String texto) {
        textoEncriptado = "";
        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < MIN.length(); j++) {

                //Comparamos con las minúsculas
                if (texto.charAt(i) == MIN.charAt(j)) {
                    if (j + desplazamiento >= MIN.length()) {
                        textoEncriptado += MIN.charAt((j - desplazamiento) % MIN.length());
                    } else {
                        textoEncriptado += MIN.charAt(j - desplazamiento);

                    }
                    //Comparamos con las mayúsculas
                } else if (texto.charAt(i) == MAY.charAt(j)) {
                    if (j + desplazamiento >= MAY.length()) {
                        textoEncriptado += MAY.charAt((j - desplazamiento) % MAY.length());
                    } else {
                        textoEncriptado += MAY.charAt(j - desplazamiento);

                    }
                }

            }

        }//fin segundo for

        return textoEncriptado;
    }
}
