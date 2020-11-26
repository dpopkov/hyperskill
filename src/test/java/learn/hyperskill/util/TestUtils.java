package learn.hyperskill.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;

public class TestUtils {
    private static final String NL = System.lineSeparator();

    /**
     * Reads the specified file that should contain text of a console test case.
     * @param testClass instance of class that contains tests (for locating test case resource file)
     * @param testCaseFileName test case resource file name
     * @param inputPrompt prompt used when console input from user is expected
     * @param input list that will collect commands typed by user after input prompt
     * @return the expected output of the tested program
     * @throws IOException when reading error
     */
    public static String readInputOutput(Class<?> testClass, String testCaseFileName,
                                         String inputPrompt, List<String> input)
            throws IOException {
        Objects.requireNonNull(input);
        try (InputStream in = testClass.getResourceAsStream(testCaseFileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            assertNotNull(in);
            StringBuilder builder = new StringBuilder();
            final int inputPromptLength = inputPrompt.length();
            reader.lines()
                    .map(s -> {
                        if (s.startsWith(inputPrompt)) {
                            input.add(s.substring(inputPromptLength));
                            return s.substring(0, inputPromptLength);
                        } else {
                            return s;
                        }
                    })
                    .forEach((s) -> {
                        builder.append(s);
                        if (s.length() > inputPromptLength || s.isEmpty()) {
                            builder.append(NL);
                        }
                    });
            return builder.toString();
        }
    }
}
