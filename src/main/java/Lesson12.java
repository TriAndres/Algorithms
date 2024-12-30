import java.io.*;

public class Lesson12 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // Чтение размера массива
            int N = Integer.parseInt(reader.readLine());
            int[] array = new int[N];

            // Чтение элементов массива
            String[] line = reader.readLine().split("\\s+");
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(line[i]);
            }

            // Чтение числа x
            int x = Integer.parseInt(reader.readLine());

            // Поиск ближайшего числа
            int closest = array[0];
            for (int i = 1; i < N; i++) {
                if (Math.abs(array[i] - x) < Math.abs(closest - x)) {
                    closest = array[i];
                }
            }

            // Вывод результата
            writer.write(String.valueOf(closest));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
