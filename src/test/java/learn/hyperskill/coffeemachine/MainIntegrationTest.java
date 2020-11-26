package learn.hyperskill.coffeemachine;

import learn.hyperskill.util.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainIntegrationTest {
    private static final String NL = System.lineSeparator();
    private static final String INPUT_PROMPT = "> ";
    private static final List<String> commands = new ArrayList<>();
    private static String expectedOutput;

    private ByteArrayOutputStream buffer;
    private PrintStream savedOut;
    private InputStream savedIn;

    @BeforeAll
    static void setupInputOutput() throws Exception {
        expectedOutput = TestUtils.readInputOutput(MainIntegrationTest.class,
                "main-input-output.txt", INPUT_PROMPT, commands);
    }

    @BeforeEach
    public void setup() {
        buffer = new ByteArrayOutputStream();
        savedOut = System.out;
        System.setOut(new PrintStream(buffer));
        StringBuilder inputBuffer = new StringBuilder();
        for (String cmd : commands) {
            inputBuffer.append(cmd);
            inputBuffer.append(NL);
        }
        savedIn = System.in;
        System.setIn(new ByteArrayInputStream(inputBuffer.toString().getBytes()));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(savedOut);
        System.setIn(savedIn);
    }

    @Test
    void shouldGiveCorrectOutput() {
        Main.main(null);
        assertEquals(expectedOutput, buffer.toString());
    }
}
