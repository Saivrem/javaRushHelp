package org.dustyRoom.tasks.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 0811
 * Собираем файл из кусочков.
 * Считывать с консоли имена файлов.
 * Каждый файл имеет имя: [someName].partN.
 * <p>
 * Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
 * <p>
 * Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
 * В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
 * <p>
 * Например, Lion.avi.
 * <p>
 * В него переписать все байты из файлов-частей используя буфер.
 * Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
 * Закрыть потоки.
 */

//TODO add Tests
public class CompileFile {

    private final static String END = "end";

    private final static String suffix = ".part";

    public static void solution() {
        mySolution();
    }

    public static void mySolution() {
        List<String> fileParts = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        while (console.hasNextLine()) {
            String line = console.nextLine();
            if (END.equals(line)) {
                break;
            }
            fileParts.add(line);
        }

        String fileName = fileParts.get(0);
        fileName = fileName.substring(0, fileName.lastIndexOf(".part"));

        try (OutputStream os = new FileOutputStream(fileName)) {
            fileParts.stream()
                    .sorted(Comparator.comparingInt(CompileFile::extractPartNumber))
                    .forEach(part -> write(part, os));
        } catch (IOException ignore) {
        }
    }

    private static void write(String file, OutputStream os) {
        try (InputStream is = new FileInputStream(file)) {
            byte[] buff = new byte[65535];
            int bytesRead;
            while ((bytesRead = is.read(buff)) != -1) {
                os.write(buff, 0, bytesRead);
            }
        } catch (IOException ignored) {
        }
    }

    private static Integer extractPartNumber(String file) {
        return Integer.parseInt(file.substring(file.lastIndexOf(suffix) + suffix.length()));
    }
}
