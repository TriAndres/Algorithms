import java.io.*;

public class Lesson4 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            int[] t = new int[n + 1];
            t[1] = 1;
            if (n >= 2) {
                t[2] = 1;
            }
            for (int i = 3; i <= n; i++) {
                t[i] = t[i - 1] + t[i - 2];
            }
            int totalTags = 0;
            for (int i = 1; i <= n; i++) {
                totalTags += t[i];
            }
            writer.write(String.valueOf(totalTags));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}