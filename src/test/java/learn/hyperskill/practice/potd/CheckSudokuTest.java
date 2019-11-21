package learn.hyperskill.practice.potd;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class CheckSudokuTest {

    @Test
    public void whenSolved9x9ThenTrue() {
        final int n = 3;
        String data = "5 8 9 6 7 4 2 1 3\n" +
                "7 4 3 1 8 2 9 5 6\n" +
                "1 2 6 9 5 3 8 7 4\n" +
                "9 3 5 4 2 1 7 6 8\n" +
                "4 1 2 8 6 7 3 9 5\n" +
                "6 7 8 3 9 5 1 4 2\n" +
                "8 6 4 2 1 9 5 3 7\n" +
                "3 9 7 5 4 8 6 2 1\n" +
                "2 5 1 7 3 6 4 8 9";
        int[][] numbers = parseNumbers(n, data);
        CheckSudoku checkSudoku = new CheckSudoku(n);
        assertTrue(checkSudoku.isSolved(numbers));
    }

    @Test
    public void whenNotSolved2x2ThenFalse() {
        final int n = 2;
        String data = "1 1 2 2\n" +
                "1 1 2 2\n" +
                "3 3 4 4\n" +
                "3 3 4 4";
        int[][] numbers = parseNumbers(n, data);
        CheckSudoku checkSudoku = new CheckSudoku(n);
        assertFalse(checkSudoku.isSolved(numbers));
    }

    @Test
    public void whenSolved1x1ThenTrue() {
        final int n = 1;
        String data = "1";
        int[][] numbers = parseNumbers(n, data);
        CheckSudoku checkSudoku = new CheckSudoku(n);
        assertTrue(checkSudoku.isSolved(numbers));
    }

    private int[][] parseNumbers(int n, String s) {
        Scanner in = new Scanner(s);
        int size = n * n;
        int[][] numbers = new int[size][size];
        int r = 0;
        while (in.hasNextLine()) {
            for (int c = 0; c < size; c++) {
                numbers[r][c] = in.nextInt();
            }
            r++;
        }
        return numbers;
    }
}
