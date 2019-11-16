package learn.hyperskill.practice.conditions;

import java.util.Arrays;
import java.util.Scanner;

/*
There are two boxes on the table.
The first box has a size of X1 x Y1 x Z1, and the second box has a size of X2 x Y2 x Z2.
You need to determine which box can be put inside another box.
You can rotate both boxes as you want.
 */
public class Boxes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] tokens = line1.split(" ");
        int x1 = toInt(tokens, 0);
        int y1 = toInt(tokens, 1);
        int z1 = toInt(tokens, 2);
        tokens = line2.split(" ");
        int x2 = toInt(tokens, 0);
        int y2 = toInt(tokens, 1);
        int z2 = toInt(tokens, 2);
        String result = compare(x1, y1, z1, x2, y2, z2);
        System.out.println(result);
    }

    static String compare(int x1, int y1, int z1, int x2, int y2, int z2) {
        int[] box1 = new int[]{x1, y1, z1};
        int[] box2 = new int[]{x2, y2, z2};
        Arrays.sort(box1);
        Arrays.sort(box2);
        int rst = Arrays.compare(box1, box2);
        if (rst == 0) {
            return "Box 1 = Box 2";
        } else if (box1[0] <= box2[0] && box1[1] <= box2[1] && box1[2] <= box2[2]) {
            return "Box 1 < Box 2";
        } else if (box1[0] >= box2[0] && box1[1] >= box2[1] && box1[2] >= box2[2]) {
            return "Box 1 > Box 2";
        }
        return "Incomparable";
    }

    private static int toInt(String[] tokens, int i) {
        return Integer.parseInt(tokens[i]);
    }
}
