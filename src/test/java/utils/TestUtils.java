package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestUtils {
    protected static Logger LOG = log;
    private final static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    protected static List<JsonNode> readTestParams(String path) {
        try (InputStream is = getResourceInputStream(path)) {
            return objectMapper.readValue(is, new TypeReference<>() {
            });
        }
    }

    protected static InputStream getResourceInputStream(String path) {
        return TestUtils.class.getClassLoader().getResourceAsStream(path);
    }

    /**
     * Accurately reads file content into memory as string. Assertions helper
     * @param path path to file to read
     * @return String value of file content
     */
    protected static String readFileAsString(String path) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getResourceInputStream(path)))) {
            while (reader.ready()) {
                result.append(reader.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            return null;
        }
        return result.toString();
    }

    /**
     * Split text value of JsonNode with passed delimiter, can convert string values of null into actual nulls
     * @param node JsonNode, meant to be text-value node with some delimiter
     * @param delimiter delimiter to split text into array
     * @param convertNulls boolean represents if "null" should be converted to null
     * @return Array of strings
     */
    protected static String[] jsonNodeToArray(JsonNode node, String delimiter, boolean convertNulls) {
        if (node == null) return null;
        return Arrays.stream(node.asText().split(delimiter))
                .map(e -> {
                    if (convertNulls && e.equalsIgnoreCase("null")) {
                        e = null;
                    }
                    return e;
                })
                .toArray(String[]::new);
    }

    protected static String toOneLine(String in, String delimiter) {
        return String.join(", ", in.split(delimiter));
    }
}
