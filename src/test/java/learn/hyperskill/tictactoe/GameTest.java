package learn.hyperskill.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.io.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SuppressWarnings("SpellCheckingInspection")
public class GameTest {

    private static final String NL = System.lineSeparator();

    private ByteArrayOutputStream buffer;
    private PrintStream bufferPrintStream;
    private Analyzer analyzer;
    private InputStream inputStream;

    @Before
    public void setUp() {
        buffer = new ByteArrayOutputStream();
        bufferPrintStream = new PrintStream(buffer);
        analyzer = mock(Analyzer.class);
    }

    private void prepareInput(String... inputs) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (String input : inputs) {
            baos.write(input.getBytes());
        }
        inputStream = new ByteArrayInputStream(baos.toByteArray());
    }

    @Test
    public void whenEnter11ThenSetsBottomLeftX() throws IOException {
        prepareInput("1 1", NL);
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
                State.X_WINS.message(),
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(State.X_WINS);
        Game game = new Game(analyzer, inputStream, bufferPrintStream);
        game.run();

        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenEnter13ThenSetsUpperLeftX() throws IOException {
        prepareInput("1 3", NL);
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
                State.X_WINS.message(),
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(State.X_WINS);
        Game game = new Game(analyzer, inputStream, bufferPrintStream);
        game.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenCellIsOccupideThenPrintMessage() throws IOException {
        prepareInput("1 1", NL, "1 1", NL, "1 3", NL);
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
                State.X_WINS.message(),
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class)))
                .thenReturn(State.NOT_FINISHED).thenReturn(State.X_WINS);
        Game game = new Game(analyzer, inputStream, bufferPrintStream);
        game.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenNotNumberThenPrintMessage() throws IOException {
        prepareInput("one", NL, "one three", NL, "1 3", NL);
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
                State.X_WINS.message(),
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(State.X_WINS);
        Game game = new Game(analyzer, inputStream, bufferPrintStream);
        game.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void whenCourdinatesOutOfBoundsThenPrintMessage() throws IOException {
        prepareInput("4 1", NL, "1 4", NL, "1 3", NL);
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
                State.X_WINS.message(),
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class))).thenReturn(State.X_WINS);
        Game game = new Game(analyzer, inputStream, bufferPrintStream);
        game.run();
        assertThat(buffer.toString(), is(expected));
    }

    @Test
    public void when3XInRowThenXWins() throws IOException {
        prepareInput("1 3", NL, "2 2", NL, "2 3", NL, "1 1", NL, "3 3", NL);
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
                State.X_WINS.message(),
                "");
        when(analyzer.findState(ArgumentMatchers.any(char[][].class)))
                .thenReturn(State.NOT_FINISHED)
                .thenReturn(State.NOT_FINISHED)
                .thenReturn(State.NOT_FINISHED)
                .thenReturn(State.NOT_FINISHED)
                .thenReturn(State.X_WINS);
        Game game = new Game(analyzer, inputStream, bufferPrintStream);
        game.run();
        assertThat(buffer.toString(), is(expected));
    }
}
