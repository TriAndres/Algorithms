package ru.practicum.coderun.quickstart.task;

import java.io.*;
import java.util.HashSet;

public class Task6 extends Task {
    public static void main(String[] args) {
        new Task6().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            menu();//дополнительно
            String[] input;
            do {
                input = reader.readLine().split("\\s+");
            } while (isNumeric(input[0]) || isNumeric(input[1]) || isNumeric(input[2]) || input.length != 3);
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            int N;
            while (true) {
                String num = reader.readLine();
                if (!isNumeric(num)) {
                    N = Integer.parseInt(num);
                    break;
                }
            }
            HashSet<Integer> availableButtons = new HashSet<>();
            availableButtons.add(x);
            availableButtons.add(y);
            availableButtons.add(z);

            String numberStr = String.valueOf(N);
            HashSet<Integer> missingButtons = new HashSet<>();

            for (char digit : numberStr.toCharArray()) {
                int digitValue = Character.getNumericValue(digit);
                if (!availableButtons.contains(digitValue)) {
                    missingButtons.add(digitValue);
                }
            }

            if (missingButtons.isEmpty()) {
                writer.write("0\n");
            } else {
                writer.write(missingButtons.size() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {//дополнительно
        System.out.println("Введите:\n" +
                "Ввод:\n1 2 3\n1123\nВывод\n0\n" +
                "Ввод:\n1 2 3\n1001\nВывод\n1\n" +
                "Ввод:\n5 7 3\n123\nВывод\n2\n");
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