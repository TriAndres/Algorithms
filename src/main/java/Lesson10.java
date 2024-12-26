import java.io.*;

public class Lesson10 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] numbers = reader.readLine().split("\\s+");
            long a = Long.parseLong(numbers[0]);
            long b = Long.parseLong(numbers[1]);
            // Вычисление НОД
            long gcdValue = gcd(a, b);
            // Вычисление НОК
            long lcmValue = lcm(a, b, gcdValue);
            // Вывод результата
            writer.write(gcdValue + " " + lcmValue);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для вычисления НОД с использованием алгоритма Евклида
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для вычисления НОК
    private static long lcm(long a, long b, long gcdValue) {
        return (a / gcdValue) * b;
    }
}