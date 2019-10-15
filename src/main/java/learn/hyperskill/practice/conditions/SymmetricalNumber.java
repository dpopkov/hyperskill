package learn.hyperskill.practice.conditions;

import java.util.Scanner;

public class SymmetricalNumber {
    private static final int NOT_ONE = 37;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(checkSymmetry(s));
    }

    static int checkSymmetry(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        if (sb.charAt(0) == sb.charAt(3) && sb.charAt(1) == sb.charAt(2)) {
            return 1;
        }
        return NOT_ONE;
    }
}
