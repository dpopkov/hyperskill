package learn.hyperskill.tictactoe;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class AnalyzerTest {
    private final Analyzer analyzer = new Analyzer('X', 'O');
    private final InputParser parser = new InputParser(' ', '_');

    @Test
    public void canFindHorizontalWinner() {
        assertThat(analyzer.findWinner(parser.parse("XXXOO__O_")), is('X'));
        assertThat(analyzer.findWinner(parser.parse("XX_OOO_O_")), is('O'));
    }

    @Test
    public void canDetectNoWinner() {
        assertThat(analyzer.findWinner(parser.parse("X_XOO__O_")), is(Analyzer.NONE));
        assertThat(analyzer.findWinner(parser.parse("XX__OO_O_")), is(Analyzer.NONE));
    }

    @Test
    public void canFindVerticalWinner() {
        assertThat(analyzer.findWinner(parser.parse("X_XXO_XO_")), is('X'));
        assertThat(analyzer.findWinner(parser.parse("XXOXOO__O")), is('O'));
    }

    @Test
    public void canFindDiagonalWinner() {
        assertThat(analyzer.findWinner(parser.parse("X_XOXO_OX")), is('X'));
        assertThat(analyzer.findWinner(parser.parse("X O OXOOX")), is('O'));
    }

    @Test
    public void canDetectStateXWins() {
        char[][] field = parser.parse("XXXOO__O_");
        assertThat(analyzer.findState(field), is("X wins"));
        field = parser.parse("XOXOXOXXO");
        assertThat(analyzer.findState(field), is("X wins"));
    }

    @Test
    public void canDetectStateOWins() {
        char[][] field = parser.parse("XOOOXOXXO");
        assertThat(analyzer.findState(field), is("O wins"));
    }

    @Test
    public void canDetectStateDraw() {
        char[][] field = parser.parse("XOXOOXXXO");
        assertThat(analyzer.findState(field), is("Draw"));
    }

    @Test
    public void canDetectStateNotFinished() {
        char[][] field = parser.parse("XO_OOX_X_");
        assertThat(analyzer.findState(field), is("Game not finished"));
    }

    @Test
    public void canDetectStateImpossible() {
        char[][] field = parser.parse("XO_XO_XOX");
        assertThat(analyzer.findState(field), is("Impossible"));
        field = parser.parse("_O_X__X_X");
        assertThat(analyzer.findState(field), is("Impossible"));
        field = parser.parse("_OOOO_X_X");
        assertThat(analyzer.findState(field), is("Impossible"));
    }
}
