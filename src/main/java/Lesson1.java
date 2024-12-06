import java.io.*;

public class Lesson1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long sum = 0;
            String[] parts;
            do {
                parts = reader.readLine().split("\\s+");
            } while (parts.length != 2 || Long.parseLong(parts[0]) < 0 || Long.parseLong(parts[1]) < 0);
            for (String part : parts) {
                long num = Long.parseLong(part);
                sum += num;
            }
            writer.write(String.valueOf(sum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}