package learn.hyperskill.tictactoe;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class AnalyzerTest {
    private final Analyzer analyzer = new Analyzer('X', 'O');

    @Test
    public void canFindHorizontalWinner() {
        assertThat(analyzer.findWinner(Main.parseInput("XXXOO__O_")), is('X'));
        assertThat(analyzer.findWinner(Main.parseInput("XX_OOO_O_")), is('O'));
    }

    @Test
    public void canDetectNoWinner() {
        assertThat(analyzer.findWinner(Main.parseInput("X_XOO__O_")), is(Analyzer.NONE));
        assertThat(analyzer.findWinner(Main.parseInput("XX__OO_O_")), is(Analyzer.NONE));
    }

    @Test
    public void canFindVerticalWinner() {
        assertThat(analyzer.findWinner(Main.parseInput("X_XXO_XO_")), is('X'));
        assertThat(analyzer.findWinner(Main.parseInput("XXOXOO__O")), is('O'));
    }

    @Test
    public void canFindDiagonalWinner() {
        assertThat(analyzer.findWinner(Main.parseInput("X_XOXO_OX")), is('X'));
        assertThat(analyzer.findWinner(Main.parseInput("X O OXOOX")), is('O'));
    }

    @Test
    public void canDetectWhenXWins() {
        char[][] field = Main.parseInput("XXXOO__O_");
        assertThat(analyzer.findState(field), is("X wins"));
        field = Main.parseInput("XOXOXOXXO");
        assertThat(analyzer.findState(field), is("X wins"));
    }

    @Test
    public void canDetectWhenOWins() {
        char[][] field = Main.parseInput("XOOOXOXXO");
        assertThat(analyzer.findState(field), is("O wins"));
    }

    @Test
    public void canDetectDraw() {
        char[][] field = Main.parseInput("XOXOOXXXO");
        assertThat(analyzer.findState(field), is("Draw"));
    }

    @Test
    public void canDetectNotFinished() {
        char[][] field = Main.parseInput("XO_OOX_X_");
        assertThat(analyzer.findState(field), is("Game not finished"));
    }

    @Test
    public void canDetectImpossible() {
        char[][] field = Main.parseInput("XO_XO_XOX");
        assertThat(analyzer.findState(field), is("Impossible"));
        field = Main.parseInput("_O_X__X_X");
        assertThat(analyzer.findState(field), is("Impossible"));
        field = Main.parseInput("_OOOO_X_X");
        assertThat(analyzer.findState(field), is("Impossible"));
    }
}
