package learn.hyperskill.practice.arrays;

/*
In some design style, a 4x4 matrix pattern is considered looking pretty
if it doesn't consist of a 2x2 matrix of the same color.
Your task is to write the program that outputs "YES" if the 4x4 matrix
is looking pretty, otherwise output "NO".

Input contains 4 lines, each line contains 4 symbols,
different symbols represent different colors:
W stands for white color, B - black, R - red, G - green, Y - yellow.
 */
public class PrettyMatrix {
    private int subMatrixSize;

    public PrettyMatrix(int subMatrixSize) {
        this.subMatrixSize = subMatrixSize;
    }

    public boolean isLookingPretty(String[] lines) {
        char[][] chars = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            chars[i] = lines[i].toCharArray();
        }
        return isLookingPretty(chars);
    }

    public boolean isLookingPretty(char[][] matrix) {
        for (int r = 0; r < matrix.length - subMatrixSize + 1; r++) {
            for (int c = 0; c < matrix[r].length - subMatrixSize + 1; c++) {
                if (isMatrixSameColor(matrix, r, c, subMatrixSize)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMatrixSameColor(char[][] matrix, int i, int j, int size) {
        char first = matrix[i][j];
        for (int r = i; r < i + size; r++) {
            for (int c = j; c < j + size; c++) {
                if (matrix[r][c] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
