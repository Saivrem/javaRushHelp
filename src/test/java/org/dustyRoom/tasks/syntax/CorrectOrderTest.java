package org.dustyRoom.tasks.syntax;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import model.MockedStreams;
import utils.ConsoleMock;
import utils.BaseTest;

import java.io.InputStream;
import java.util.stream.Stream;

class CorrectOrderTest extends BaseTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        Named.of("OneToTen", getResourceInputStream("test_files/correct_order/in.txt")),
                        Named.of("TenToOne", readFileAsString("test_files/correct_order/out.txt"))
                )
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("testCases")
    public void correctOrder(InputStream mockedInputStream, String expectedResult) {
        try (MockedStreams mockedStreams = ConsoleMock.mockSystemOut()) {
            InputStream originalIn = ConsoleMock.mockSystemIn(mockedInputStream);

            CorrectOrder.solution();

            ConsoleMock.restoreStreams(originalIn, mockedStreams.originalOut());
            mockedInputStream.close();

            Assertions.assertEquals(mockedStreams.outputStream().toString(), expectedResult);
            LOG.debug("\nActual: {}\nExpected: {}",
                    toOneLine(mockedStreams.outputStream().toString(), System.lineSeparator()),
                    toOneLine(expectedResult, System.lineSeparator())
            );
        }
    }
}