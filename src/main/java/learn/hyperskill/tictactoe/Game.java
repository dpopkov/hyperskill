package learn.hyperskill.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private static final String NL = System.lineSeparator();
    private static final char EMPTY = ' ';
    private static final int SIZE = 3;
    private static final String HOR_LINE = "-".repeat(SIZE * 2 + 3);
    private static final Pattern XY_PATTERN = Pattern.compile("(\\d)\\s+(\\d)");

    private final char[][] field;
    private final Analyzer analyzer;
    private final Scanner in;
    private final PrintStream out;
    private char current;

    public Game(Analyzer analyzer, InputStream inputStream, PrintStream out) {
        this.analyzer = analyzer;
        this.out = out;
        in = new Scanner(inputStream);
        field = initField();
        current = 'X';
    }

    public void run() {
        out.print(output());
        do {
            move();
            State state = analyzer.findState(field);
            if (state != State.NOT_FINISHED) {
                out.println(state.message());
                break;
            }
        } while (true);
    }

    private void move() {
        boolean waitingForInput = true;
        int col;
        int row;
        do {
            int[] coordinates = receiveCoordinates();
            col = coordinates[0];
            row = coordinates[1];
            if (field[row][col] != EMPTY) {
                out.println("This cell is occupied! Choose another one!");
            } else {
                waitingForInput = false;
            }
        } while (waitingForInput);
        field[row][col] = current;
        out.print(output());
        current = current == 'X' ? 'O' : 'X';
    }

    private int[] receiveCoordinates() {
        while (true) {
            out.println("Enter the coordinates: ");
            Matcher matcher = XY_PATTERN.matcher(in.nextLine());
            if (matcher.matches()) {
                int[] result = new int[2];
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
                    out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                result[0] = xToColumn(x);
                result[1] = yToRow(y);
                return result;
            } else {
                out.println("You should enter numbers!");
            }
        }
    }

    private static int xToColumn(int x) {
        return x - 1;
    }

    private static int yToRow(int y) {
        return SIZE - y;
    }

    private static char[][] initField() {
        char[][] chars = new char[SIZE][SIZE];
        for (char[] row : chars) {
            Arrays.fill(row, EMPTY);
        }
        return chars;
    }

    private String output() {
        StringBuilder builder = new StringBuilder();
        builder.append(HOR_LINE);
        builder.append(NL);
        for (char[] row : field) {
            builder.append("| ");
            for (char ch : row) {
                builder.append(ch);
                builder.append(' ');
            }
            builder.append("|");
            builder.append(NL);
        }
        builder.append(HOR_LINE);
        builder.append(NL);
        return builder.toString();
    }
}
