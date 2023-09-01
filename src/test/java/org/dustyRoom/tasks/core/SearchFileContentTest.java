package org.dustyRoom.tasks.core;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BaseTest;
import utils.ConsoleMock;

import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

class SearchFileContentTest extends BaseTest {

    private static Stream<Arguments> testCases() {
        return readTestCases("test_files/search_file_content/test_cases.json")
                .stream()
                .map(node -> ofString(node, "id", "expected"));
    }


    @SneakyThrows
    @ParameterizedTest
    @MethodSource("testCases")
    public void shouldFindContentById(String id, String expected) {
        try (ConsoleMock consoleMock = new ConsoleMock()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            consoleMock.mockSystemOut(outputStream);
            consoleMock.mockSystemIn(getResourceInputStream("test_files/search_file_content/system_in.txt"));
            SearchFileContent.solution(id);
            Assertions.assertEquals(expected, outputStream.toString());
        }
    }
}