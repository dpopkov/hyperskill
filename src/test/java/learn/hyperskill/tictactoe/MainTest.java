package learn.hyperskill.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.io.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SuppressWarnings("SpellCheckingInspection")
public class MainTest {

    private static final String NL = System.lineSeparator();
    private static final String STATE_STUB = "end-of-test";
    public static final String NOT_FINISHED = "Game not finished";

    private PrintStream saveOut;
    private InputStream savedIn;
    private ByteArrayOutputStream buffer;
    private Analyzer analyzer;

    @Before
    public void setUp() {
        saveOut = System.out;
        savedIn = System.in;
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        analyzer = mock(Analyzer.class);
    }

    @After
    public void restore() {
        System.setOut(saveOut);
        System.setIn(savedIn);
    }

    @Test
    public void whenEnter11ThenSetsBottomLeftX() throws IOException {
        setInput("1 1", NL);
        String expected = String.join(NL,
                "---------",
                "|       |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "|       |",
                "|       |",
                "| X     |",
                "---------",
                STATE_STUB,
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(STATE_STUB);
        Main main = new Main(analyzer);
        main.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenEnter13ThenSetsUpperLeftX() throws IOException {
        setInput("1 3", NL);
        String expected = String.join(NL,
                "---------",
                "|       |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X     |",
                "|       |",
                "|       |",
                "---------",
                STATE_STUB,
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(STATE_STUB);
        Main main = new Main(analyzer);
        main.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenCellIsOccupideThenPrintMessage() throws IOException {
        setInput("1 1", NL, "1 1", NL, "1 3", NL);
        String expected = String.join(NL,
                "---------",
                "|       |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "|       |",
                "|       |",
                "| X     |",
                "---------",
                "Enter the coordinates: ",
                "This cell is occupied! Choose another one!",
                "Enter the coordinates: ",
                "---------",
                "| O     |",
                "|       |",
                "| X     |",
                "---------",
                STATE_STUB,
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class)))
                .thenReturn(NOT_FINISHED).thenReturn(STATE_STUB);
        Main main = new Main(analyzer);
        main.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenNotNumberThenPrintMessage() throws IOException {
        setInput("one", NL, "one three", NL, "1 3", NL);
        String expected = String.join(NL,
                "---------",
                "|       |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "You should enter numbers!",
                "Enter the coordinates: ",
                "You should enter numbers!",
                "Enter the coordinates: ",
                "---------",
                "| X     |",
                "|       |",
                "|       |",
                "---------",
                STATE_STUB,
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(STATE_STUB);
        Main main = new Main(analyzer);
        main.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenCourdinatesOutOfBoundsThenPrintMessage() throws IOException {
        setInput("4 1", NL, "1 4", NL, "1 3", NL);
        String expected = String.join(NL,
                "---------",
                "|       |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "Coordinates should be from 1 to 3!",
                "Enter the coordinates: ",
                "Coordinates should be from 1 to 3!",
                "Enter the coordinates: ",
                "---------",
                "| X     |",
                "|       |",
                "|       |",
                "---------",
                STATE_STUB,
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(STATE_STUB);
        Main main = new Main(analyzer);
        main.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void when3XInRowThenXWins() throws IOException {
        setInput("1 3", NL, "2 2", NL, "2 3", NL, "1 1", NL, "3 3", NL);
        String expected = String.join(NL,
                "---------",
                "|       |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X     |",
                "|       |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X     |",
                "|   O   |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X X   |",
                "|   O   |",
                "|       |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X X   |",
                "|   O   |",
                "| O     |",
                "---------",
                "Enter the coordinates: ",
                "---------",
                "| X X X |",
                "|   O   |",
                "| O     |",
                "---------",
                "X wins",
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class)))
                .thenReturn(NOT_FINISHED)
                .thenReturn(NOT_FINISHED)
                .thenReturn(NOT_FINISHED)
                .thenReturn(NOT_FINISHED)
                .thenReturn("X wins");  // WHY?
        Main main = new Main(analyzer);
        main.run();
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
