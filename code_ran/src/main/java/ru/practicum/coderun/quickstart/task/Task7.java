package ru.practicum.coderun.quickstart.task;

import java.io.*;
import java.util.HashSet;

public class Task7 {
    public static void main(String[] args) {
        new Task7().game();
    }

    public void game() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            HashSet<String> uniqueWords = new HashSet<>();

            System.out.println("Введите:\n" +
                    "Ввод:\nS" +
                    "he sells sea shells on the sea shore;\n" +
                    "The shells that she sells are sea shells I'm sure.\n" +
                    "So if she sells sea shells on the sea shore,\n" +
                    "I'm sure that the shells are sea shore shells.\n" +
                    "Вывод\n" +
                    "19\n" +
                    "Ввод\n" +
                    "AA aa Aa aA\n" +
                    "Вывод\n" +
                    "4\n" +
                    "Ввод\n" +
                    "a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a\n" +
                    "Вывод\n" +
                    "1\n");//дополнительно

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word);
                    }
                }
            }

            writer.write(String.valueOf(uniqueWords.size()));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}