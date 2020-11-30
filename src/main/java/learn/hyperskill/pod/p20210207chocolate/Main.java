package learn.hyperskill.pod.p20210207chocolate;

import java.util.Scanner;

/*
Chocolate.

Imagine a chocolate bar. Remember how it is usually split into smaller bits by a special grid?

Now think of chocolate as an N x M rectangle divided into little segments: N segments in length and M in width.
Each segment is 1x1 and unbreakable. Find out whether it is possible to break off exactly K segments from the chocolate with a single straight line: vertical or horizontal.

Input data format.
The program gets an input of three integers: N, M, K.

Output data format.
The program must output one of the two words: YES or NO.
 */
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int width = in.nextInt();
        int numSegments = in.nextInt();
        boolean possible = possibleToBreak(length, width, numSegments);
        System.out.println(possible ? "YES" : "NO");
    }

    public static boolean possibleToBreak(int length, int width, int numSegments) {
        return numSegments <= (width * length) && (numSegments % width == 0 || numSegments % length == 0);
    }
}
