import java.io.*;

public class Lesson20 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] line = reader.readLine().split("\\s++");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
