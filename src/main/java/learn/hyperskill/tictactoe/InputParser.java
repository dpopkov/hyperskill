package learn.hyperskill.tictactoe;

public class InputParser {
    private final char emptyChar;
    private final char emptyPlaceHolder;

    /**
     * Constructs parser.
     * @param emptyChar char depicting empty cell in result
     * @param emptyPlaceHolder char that will be substituted by empty char
     */
    public InputParser(char emptyChar, char emptyPlaceHolder) {
        this.emptyChar = emptyChar;
        this.emptyPlaceHolder = emptyPlaceHolder;
    }

    public char[][] parse(String input) {
        int size = (int) Math.sqrt(input.length());
        char[][] chars = new char[size][size];
        int row = 0;
        int col = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            ch = ch == emptyPlaceHolder ? emptyChar : ch;
            chars[row][col] = ch;
            col++;
            if (col == size) {
                col = 0;
                row++;
            }
        }
        return chars;
    }
}
