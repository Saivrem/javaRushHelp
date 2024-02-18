package org.dustyRoom.tasks.core;

import java.util.*;

public class ParsingTags {

    private final static String input = """
            Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
            </span></b></span><span>Super</span><span>girl</span>
            <span field="testField">test<span>AnotherTest<span>thirdTest</span></span></span>
            """;

    private final static String tag = "span";

    public static void main(String[] args) {
        String filteredInput = input.replaceAll("[\n\r]", "");
        String startTag = "<" + tag;
        String endTag = "</" + tag + ">";

        Stack<Integer> startIndexes = new Stack<>();
        Map<Integer, Integer> indexPairs = new TreeMap<>();

        StringBuilder builder = new StringBuilder();
        int currentTagStart = 0;
        boolean readingTag = false;
        for (int i = 0; i < filteredInput.length(); i++) {
            char currentChar = filteredInput.charAt(i);

            if (currentChar == '<') {
                readingTag = true;
                currentTagStart = i;
            }
            if (currentChar == '>') {
                readingTag = false;
                String tagString = builder.append(currentChar).toString();
                builder = new StringBuilder();

                if (tagString.startsWith(startTag)) {
                    startIndexes.push(currentTagStart);
                }

                if (tagString.equals(endTag)) {
                    Integer start = startIndexes.pop();
                    indexPairs.put(start, i+1);
                }
            }
            if (readingTag) {
                builder.append(currentChar);
            }
        }

        indexPairs.forEach((key, value) -> System.out.println(filteredInput.substring(key, value)));
    }
}
