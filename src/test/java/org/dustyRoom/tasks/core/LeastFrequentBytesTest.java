package org.dustyRoom.tasks.core;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BaseIT;
import utils.ConsoleMock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.stream.Stream;

class LeastFrequentBytesTest extends BaseIT {

    private static Stream<Arguments> testCases() {
        return readTestCases("test_files/least_frequent_byte/test_cases.json")
                .stream()
                .map(node -> ofString(node, "inputFile", "expectedResult"));
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("testCases")
    public void shouldPrintMinimalBytes(String inputStreamMock, String expectedResult) {
        try (ConsoleMock consoleMock = new ConsoleMock()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            consoleMock.mockSystemIn(new ByteArrayInputStream(inputStreamMock.getBytes()));
            consoleMock.mockSystemOut(outputStream);
            LeastFrequentBytes.solution();
            Assertions.assertEquals(outputStream.toString().trim(), expectedResult);
            consoleMock.close();
            printCharsMap(outputStream);
        }
    }

    private static void printCharsMap(ByteArrayOutputStream outputStream) {
        Arrays.stream(outputStream.toString().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(c -> LOG.debug("Char {}, Value {}}", c, (char) c));
    }
}