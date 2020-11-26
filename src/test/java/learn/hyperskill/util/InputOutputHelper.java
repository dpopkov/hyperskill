package learn.hyperskill.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class InputOutputHelper {
    private PrintStream savedOut;
    private InputStream savedIn;

    public void setup(ByteArrayOutputStream outBuffer, byte[] inputBytes) {
        savedOut = System.out;
        savedIn = System.in;
        System.setOut(new PrintStream(outBuffer));
        System.setIn(new ByteArrayInputStream(inputBytes));
    }

    public void restore() {
        System.setOut(savedOut);
        System.setIn(savedIn);
    }
}
