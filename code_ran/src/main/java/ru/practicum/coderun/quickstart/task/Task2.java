package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task2 extends Task {
    public static void main(String[] args) {
        new Task2().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
            long a = getNum(reader);
            long b = getNum(reader);
            long c = getNum(reader);

            if (action(a, b, c)) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {//дополнительно
        System.out.println("Введите:\n" +
                "Ввод:\n3\n4\n5\nВывод\nYES\n" +
                "Ввод:\n3\n5\n4\nВывод\nYES\n" +
                "Ввод:\n4\n5\n3\nВывод\nYES\n");
    }

    private boolean action(long a, long b, long c) {
        return a + b > c && b + c > a && c + a > b;
    }

    private long getNum(BufferedReader reader) {
        long num;
        while (true) {
            try {
                num = Long.parseLong(reader.readLine());
                break;
            } catch (IOException | NumberFormatException nfe) {
                System.out.println();
            }
        }
        return num;
    }
}