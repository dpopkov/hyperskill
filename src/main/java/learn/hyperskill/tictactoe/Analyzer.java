package learn.hyperskill.tictactoe;

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
     * @return string representation of field state
     */
    public String findState(char[][] field) {
        char winner = findWinner(field);
        if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
            return "Impossible";
        } else if (xWins) {
            return x + " wins";
        } else if (oWins) {
            return o + " wins";
        } else if (noneCount > 0) {
            return "Game not finished";
        } else if (winner == NONE) {
            return "Draw";
        }
        throw new IllegalStateException("Could not find correct state of the game");
    }
}
