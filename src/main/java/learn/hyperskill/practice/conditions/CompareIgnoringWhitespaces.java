package learn.hyperskill.practice.conditions;

import java.util.Scanner;

public class CompareIgnoringWhitespaces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(equalIgnoringWS(s1, s2));
    }

    static boolean equalIgnoringWS(String s1, String s2) {
        s1 = s1.replace(" ", "");
        s2 = s2.replace(" ", "");
        return s1.equals(s2);
    }
}
