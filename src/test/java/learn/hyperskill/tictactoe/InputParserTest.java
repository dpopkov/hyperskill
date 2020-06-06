package learn.hyperskill.tictactoe;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class InputParserTest {

    @Test
    public void testParse() {
        InputParser parser = new InputParser(' ', '_');
        String input = "X_XOO__O_";
        char[][] expected = {
                {'X', ' ', 'X'},
                {'O', 'O', ' '},
                {' ', 'O', ' '}
        };
        char[][] result = parser.parse(input);
        assertThat(result, is(expected));
    }
}
