package learn.hyperskill.tictactoe;

import java.util.Arrays;

/**
 * Analyzer of game field.
 */
public class Analyzer {
    static final char NONE = ' ';

    private final char x;
    private final char o;
    private boolean xWins = false;
    private boolean oWins = false;
    private int xCount;
    private int oCount;
    private int noneCount;

    /**
     * Constructs analyzer using specified characters
     * @param x character for X
     * @param o character for O
     */
    public Analyzer(char x, char o) {
        this.x = x;
        this.o = o;
    }

    char findWinner(char[][] field) {
        reset();
        int size = field[0].length;
        char winner;
        for (char[] row : field) {
            winner = row[0];
            count(row[0]);
            for (int col = 1; col < size; col++) {
                count(row[col]);
                if (row[col] != winner) {
                    winner = NONE;
                }
            }
            setOneOfWinners(winner);
        }
        for (int col = 0; col < size; col++) {
            winner = field[0][col];
            for (int row = 1; row < size; row++) {
                if (field[row][col] != winner) {
                    winner = NONE;
                    break;
                }
            }
            setOneOfWinners(winner);
        }
        winner = field[0][0];
        for (int row = 1, col = 1; row < size && col < size; row++, col++) {
            if (field[row][col] != winner) {
                winner = NONE;
                break;
            }
        }
        setOneOfWinners(winner);
        winner = field[0][size - 1];
        for (int row = 1, col = size - 2; row < size && col >= 0; row++, col--) {
            if (field[row][col] != winner) {
                winner = NONE;
                break;
            }
        }
        setOneOfWinners(winner);
        if (xWins) {
            return x;
        } else if (oWins) {
            return o;
        }
        return winner;
    }

    private void reset() {
        xCount = 0;
        oCount = 0;
        noneCount = 0;
        xWins = false;
        oWins = false;
    }

    private void count(char c) {
        if (c == x) {
            xCount++;
        } else if (c == o) {
            oCount++;
        } else if (c == NONE) {
            noneCount++;
        }
    }

    private void setOneOfWinners(char winner) {
        if (winner == x) {
            xWins = true;
        } else if (winner == o) {
            oWins = true;
        }
    }

    /**
     * Finds state of the field.
     * @param field game field
     * @return state of field
     */
    public State findState(char[][] field) {
        char winner = findWinner(field);
        if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
            return State.IMPOSSIBLE;
        } else if (xWins) {
            return State.X_WINS;
        } else if (oWins) {
            return State.O_WINS;
        } else if (noneCount > 0) {
            return State.NOT_FINISHED;
        } else if (winner == NONE) {
            return State.DRAW;
        }
        throw new IllegalStateException("Could not find correct state of the field: " + Arrays.deepToString(field));
    }
}
