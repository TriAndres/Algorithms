import java.io.*;

public class Lesson9 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // Чтение размеров матриц n, m, k
            String[] dimensions = reader.readLine().split("\\s+");
            int n = Integer.parseInt(dimensions[0]); // строки матрицы A
            int m = Integer.parseInt(dimensions[1]); // столбцы матрицы A и строки матрицы B
            int k = Integer.parseInt(dimensions[2]); // столбцы матрицы B

            // Чтение матрицы A (n x m)
            int[][] A = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < m; j++) {
                    A[i][j] = Integer.parseInt(row[j]);
                }
            }

            // Чтение матрицы B (m x k)
            int[][] B = new int[m][k];
            for (int i = 0; i < m; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < k; j++) {
                    B[i][j] = Integer.parseInt(row[j]);
                }
            }

            // Умножение матриц A и B -> C (n x k)
            int[][] C = multiplyMatrices(A, B, n, m, k);

            // Транспонирование матрицы C -> C_T (k x n)
            int[][] C_T = transposeMatrix(C, n, k);

            // Вывод транспонированной матрицы C_T
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

    // Метод для умножения двух матриц
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

    // Метод для транспонирования матрицы
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