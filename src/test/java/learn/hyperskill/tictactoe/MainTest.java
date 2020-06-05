package learn.hyperskill.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    public void whenEnter11ThenSetsBottomLeftX() throws IOException {
        setInput("X_X_O____", NL, "1 1", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "| X   X |",
                "|   O   |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X   X |",
                "|   O   |",
                "| X     |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenEnter13ThenSetsUpperLeftX() throws IOException {
        setInput("_XXOO_OX_", NL, "1 3", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenEnter31ThenSetsBottomRightX() throws IOException {
        setInput("_XXOO_OX_", NL, "3 1", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X X |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenEnter32ThenSetsMiddleRightX() throws IOException {
        setInput("_XXOO_OX_", NL, "3 2", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "|   X X |",
                "| O O X |",
                "| O X   |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenCellIsOccupideThenPrintMessage() throws IOException {
        setInput("_XXOO_OX_", NL, "1 1", NL, "1 3", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "Enter the coordinates: ",
                "This cell is occupied! Choose another one!",
                "Enter the coordinates: ",
                "---------",
                "| X X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenNotNumberThenPrintMessage() throws IOException {
        setInput("_XXOO_OX_", NL, "one", NL, "one three", NL, "1 3", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "Enter the coordinates: ",
                "You should enter numbers!",
                "Enter the coordinates: ",
                "You should enter numbers!",
                "Enter the coordinates: ",
                "---------",
                "| X X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenCourdinatesOutOfBoundsThenPrintMessage() throws IOException {
        setInput("_XXOO_OX_", NL, "4 1", NL, "1 4", NL, "1 3", NL);
        String expected = String.join(NL,
                "Enter cells: ",
                "---------",
                "|   X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "Enter the coordinates: ",
                "Coordinates should be from 1 to 3!",
                "Enter the coordinates: ",
                "Coordinates should be from 1 to 3!",
                "Enter the coordinates: ",
                "---------",
                "| X X X |",
                "| O O   |",
                "| O X   |",
                "---------",
                "");
        Main.main(null);
        assertThat(buffer.toString(), is(expected));
    }

    private void setInput(String... inputs) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (String input : inputs) {
            baos.write(input.getBytes());
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        System.setIn(bais);
    }
}
