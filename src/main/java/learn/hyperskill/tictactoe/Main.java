package learn.hyperskill.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String NL = System.lineSeparator();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char[][] field = parseInput(input);
        System.out.print(buildOutput(field));
    }

    private static char[][] parseInput(String input) {
        int size = (int) Math.sqrt(input.length());
        char[][] chars = new char[size][size];
        int row = 0;
        int col = 0;
        for (int i = 0; i < input.length(); i++) {
            chars[row][col] = input.charAt(i);
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
        String horizontal = makeLine(field[0].length * 2 + 3);
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

    private static String makeLine(int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, '-');
        return new String(chars);
    }
}
