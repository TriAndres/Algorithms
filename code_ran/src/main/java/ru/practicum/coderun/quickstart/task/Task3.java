package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task3 extends Task {
    public static void main(String[] args) {
        new Task3().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
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
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {//дополнительно
        System.out.println("Введите:\n" +
                "Ввод: 1 2 3 4 5 Вывод 0\n" +
                "Ввод: 5 4 3 2 1 Вывод 0\n" +
                "Ввод: 1 5 1 5 1 Вывод 2");
    }
}