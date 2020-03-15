package learn.hyperskill.practice.arrays;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nRows = in.nextInt();
        int nCols = in.nextInt();
        int[][] seats = new int[nRows][nCols];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                seats[r][c] = in.nextInt();
            }
        }
        int nTickets = in.nextInt();
        int foundInRow = findRow(seats, nTickets);
        System.out.println(foundInRow);
    }

    static int findRow(int[][] seats, int nTickets) {
        int numFound = 0;
        int result = -1;
        for (int r = 0; numFound != nTickets && r < seats.length; r++) {
            numFound = 0;
            for (int c = 0; numFound != nTickets && c < seats[r].length; c++) {
                if (seats[r][c] == 0) {
                    numFound++;
                    if (numFound == nTickets) {
                        result = r;
                    }
                } else {
                    numFound = 0;
                }
            }
        }
        return result + 1;
    }
}
