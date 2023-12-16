package org.dustyRoom.tasks.syntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BaseIT;

import java.util.stream.Stream;

import static org.dustyRoom.tasks.syntax.Defragmentation.executeDefragmentation;

public class DefragmentationTest extends BaseIT {

    private static Stream<Arguments> testCases() {
        return readTestCases("test_files/defragmentation/test_cases.json")
                .stream()
                .map(jsonNode -> ofArray(jsonNode, ",", true, "memory", "expected"));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void shouldExecuteDefragmentation(String[] memory, String[] expected) {
        executeDefragmentation(memory);

        Assertions.assertArrayEquals(memory, expected);
    }
}