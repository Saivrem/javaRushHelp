package org.dustyRoom.tasks.syntax;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BaseIT;
import utils.ConsoleMock;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.stream.Stream;

class CorrectOrderIT extends BaseIT {

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
        Assertions.fail("Fail on purpose");
        try (ConsoleMock consoleMock = new ConsoleMock()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            consoleMock.mockSystemIn(mockedInputStream);
            consoleMock.mockSystemOut(outputStream);
            CorrectOrder.solution();

            Assertions.assertEquals(outputStream.toString(), expectedResult);
            LOG.debug("\nActual: {}\nExpected: {}",
                    toOneLine(outputStream.toString(), System.lineSeparator()),
                    toOneLine(expectedResult, System.lineSeparator())
            );
        }
    }
}