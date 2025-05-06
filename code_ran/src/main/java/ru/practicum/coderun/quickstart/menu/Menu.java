package ru.practicum.coderun.quickstart.menu;

import ru.practicum.coderun.quickstart.task.*;

import java.util.Scanner;
import static ru.practicum.coderun.quickstart.menu.Menu.Tasks.from;

public class Menu {
    public void game() {
            String num = menu();
            select(num);
    }

    public String menu() {
        System.out.println("\tВыбирите действие:" +
                "\n\t1 - 1 задача" +
                "\n\t2 - 2 задача" +
                "\n\t3 - 3 задача" +
                "\n\t4 - 4 задача" +
                "\n\t5 - 5 задача" +
                "\n\t6 - 6 задача" +
                "\n\t7 - 7 задача" +
                "\n\t8 - 8 задача" +
                "\n\t9 - 9 задача" +
                "\n\t10 - 10 задача"
        );
        return new Scanner(System.in).next();
    }

    public void select(String num) {
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
            case TASK_6:
                new Task6().game();
                break;
            case TASK_7:
                new Task7().game();
                break;
            case TASK_8:
                new Task8().game();
                break;
            case TASK_9:
                new Task9().game();
                break;
            case TASK_10:
                new Task10().game();
                break;
            case null:
                break;
        }
    }

    enum Tasks {
        TASK_1, TASK_2, TASK_3, TASK_4, TASK_5, TASK_6, TASK_7, TASK_8, TASK_9, TASK_10;

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
                case "6":
                    return TASK_6;
                case "7":
                    return TASK_7;
                case "8":
                    return TASK_8;
                case "9":
                    return TASK_9;
                case "10":
                    return TASK_10;
                default:
                    return null;
            }
        }
    }
}