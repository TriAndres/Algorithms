package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task5 extends Task {

    public static void main(String[] args) {
        new Task5().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
            String[] input;
            do {
                input = reader.readLine().split(" ");
            } while (isNumeric(input[0]) || isNumeric(input[1]) || isNumeric(input[2]) || input.length != 3);

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

    public void menu() {//дополнительно
        System.out.println("Введите:\n" +
                "Ввод: 1 -2 1\nВывод\n1\n1.000000\n" +
                "Ввод: 5 0 3\nВывод\n0\n" +
                "Ввод: 6 -5 -8\nВывод\n2\n-0810910 1.644243\n");
    }

    private static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}