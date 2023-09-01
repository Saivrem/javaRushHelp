package utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class ConsoleMock implements AutoCloseable {
    private final static InputStream originalSystemIn = System.in;
    private final static PrintStream originalSystemOut = System.out;
    private PrintStream printStream;
    private InputStream customSystemIn;


    public void mockSystemOut(ByteArrayOutputStream outputStream) {
        printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    public void mockSystemIn(InputStream in) {
        customSystemIn = in;
        System.setIn(in);
    }

    @Override
    public void close() throws Exception {
        if (printStream != null) {
            printStream.close();
        }
        if (customSystemIn != null) {
            customSystemIn.close();
        }
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
}
