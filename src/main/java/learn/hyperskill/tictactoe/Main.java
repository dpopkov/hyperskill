package learn.hyperskill.tictactoe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String NL = System.lineSeparator();
    private static final char EMPTY = ' ';
    private static final Pattern XY_PATTERN = Pattern.compile("(\\d)\\s+(\\d)");
    private static final int SIZE = 3;

    private final Scanner in = new Scanner(System.in);
    private final char[][] field;
    private final Analyzer analyzer;
    private char current;

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer('X', 'O');
        Main game = new Main(analyzer);
        game.run();
    }

    public Main(Analyzer analyzer) {
        this.analyzer = analyzer;
        field = initField();
        current = 'X';
    }

    public void run() {
        System.out.print(buildOutput(field));
        do {
            move();
            String state = analyzer.findState(field);
            if (!"Game not finished".equals(state)) {
                System.out.println(state);
                break;
            }
        } while (true);
    }

    private void move() {
        boolean waitingForInput = true;
        int col;
        int row;
        do {
            int[] coordinates = receiveCoordinates(in);
            col = coordinates[0];
            row = coordinates[1];
            if (field[row][col] != EMPTY) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                waitingForInput = false;
            }
        } while (waitingForInput);
        field[row][col] = current;
        System.out.print(buildOutput(field));
        current = current == 'X' ? 'O' : 'X';
    }

    private static int[] receiveCoordinates(Scanner in) {
        while (true) {
            System.out.println("Enter the coordinates: ");
            Matcher matcher = XY_PATTERN.matcher(in.nextLine());
            if (matcher.matches()) {
                int[] result = new int[2];
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                result[0] = xToColumn(x);
                result[1] = yToRow(y);
                return result;
            } else {
                System.out.println("You should enter numbers!");
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

    private static String buildOutput(char[][] field) {
        StringBuilder builder = new StringBuilder();
        String horizontal = makeHorizontalLine(field[0].length * 2 + 3);
        builder.append(horizontal);
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
        builder.append(horizontal);
        builder.append(NL);
        return builder.toString();
    }

    private static String makeHorizontalLine(int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, '-');
        return new String(chars);
    }
}
