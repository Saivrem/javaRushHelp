package model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public record MockedStreams(ByteArrayOutputStream outputStream, PrintStream originalOut,
                            PrintStream customPrintStream) implements AutoCloseable {
    @Override
    public void close() throws Exception {
        customPrintStream.close();
        outputStream.close();
    }
}