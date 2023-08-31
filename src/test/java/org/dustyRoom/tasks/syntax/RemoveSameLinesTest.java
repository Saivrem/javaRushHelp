package org.dustyRoom.tasks.syntax;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TestUtils;

import java.util.stream.Stream;

import static java.util.Arrays.copyOf;

class RemoveSameLinesTest extends TestUtils {

    private static Stream<Arguments> argsProvider() {
        return readTestParams("test_files/remove_duplicates/remove_duplicates.json")
                .stream()
                .map(node -> Arguments.of(prepareArgs(node.get("initial")), prepareArgs(node.get("expected"))));
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    public void removeSameStrings(String[] initialState, String[] endState) {
        String[] testArray = copyOf(initialState, initialState.length);
        RemoveSameLines.solution(testArray);
        Assertions.assertArrayEquals(testArray, endState);
    }

    private static String[] prepareArgs(JsonNode node) {
        return jsonNodeToArray(node, ",", true);
    }
}