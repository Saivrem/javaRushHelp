package org.dustyRoom.tasks.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * task1804 Java core
 * Ввести с консоли имя файла.
 * Найти байт или байты с минимальным количеством повторов.
 * Вывести их на экран через пробел.
 * Закрыть поток ввода-вывода.
 */
public class LeastFrequentBytes {

    public static void solution() {
        mySolution();
    }

    private static void mySolution() {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try (InputStream inputStream = new FileInputStream(fileName)) {
            int[] bytes = new int[256];
            while (inputStream.available() > 0) {
                bytes[inputStream.read()]++;
            }
            int min = 256;
            for (int aByte : bytes) {
                if (aByte != 0) {
                    min = Math.min(min, aByte);
                }
            }
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == min) {
                    System.out.printf("%d ", i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
