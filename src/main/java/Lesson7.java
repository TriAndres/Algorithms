import java.io.*;
import java.util.HashSet;

public class Lesson7 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // Используем HashSet для хранения уникальных слов
            HashSet<String> uniqueWords = new HashSet<>();

            String line;
            // Читаем текст построчно
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                // Разделяем строку на слова
                String[] words = line.split("\\s+"); // Разделяем по пробелам
                // Добавляем слова в HashSet
                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word);
                    }
                }
            }

            // Выводим количество уникальных слов
            writer.write(String.valueOf(uniqueWords.size()));
            writer.newLine();
            writer.flush(); // Сбрасываем буфер
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
