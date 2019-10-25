package learn.hyperskill.practice.potd;

import java.util.Scanner;

/**
 * You are given coordinates of two queens on a chess board. Find out whether or not they hit each other.
 * <p>
 * Input data format
 * Four integer numbers x_1, y_1, x_2, y_2x
 * Output data format
 * Type "YES" (uppercase) if they hit each other or "NO" if they don't.
 */
public class TwoQueens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        System.out.println(hitEachOther(x1, y1, x2, y2) ? "YES" : "NO");
    }

    static boolean hitEachOther(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2
                || Math.abs(x1 - x2) == Math.abs(y1 - y2);
    }
}
