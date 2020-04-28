package cifrado;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que cifra y descrifra palabras con el método del cifrado de Cesar.
 *
 * @author Hp
 */
public class CifradoCesar {

    static final String MIN_COD = "abcdefghijklmnopqrstuvwxyz";
    static final String MAY_COD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static final String MIN_DES = "zyxwvutsrqponmlkjihgfedcba";
    static final String MAY_DES = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

    static final int CODIFICAR = 0;
    static final int DESCODIFICAR = 1;

    static Integer desplazamiento;
    static String textoEncriptado;

    public static void main(String[] args) {

        String opcion = "";
        do {

            //Variables para guardar datos introducidos por teclado
            Scanner teclado = new Scanner(System.in);
            Scanner sOpcion = new Scanner(System.in);
            String texto = null;

            //1.PEDIMOS LA PALABRA A CODIFICAR O DESCODIFICAR
            System.out.println("Introduce una palabra: ");
            texto = teclado.nextLine();

            //2.PEDIMOS EL VALOR DE DESPLAZAMIENTO
            pedirDesplazamiento();

            //3.PREGUNTAMOS QUÉ OPERACIÓN QUIERE HACER
            System.out.println("¿Quiere codificar(C) o descodificar(D) ?. Pulse cualquier tecla"
                    + " si quiere salir del programa");
            opcion = sOpcion.nextLine();

            if (opcion.equalsIgnoreCase("C")) {
                System.out.println(procesar(texto, CODIFICAR));
            } else if (opcion.equalsIgnoreCase("D")) {
                System.out.println(procesar(texto, DESCODIFICAR));
            } else {
                System.exit(0);
            }
        } while (!opcion.equals("S"));

    }

    /**
     * Método que codifica o descodifica un texto, en fúnción del parámetro
     * introducido por el usuario
     *
     * @param texto texto que introduce el usuario
     * @param accion variable que indica si hay que codificar o descodificar
     *
     * @return resultado del proceso
     */
    static private String procesar(String texto, int accion) {
        //codificar
        String abcMin = "";
        String abcMay = "";

        if (accion == CODIFICAR) {
            abcMin = MIN_COD;
            abcMay = MAY_COD;
            //si hay que descodificar se utiliza el alfabeto al revés
        } else if (accion == DESCODIFICAR) {
            abcMin = MIN_DES;
            abcMay = MAY_DES;
        }
        textoEncriptado = "";
        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < abcMin.length(); j++) {

                //Comparamos con las minúsculas
                if (texto.charAt(i) == abcMin.charAt(j)) {
                    if (j + desplazamiento >= abcMin.length()) {
                        textoEncriptado += abcMin.charAt((j + desplazamiento) % abcMin.length());
                    } else {
                        textoEncriptado += abcMin.charAt(j + desplazamiento);

                    }
                    //Comparamos con las mayúsculas
                } else if (texto.charAt(i) == abcMay.charAt(j)) {
                    if (j + desplazamiento >= abcMay.length()) {
                        textoEncriptado += abcMay.charAt((j + desplazamiento) % abcMay.length());
                    } else {
                        textoEncriptado += abcMay.charAt(j + desplazamiento);

                    }
                }

            }

        }//fin segundo for

        return textoEncriptado;

    }//fin primer for

    /**
     * Método que comprueba si el valor introducido por teclado es un número
     */
    static private void pedirDesplazamiento() {
        Scanner teclado = new Scanner(System.in);
        boolean continua;
        do {

            try {
                System.out.println("Introduce valor de desplazamiento: ");
                continua = false;
                desplazamiento = teclado.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Debe introducir un valor numérico!!");
                teclado.next();
                continua = true;
            }
        } while (continua);

    }

}
