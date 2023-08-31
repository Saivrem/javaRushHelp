package org.dustyRoom.tasks.syntax;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class RemoveSameLines {

    public static void solution(String[] lines) {
        mySolution(lines);
    }
    private static void mySolution(String[] lines) {
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
}
