package ru.practicum.coderun.quickstart.menu;

import ru.practicum.coderun.quickstart.task.*;

import java.util.Scanner;

import static ru.practicum.coderun.quickstart.menu.Menu.Tasks.from;

public class Menu {
    public void game() {
        while (true) {
            String num = menu();
            select(num);
            if (num.equals("0")) break;
        }
    }

    private String menu() {
        System.out.println("\tВыбирите действие:" +
                "\n\t1 - 1 задача" +
                "\n\t2 - 2 задача" +
                "\n\t3 - 3 задача" +
                "\n\t4 - 4 задача" +
                "\n\t5 - 5 задача"
        );
        return new Scanner(System.in).next();
    }

    private void select(String num) {
        switch (from(num)) {
            case TASK_1:
                new Task1().game();
                break;
            case TASK_2:
                new Task2().game();
                break;
            case TASK_3:
                new Task3().game();
                break;
            case TASK_4:
                new Task4().game();
                break;
            case TASK_5:
                new Task5().game();
                break;
            case NULL:
                System.out.println("Выход из программы");
                break;
            case null:
                break;
        }
    }

    enum  Tasks{
        TASK_1, TASK_2, TASK_3, TASK_4, TASK_5, NULL;

        public static Tasks from(String num) {
            switch (num) {
                case "1":
                    return TASK_1;
                case "2":
                    return TASK_2;
                case "3":
                    return TASK_3;
                case "4":
                    return TASK_4;
                case "5":
                    return TASK_5;
                case "0":
                    return NULL;
                default:
                    return null;
            }
        }
    }
}