package ru.practicum.coderun.quickstart.task;

import java.io.*;

public class Task8 extends Task {
    public static void main(String[] args) {
        new Task8().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
            String[] input;
            do {
                input = reader.readLine().split("\\s+");
            } while (isNumeric(input[0]) || isNumeric(input[1]) || isNumeric(input[2]) || input.length != 3);

            int[] numbers = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            if (flag(numbers)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {//дополнительно
        System.out.println("Введите:\n" +
                "Ввод:\n1 7 9\nВывод\nYES\n" +
                "Ввод:\n1 9 7\nВывод\nNO\n" +
                "Ввод:\n2 2 2\nВывод\nNO\n");
    }

    private static boolean flag(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        return true;
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