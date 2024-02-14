package org.dustyRoom.tasks.core;

import java.util.ArrayList;
import java.util.List;

/**
 * task1527
 * Для решения этой задачи тебе нужно:
 * Считать с консоли URL-ссылку.
 * Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например, lvl=15).
 * URL содержит минимум 1 параметр.
 * Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
 * Если присутствует параметр obj, то передать его значение в нужный метод alert():
 * alert(double value) - для чисел (не забывай о том, что число может быть дробным);
 * alert(String value) - для строк.
 * Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.
 * Пример 1
 * <p>
 * Ввод:
 * http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
 * <p>
 * Вывод:
 * lvl view name
 * <p>
 * Пример 2
 * <p>
 * Ввод:
 * http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
 * <p>
 * Вывод:
 * obj name
 * double: 3.14
 */
public class ParsingRequests {

    public static void solution(String url) {
        mySolution(url);
    }

    private static void mySolution(String url) {
        String[] params = url.split("\\?")[1].split("&");

        List<String> objects = new ArrayList<>();
        for (String param : params) {
            String[] split = param.split("=");
            if (split[0].equals("obj")) {
                objects.add(split[1]);
            }
            System.out.printf("%s ", split[0]);
        }
        System.out.println();
        for (String o : objects) {
            if (isDouble(o)) {
                alert(Double.parseDouble(o));
            } else {
                alert(o);
            }
        }
    }

    private static boolean isDouble(String test) {
        try {
            Double.parseDouble(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void alert(double value) {
        System.out.println("double: " + value);
    }

    private static void alert(String value) {
        System.out.println("String: " + value);
    }
}
