package org.dustyRoom.tasks.syntax;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * task0508
 * <p>
 * В этой задаче тебе нужно:
 * <p>
 * Считать 6 строк и заполнить ими массив strings.
 * Удалить повторяющиеся строки из массива strings, заменив их на null (null должны быть не строками "null").
 */
@Slf4j
public class RemoveSameLines {

    public static void solution(String[] lines) {
        flagSolution(lines);
    }

    //TODO found task description, update test and solution
    private static void tempVarSolution(String[] lines) {
        log.debug("Initial state: {}", Arrays.toString(lines));
        for (int i = 0; i < lines.length; i++) {
            String current = lines[i];
            if (current == null) continue;
            for (int j = i + 1; j < lines.length; j++) {
                if (current.equalsIgnoreCase(lines[j])) {
                    lines[i] = null;
                    lines[j] = null;
                }
            }
        }
        log.debug("Modified array: {}", Arrays.toString(lines));
    }

    private static void flagSolution(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == null) {
                continue;
            }
            boolean found = false;
            for (int j = i + 1; j < lines.length; j++) {
                if (lines[i].equals(lines[j])) {
                    lines[j] = null;
                    found = true;
                }
            }
            if (found) {
                lines[i] = null;
            }
        }
    }
}
