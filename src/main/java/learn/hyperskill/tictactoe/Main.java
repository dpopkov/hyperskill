package learn.hyperskill.tictactoe;

public class Main {
    private static final int SIZE = 3;

    public static void main(String[] args) {
        final char[] field = {'X', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O'};
        StringBuilder builder = new StringBuilder();
        for (int offset = 0; offset < field.length; offset += SIZE) {
            for (int j = 0; j < SIZE; j++) {
                if (j > 0) {
                    builder.append(' ');
                }
                builder.append(field[offset + j]);
            }
            builder.append(System.lineSeparator());
        }
        System.out.print(builder.toString());
    }
}
