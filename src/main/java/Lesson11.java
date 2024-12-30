import java.io.*;
import java.util.HashMap;

public class Lesson11 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(reader.readLine().trim());
            HashMap<String, String> synonyms = new HashMap<>();

            // Считываем пары синонимов
            for (int i = 0; i < N; i++) {
                String[] line = reader.readLine().split("\\s+");
                String word1 = line[0];
                String word2 = line[1];
                synonyms.put(word1,word2);
                synonyms.put(word2,word1);
            }

            // Считываем слово для поиска синонима
            String query = reader.readLine().trim();
            // Находим и выводим синоним
            writer.write(synonyms.get(query));
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
