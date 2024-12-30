import java.io.*;

public class Lesson13 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // Чтение количества элементов
            int N = Integer.parseInt(reader.readLine().trim());
            String[] line = reader.readLine().split("\\s++");
            int[] sequence = new int[N];

            // Заполнение массива последовательности
            for (int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(line[i]);
            }

            // Получение результата
            Result result = makeSymmetricSequence(sequence);

            // Запись результата
            writer.write(result.M + "\n");
            if (result.M > 0) {
                for (int num : result.numbersToAdd) {
                    writer.write(num + " ");
                }
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Result makeSymmetricSequence(int[] seq) {
        int n = seq.length;
        // Проверка на симметричность
        if (isSymmetric(seq)) {
            return new Result(0, new int[0]);
        }

        // Поиск минимального количества добавляемых элементов
        for (int i = 0; i < n; i++) {
            if (isSuffixSymmetric(seq, i)) {
                int[] numbersToAdd = new int[i];
                for (int j = 0; j < i; j++) {
                   numbersToAdd[j] = seq[j];
                }
                return new Result(n, numbersToAdd);
            }
        }
        // Если не нашли совпадений, добавляем всю последовательность в обратном порядке
        int[] numbersToAdd = new int[n];
        for (int i = 0; i < n; i++) {
            numbersToAdd[i] = seq[n - 1 - i];
        }
        return new Result(n, numbersToAdd);
    }

    private static boolean isSymmetric(int[] seq) {
        int n = seq.length;
        for (int i = 0; i < n / 2; i++) {
            if (seq[i] != seq[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSuffixSymmetric(int[] seq, int start) {
        int n = seq.length;
        for (int i = 0; i < n - start; i++) {
            if (seq[start + i] != seq[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // Класс для хранения результата
    static class Result {
        int M;
        int[] numbersToAdd;

        public Result(int m, int[] numbersToAdd) {
            M = m;
            this.numbersToAdd = numbersToAdd;
        }
    }
}