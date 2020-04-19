package learn.hyperskill.practice.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RightRotate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] array = line.split(" ");
        int n = in.nextInt();
        rightRotate(array, n);
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void rightRotate(String[] a, int numRotations) {
        int n = numRotations % a.length;
        String[] buffer = Arrays.copyOfRange(a, 0, a.length - n);
        System.arraycopy(a, a.length - n, a, 0, n);
        System.arraycopy(buffer, 0, a, n, buffer.length);
    }

    public static void rightRotate(int[] a, int numRotations) {
        int n = numRotations % a.length;
        int[] buffer = Arrays.copyOfRange(a, 0, a.length - n);
        System.arraycopy(a, a.length - n, a, 0, n);
        System.arraycopy(buffer, 0, a, n, buffer.length);
    }
}
