package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        new Task2().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            System.out.println("Введите число а:");//дополнительно
            long a = getNum(reader);
            System.out.println("Введите число b:");//дополнительно
            long b = getNum(reader);
            System.out.println("Введите число c:");//дополнительно
            long c = getNum(reader);
            System.out.println("Вывод:");//дополнительно
            if (action(a, b, c)) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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