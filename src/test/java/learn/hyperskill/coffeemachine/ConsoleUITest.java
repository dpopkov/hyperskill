package learn.hyperskill.coffeemachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ConsoleUI должен")
class ConsoleUITest {
    private static final String NL = System.lineSeparator();

    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(buffer);

    @Test
    @DisplayName(" читать целочискленное число")
    void shouldReadInt() {
        UI console = new ConsoleUI(new ConsoleContext(out, input("42")));
        int actual = console.readInt("Enter number:");
        assertEquals(42, actual);
        assertPromptIs("Enter number:");
    }

    @Test
    @DisplayName(" читать строку")
    void shouldReadString() {
        UI console = new ConsoleUI(new ConsoleContext(out, input("test")));
        String actual = console.readString("Enter string:");
        assertEquals("test", actual);
        assertPromptIs("Enter string:");
    }

    private void assertPromptIs(String s) {
        assertEquals(s + NL + "> ", buffer.toString());
    }

    private ByteArrayInputStream input(String s) {
        return new ByteArrayInputStream((s + NL).getBytes());
    }
}
