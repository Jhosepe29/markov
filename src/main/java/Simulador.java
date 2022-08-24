import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Simulador {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Integer numeroColumnas = 0;
        String[] matrizText;
        Double[][] matrizTransicion;
        Integer potencia;

        System.out.printf("Cuantas filas tiene la matriz de transicion? : ");
        Integer numerofilas = entrada.nextInt();
        matrizText = pedirMatriz(numerofilas);


        numeroColumnas = matrizText[0].split(" ").length;

        matrizTransicion = llenarMatrizTransicion(numerofilas, numeroColumnas, matrizText);


        System.out.println("Ingrese la potencia :");
        potencia = entrada.nextInt();
        Double[][] resultado = new Double[numerofilas][numeroColumnas];
        System.out.println("La matris de transicion :");
        System.out.println(mostarMatriz(matrizTransicion, numerofilas, numeroColumnas));
        for (int i = 1; i < potencia; i++) {
            if (i == 1) {
                resultado = multiplicar(matrizTransicion, matrizTransicion);
                System.out.println("El resultado de la potencia " + (i + 1));
                System.out.println(mostarMatriz(resultado, numerofilas, numeroColumnas));


            } else {
                resultado = multiplicar(resultado, matrizTransicion);
                System.out.println("El resultado de la potencia " + (i + 1));
                System.out.println(mostarMatriz(resultado, numerofilas, numeroColumnas));
            }

        }


    }

    public static Double[][] llenarMatrizTransicion(Integer numerofilas, Integer numeroColumnas, String[] matrizText) {
        Double[][] matrizTransicion = new Double[numerofilas][numeroColumnas];
        for (int i = 0; i < numerofilas; i++) {
            String[] elementos = matrizText[i].split(" ");
            for (int j = 0; j < numeroColumnas; j++) {
                matrizTransicion[i][j] = Double.valueOf(elementos[j]);
            }
        }
        return matrizTransicion;
    }

    public static String[] pedirMatriz(Integer numerofilas) {
        String[] matrizText = new String[numerofilas];
        for (int i = 1; i <= numerofilas; i++) {
            String fila = JOptionPane.showInputDialog("Ingresa la fila " + i + " los valores separados por espacio");
            matrizText[i - 1] = fila;
        }
        System.out.println("La matriz que ingreso fue: ");
        for (int i = 0; i < numerofilas; i++) {
            System.out.println("| " + matrizText[i] + " |");
        }
        return matrizText;
    }

    public static String mostarMatriz(Double[][] matriz, Integer filas, Integer columnas) {
        String salida = "";
        for (int i = 0; i < filas; i++) {
            salida += "|";
            for (int j = 0; j < columnas; j++) {

                salida += " " + matriz[i][j] + " ";
            }
            salida += "|\n";
        }
        return salida;
    }

    public static Double[][] multiplicar(Double[][] A, Double[][] B) {
        int filasA = A.length;
        int columnasA = A[0].length;
        int filasB = B.length;
        int columnasB = B[0].length;

        Double[][] resultado = new Double[filasA][columnasB];
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                resultado[i][j] = 0.0;
            }
        }

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return resultado;
    }


}
