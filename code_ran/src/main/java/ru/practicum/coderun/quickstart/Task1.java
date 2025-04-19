package ru.practicum.coderun.quickstart;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        new Task1().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
            System.out.println("Ввод:\nпример ввода: 1 1");//дополнительно
            long sum = 0;
            String[] parts;
            do {
                parts = reader.readLine().split("\\s+");
            } while ( (isNumeric(parts[0]) || isNumeric(parts[1])) ||  parts.length != 2);
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

    private static boolean isNumeric(String str) {
        try {
            boolean d = Long.parseLong(str) > 0;
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}