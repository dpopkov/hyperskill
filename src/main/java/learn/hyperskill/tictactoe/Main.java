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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String input = in.nextLine();
        char[][] field = parseInput(input);
        System.out.print(buildOutput(field));
        int col;
        int row;
        boolean waitingForInput = true;
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
        field[row][col] = 'X';
        System.out.print(buildOutput(field));
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

    static char[][] parseInput(String input) {
        int size = (int) Math.sqrt(input.length());
        char[][] chars = new char[size][size];
        int row = 0;
        int col = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            ch = ch != '_' ? ch : EMPTY;
            chars[row][col] = ch;
            col++;
            if (col == size) {
                col = 0;
                row++;
            }
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
