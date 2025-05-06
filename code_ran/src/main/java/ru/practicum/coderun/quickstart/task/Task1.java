package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task1 extends Task {
    public static void main(String[] args) {
        new Task1().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
            long sum = 0;
            String[] parts;
            do {
                parts = reader.readLine().split("\\s+");
            } while ((isNumeric(parts[0]) || isNumeric(parts[1])) || parts.length != 2);

            for (String part : parts) {
                long num = Long.parseLong(part);
                sum += num;
            }
            System.out.print("Вывод:\n");//дополнительно
            writer.write(String.valueOf(sum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() { //дополнительно
        System.out.println("Введите:\n" +
                "Ввод:\n1 1\nВывод\n2\n" +
                "Ввод:\n4 1\nВывод\n5\n" +
                "Ввод:\n1 3\nВывод\n4\n");
    }

    public static boolean isNumeric(String str) {
        try {
            boolean d = Long.parseLong(str) > 0;
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}