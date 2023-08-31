package org.dustyRoom.tasks.syntax;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * task0710
 * <p>
 * 1. Создай список строк в методе main.
 * 2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
 * 3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
 */
public class CorrectOrder {
    public static void solution() {
        mySolution();
    }

    private static void mySolution() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0, scanner.nextLine());
        }
        list.forEach(System.out::println);
    }
}
