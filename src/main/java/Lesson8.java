import java.io.*;

public class Lesson8 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = reader.readLine().split("\\s+");
            int[] numbers = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            if (flag(numbers)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean flag(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
