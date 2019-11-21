package learn.hyperskill.practice.potd;

import java.util.Arrays;
import java.util.Scanner;

/*
N-size sudoku is a game with a square table of N2 width and height divided into N2 smaller
squares of N width and height. In a solved state, each of this smaller squares,
as well as each row and column of a full square, contains all numbers from 1 to N2 without repetition.

Given a number N on the first line and a full sudoku table on the next N2 lines.
Every line contains N2 integers.

Your task is to determine whether this sudoku is solved or not.
Output "YES" if this sudoku table is solved, otherwise "NO".

N can be from 1 to 10.
 */
public class CheckSudoku {
    private final boolean[] allTrue;
    private final int n;
    private final int size;
    private final boolean[] numSet;

    public CheckSudoku(int n) {
        this.n = n;
        size = n * n;
        allTrue = new boolean[size];
        Arrays.fill(allTrue, true);
        numSet = new boolean[size];
    }

    @SuppressWarnings("DuplicatedCode")
    public boolean isSolved(int[][] numbers) {
        for (int r = 0; r < size; r++) {
            Arrays.fill(numSet, false);
            for (int c = 0; c < size; c++) {
                if (!fillNumSet(numbers[r][c])) {
                    return false;
                }
            }
            if (!Arrays.equals(allTrue, numSet)) {
                return false;
            }
        }

        for (int c = 0; c < size; c++) {
            Arrays.fill(numSet, false);
            for (int r = 0; r < size; r++) {
                if (!fillNumSet(numbers[r][c])) {
                    return false;
                }
            }
            if (!Arrays.equals(allTrue, numSet)) {
                return false;
            }
        }

        for (int r = 0; r < size; r += n) {
            for (int c = 0; c < size; c += n) {
                Arrays.fill(numSet, false);
                for (int r1 = r; r1 < r + n; r1++) {
                    for (int c1 = c; c1 < c + n; c1++) {
                        if (!fillNumSet(numbers[r1][c1])) {
                            return false;
                        }
                    }
                }
                if (!Arrays.equals(allTrue, numSet)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean fillNumSet(int value) {
        int idx = value - 1;
        if (idx < 0 || idx >= numSet.length) {
            return false;
        }
        numSet[idx] = true;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = n * n;
        int[][] numbers = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                numbers[row][col] = in.nextInt();
            }
        }
        CheckSudoku checkSudoku = new CheckSudoku(n);
        boolean solved = checkSudoku.isSolved(numbers);
        System.out.println(solved ? "YES" : "NO");
    }
}
