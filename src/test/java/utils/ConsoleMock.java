package utils;

import lombok.experimental.UtilityClass;
import model.MockedStreams;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@UtilityClass
public class ConsoleMock {

    public MockedStreams mockSystemOut() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        PrintStream originalSystemOut = System.out;
        System.setOut(customPrintStream);
        return new MockedStreams(outputStream, originalSystemOut, customPrintStream);
    }

    public InputStream mockSystemIn(InputStream in) {
        InputStream originalIn = System.in;
        System.setIn(in);
        return originalIn;
    }

    public void restoreStreams(InputStream originalIn, PrintStream originalOut) {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
