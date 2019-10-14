package learn.hyperskill.tictactoe;

import java.util.Scanner;

public class Main {
    private static final String NL = System.lineSeparator();
    private static final int WIDTH = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder builder = new StringBuilder();
        builder.append("---------");
        builder.append(NL);
        for (int offset = 0; offset < input.length(); offset += WIDTH) {
            builder.append("| ");
            for (int j = 0; j < WIDTH; j++) {
                builder.append(input.charAt(offset + j));
                builder.append(' ');
            }
            builder.append("|");
            builder.append(NL);
        }
        builder.append("---------");
        builder.append(NL);
        System.out.print(builder.toString());
    }
}
