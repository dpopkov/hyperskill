package learn.hyperskill.practice.loops;

import java.util.Scanner;

/**
 * Given the number N with an even number of digits.
 * If the sum of the first half of the digits equals the sum
 * of the second half of the digits, then this number is considered lucky.
 * For a given number, output "YES" if this number is lucky, otherwise output "NO".
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        boolean lucky = isLucky(n);
        System.out.println(lucky ? "YES" : "NO");
    }

    static boolean isLucky(String number) {
        int mid = number.length() / 2;
        String left = number.substring(0, mid);
        String right = number.substring(mid);
        return sumDigits(left) == sumDigits(right);
    }

    static int sumDigits(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }

    static boolean isLucky(long n) {
        int sum1 = 0;
        int sum2 = 0;
        long d1 = 1;
        while (d1 <= n / 10) {
            d1 *= 10;
        }
        long d2 = 10;
        while (n != 0) {
            sum1 += n / d1;
            sum2 += n % d2;
            n %= d1;
            n /= d2;
            d1 /= 100;
        }
        return sum1 == sum2;
    }
}
