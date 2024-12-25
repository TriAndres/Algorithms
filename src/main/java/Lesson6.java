import java.io.*;
import java.util.HashSet;

public class Lesson6 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // Ввод доступных кнопок
            String[] input = reader.readLine().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);

            int N = Integer.parseInt(reader.readLine());

            // Создаем множество доступных кнопок
            HashSet<Integer> availableButtons = new HashSet<>();
            availableButtons.add(x);
            availableButtons.add(y);
            availableButtons.add(z);

            // Преобразуем число N в строку для проверки его цифр
            String numberStr = String.valueOf(N);
            HashSet<Integer> missingButtons = new HashSet<>();

            // Проверяем, какие кнопки нужны для ввода числа N
            for (char digit : numberStr.toCharArray()) {
                int digitValue = Character.getNumericValue(digit);
                if (!availableButtons.contains(digitValue)) {
                    missingButtons.add(digitValue);
                }
            }

            // Проверка на количество недостающих кнопок
            if (missingButtons.isEmpty()) {
                writer.write("0\n"); // Все кнопки для ввода N доступны
            } else {
                writer.write(missingButtons.size() + "\n"); // Количество недостающих кнопок
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
