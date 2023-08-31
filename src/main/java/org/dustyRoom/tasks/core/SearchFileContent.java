package org.dustyRoom.tasks.core;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Поиск данных внутри файла task1822
 * <p>
 * Считать с консоли имя файла.
 * Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
 * Программа запускается с одним параметром: id (int).
 * Закрыть потоки.
 * <p>
 * В файле данные разделены пробелом и хранятся в следующей последовательности:
 * id productName price quantity
 * где id - int.
 * productName - название товара, может содержать пробелы, String.
 * price - цена, double.
 * quantity - количество, int.
 * <p>
 * Информация по каждому товару хранится в отдельной строке.
 * <p>
 * Пример содержимого файла:
 * 194 хлеб 12.6 25
 * 195 масло сливочное 52.2 12
 * 196 молоко 22.9 19
 * <p>
 * - Программа должна считать имя файла с консоли.
 * - В методе main создай для файла поток для чтения.
 * - Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
 * - Поток для чтения из файла должен быть закрыт.
 */

@Slf4j
public class SearchFileContent {

    public static void solution(String... args) {
        mySolution(args);
    }

    private static void mySolution(String... args) {
        String id = args[0];
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] split = line.split(" ");
                if (split[0].equalsIgnoreCase(id)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            log.error("Can't read the file", e);
        }
    }
}
