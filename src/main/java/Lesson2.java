import java.io.*;

public class Lesson2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long a = Long.parseLong(reader.readLine());
            long b = Long.parseLong(reader.readLine());
            long c = Long.parseLong(reader.readLine());
            if (a + b > c && b + c > a && c + a > b) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
