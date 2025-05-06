package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task9 extends Task {
    public static void main(String[] args) {
        new Task9().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();
            String[] dimensions = reader.readLine().split("\\s+");
            int n = Integer.parseInt(dimensions[0]); // строки матрицы A
            int m = Integer.parseInt(dimensions[1]); // столбцы матрицы A и строки матрицы B
            int k = Integer.parseInt(dimensions[2]); // столбцы матрицы B

            int[][] A = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < m; j++) {
                    A[i][j] = Integer.parseInt(row[j]);
                }
            }

            int[][] B = new int[m][k];
            for (int i = 0; i < m; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < k; j++) {
                    B[i][j] = Integer.parseInt(row[j]);
                }
            }

            int[][] C = multiplyMatrices(A, B, n, m, k);

            int[][] C_T = transposeMatrix(C, n, k);


            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(C_T[i][j] + " ");
                }
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {
        System.out.println("Ввод\n" +
                "1 2 1\n" +
                "3 4 \n" +
                "9 \n" +
                "8\n" +
                "Вывод\n" +
                "59\n" +
                "Ввод\n" +
                "2 1 3\n" +
                "0 \n" +
                "2 \n" +
                "1 2 8\n" +
                "Вывод\n" +
                "0 2 \n" +
                "0 4 \n" +
                "0 16\n" +
                "Ввод\n" +
                "6 1 4\n" +
                "6 \n" +
                "1 \n" +
                "3 \n" +
                "3 \n" +
                "1 \n" +
                "9 \n" +
                "10 2 0 3\n" +
                "Вывод\n" +
                "60 10 30 30 10 90 \n" +
                "12 2 6 6 2 18 \n" +
                "0 0 0 0 0 0 \n" +
                "18 3 9 9 3 27\n");
    }

    private static int[][] multiplyMatrices(int[][] A, int[][] B, int n, int m, int k) {
        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int p = 0; p < m; p++) {
                    C[i][j] += A[i][p] * B[p][j];
                }
            }
        }
        return C;
    }

    private static int[][] transposeMatrix(int[][] C, int n, int k) {
        int[][] C_T = new int[k][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                C_T[j][i] = C[i][j];
            }
        }
        return C_T;
    }
}
