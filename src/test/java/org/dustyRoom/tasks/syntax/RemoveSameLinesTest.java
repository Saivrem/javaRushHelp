package org.dustyRoom.tasks.syntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BaseTest;

import java.util.stream.Stream;

import static java.util.Arrays.copyOf;

class RemoveSameLinesTest extends BaseTest {

    private static Stream<Arguments> testCases() {
        return readTestCases("test_files/remove_duplicates/test_cases.json")
                .stream()
                .map(node -> ofArray(node, ",", true, "initial", "expected"));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void removeSameStrings(String[] initialState, String[] endState) {
        String[] testArray = copyOf(initialState, initialState.length);
        RemoveSameLines.solution(testArray);
        Assertions.assertArrayEquals(testArray, endState);
    }
}