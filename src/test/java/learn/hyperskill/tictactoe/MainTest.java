package learn.hyperskill.tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MainTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
        PrintStream saved = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));

        String expected = String.join(NL, "X O X", "O X O", "X X O", "");
        Main.main(null);
        System.setOut(saved);
        assertThat(buffer.toString(), is(expected));
    }
}
