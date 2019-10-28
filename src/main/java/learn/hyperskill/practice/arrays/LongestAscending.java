package learn.hyperskill.practice.arrays;

import java.util.Scanner;

public class LongestAscending {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[in.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(sequenceLength(a));
    }

    static int sequenceLength(int[] a) {
        int m0 = 1;
        int m = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] <= a[i]) {
                m0++;
                if (m0 > m) {
                    m = m0;
                }
            } else {
                m0 = 1;
            }
        }
        return m;
    }
}
