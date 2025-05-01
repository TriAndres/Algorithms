package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task4 extends Task {
    public static void main(String[] args) {
        new Task4().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
            int n;
            while (true){
                String line = reader.readLine();
                if (!isNumeric(line)) {
                    n = Integer.parseInt(line);
                    if (n > 0) break;
                }
            }
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

    public void menu() {//дополнительно
        System.out.println("Введите:\n" +
                "Ввод: 32 Вывод 5702886\n" +
                "Ввод: 21 Вывод 28656\n" +
                "Ввод: 33 Вывод 9227464");
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