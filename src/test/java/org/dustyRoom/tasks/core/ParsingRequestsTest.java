package org.dustyRoom.tasks.core;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BaseIT;
import utils.ConsoleMock;

import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

class ParsingRequestsTest extends BaseIT {

    private static Stream<Arguments> testCases() {
        return readTestCases("test_files/parsing_url_params/test_cases.json")
                .stream()
                .map(node -> ofString(node, "url", "output"));
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("testCases")
    void shouldPrintCorrectArguments(String url, String expectedOutput) {
        try (ConsoleMock consoleMock = new ConsoleMock()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            consoleMock.mockSystemOut(outputStream);
            ParsingRequests.solution(url);
            String expected = expectedOutput.replaceAll("[\r\n]", "");
            String actual = outputStream.toString().replaceAll("[\r\n]", "");
            Assertions.assertEquals(expected, actual);
        }
    }
}