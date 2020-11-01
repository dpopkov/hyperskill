package learn.hyperskill.pod.p20201101boxes;

import java.util.Scanner;

/*
There are two boxes on the table. The first box has a size of X1 x Y1 x Z1,
and the second box has a size of X2 x Y2 x Z2.
You need to determine whether one of the boxes can be put inside the other.
It should go in without sticking out.
You can rotate both boxes as you want.

Important: two equally sized boxes cannot be placed inside one another.

Input consists of two lines:

    the first line contains numbers X1, Y1, Z1;
    the second line contains numbers X2, Y2, Z2.

All numbers are integers and greater than 0.

Output:

    "Box 1 < Box 2", if the first box can be put inside the second box ;
    "Box 1 > Box 2", if the second box can be put inside the first box;
    otherwise, output "Incompatible".
 */
public class BoxesMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Box b1 = new Box(in.nextInt(), in.nextInt(), in.nextInt());
        Box b2 = new Box(in.nextInt(), in.nextInt(), in.nextInt());
        process(b1, b2);
    }

    private static void process(Box b1, Box b2) {
        try {
            boolean b1LessThanB2 = b1.canBePutInto(b2);
            System.out.println("Box 1 " + (b1LessThanB2 ? "<" : ">") + " Box 2");
        } catch (IllegalArgumentException ex) {
            System.out.println("Incompatible");
        }
    }
}
