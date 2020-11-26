package learn.hyperskill.cinema;

import learn.hyperskill.util.InputOutputHelper;
import learn.hyperskill.util.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainPriceCalculatorIntegrationTest {
    private static final String NL = System.lineSeparator();
    public static final String INPUT_PROMPT = "> ";

    private final InputOutputHelper ioHelper = new InputOutputHelper();
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @ParameterizedTest
    @ValueSource(strings = {"sold-example-1.txt", "sold-example-2.txt", "sold-example-3.txt"})
    void testWithConsoleInputOutput(String testCaseFileName) throws IOException {
        List<String> input = new ArrayList<>();
        String expected = TestUtils.readInputOutput(MainPriceCalculatorIntegrationTest.class,
                testCaseFileName, INPUT_PROMPT, input);
        byte[] inputBytes = String.join(NL, input.toArray(new String[0])).getBytes();
        ioHelper.setup(buffer, inputBytes);

        Cinema.main(null);
        ioHelper.restore();

        assertEquals(expected, buffer.toString());
    }
}
