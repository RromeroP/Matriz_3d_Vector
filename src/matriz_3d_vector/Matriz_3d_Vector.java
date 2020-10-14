/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_3d_vector;

import java.util.Scanner;

/**
 *
 * @author alumnat
 */
public class Matriz_3d_Vector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Añadimos la posibilidad de hacer input
        Scanner input = new Scanner(System.in);

        int[] vector = null;
        int[][][] matrix_3d = null;

        int col = (int) (Math.random() * 4) + 2;
        int row = (int) (Math.random() * 4) + 2;
        int prof = (int) (Math.random() * 3) + 2;

        int option = 1;

        if (option == 1) {

            vector = random_vector(col, row, prof);
            show_vector(vector);

            matrix_3d = vector_to_matrix(col, row, prof, vector);
            show_matrix(matrix_3d);
        } else if (option == 2) {

            matrix_3d = random_matrix(col, row, prof);
            show_matrix(matrix_3d);

            vector = matrix_to_vector(col, row, prof, matrix_3d);
            show_vector(vector);
        }

        if (option == 1) {

//            System.out.println("Modificar valor del vector: ");
            System.out.print("Elige la posicion a modificar: ");
            int position = input.nextInt();

            System.out.print("Elige el valor nuevo: ");
            int value = input.nextInt();

            update_vector(col, row, prof, position, value, vector, matrix_3d);
            show_vector(vector);
            show_matrix(matrix_3d);

        }

    }

    public static int[] random_vector(int col, int row, int prof) {

        int vector[] = new int[col * row * prof];

        for (int i = 0; i < (col * row * prof); i++) {
            vector[i] = (int) (Math.random() * 9) + 1;
        }

        return vector;
    }

    public static int[] show_vector(int[] vector) {

        System.out.println("Vector de tamaño: " + vector.length);

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        System.out.println("\n");

        return vector;
    }

    public static int[][][] vector_to_matrix(int col, int row,
            int prof, int vector[]) {

        int[][][] matrix_3d = new int[row][col][prof];

        int index = 0;

        for (int z = 0; z < prof; z++) {
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    matrix_3d[x][y][z] = vector[index++];
                }
            }
        }

        return matrix_3d;
    }

    public static int[] update_vector(int col, int row, int prof, int position, int value, int[] vector,
            int[][][] matrix_3d) {

        System.out.println("");

        //Cambiamos el valor del vector
        vector[position - 1] = value;

        int update_col = position / row;
        int update_row = position % row;
        int update_prof = position / (col * row);

        //Cambiamos el valor de la matriz
        matrix_3d[update_col][update_row - 1][update_prof - 1] = value;

        return vector;
    }

    public static int[][][] random_matrix(int col, int row, int prof) {

        int[][][] matrix_3d = new int[row][col][prof];

        for (int z = 0; z < prof; z++) {
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {

                    matrix_3d[x][y][z] = (int) (Math.random() * 9) + 1;
                }
            }
        }

        return matrix_3d;
    }

    public static int[][][] show_matrix(int[][][] matrix_3d) {

        int prof = matrix_3d[0][0].length;
        int col = matrix_3d[0].length;
        int row = matrix_3d.length;

        System.out.println("Matriz de: " + row + "x" + col + "x" + prof + "\n");

        for (int z = 0; z < prof; z++) {

            System.out.println("Z: " + (z + 1) + "\n--------\n");

            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    System.out.print(matrix_3d[x][y][z] + " ");
                }

                System.out.println("");
            }
            System.out.println("");
        }

        return matrix_3d;
    }

    public static int[] matrix_to_vector(int col, int row, int prof,
            int matrix_3d[][][]) {

        int[] vector = new int[col * row * prof];

        int index = 0;

        for (int z = 0; z < prof; z++) {
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {

                    vector[index++] = (int) matrix_3d[x][y][z];
                    matrix_3d[x][y][z] = (int) (Math.random() * 9) + 1;
                }
            }
        }

        return vector;
    }
}
