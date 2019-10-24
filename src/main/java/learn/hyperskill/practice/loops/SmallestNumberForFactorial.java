package learn.hyperskill.practice.loops;

import java.util.Scanner;

/**
 * A user inputs a long number M. You need to find out what is the smallest long number n
 * such that n! ≥ M.
 */
public class SmallestNumberForFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long m = in.nextLong();
        long n = findSmallest(m);
        System.out.println(n);
    }

    static long findSmallest(long m) {
        long n = 1;
        long i = 1;
        while (n < m) {
            i++;
            n *= i;
        }
        return i;
    }
}
