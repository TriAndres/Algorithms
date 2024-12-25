import java.io.*;

public class Lesson5 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            double D = b * b - 4 * a * c;

            if (D > 0) {
                double x1 = (-b - Math.sqrt(D)) / (2 * a);
                double x2 = (-b + Math.sqrt(D)) / (2 * a);
                if (x1 > x2) {
                    double temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                writer.write("2\n");
                writer.write(String.format("%.6f %.6f\n", x1, x2));
            } else if (D == 0) {
                double x = -b / (2.0 * a);
                writer.write("1\n");
                writer.write(String.format("%.6f\n", x));
            } else {
                writer.write("0\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}