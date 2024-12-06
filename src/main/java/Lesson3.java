import java.io.*;

public class Lesson3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = reader.readLine();
            String[] numbers = input.split(" ");
            int count = 0;
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    count++;
                }
            }
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}