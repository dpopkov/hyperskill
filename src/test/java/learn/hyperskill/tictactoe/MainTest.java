package learn.hyperskill.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class MainTest {

    private static final String NL = System.lineSeparator();

    private PrintStream saveOut;
    private InputStream savedIn;
    private ByteArrayOutputStream buffer;

    @Before
    public void setUp() {
        saveOut = System.out;
        savedIn = System.in;
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
    }

    @After
    public void restore() {
        System.setOut(saveOut);
        System.setIn(savedIn);
    }

    @Test
    public void testExample1() {
        setInput("O_OXXO_XX");
        String expected = String.join(NL, "---------",
                "| O _ O |",
                "| X X O |",
                "| _ X X |",
                "---------",
                "Game not finished",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void testExample2() {
        setInput("OXO__X_OX");
        String expected = String.join(NL, "---------",
                "| O X O |",
                "| _ _ X |",
                "| _ O X |",
                "---------",
                "Game not finished",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void testExample3() {
        setInput("_XO__X___");
        String expected = String.join(NL, "---------",
                "| _ X O |",
                "| _ _ X |",
                "| _ _ _ |",
                "---------",
                "Game not finished",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
