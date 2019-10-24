package learn.hyperskill.practice.potd;

import java.util.Scanner;

/**
 * In a computer game, each gamer has an army of units.
 *
 * Write a program that will classify the army of your enemies corresponding to the following rules:
 * Units:  Category
 * less than 1: no army
 * from 1 to 4: few
 * from 5 to 9: several
 * from 10 to 19: pack
 * from 20 to 49: lots
 * from 50 to 99: horde
 * from 100 to 249: throng
 * from 250 to 499: swarm
 * from 500 to 999: zounds
 * 1000 and more: legion
 *
 * The program should read the number of units and output the corresponding category.
 */
public class TheArmyOfUnits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int units = in.nextInt();
        System.out.println(classify(units));
    }

    private final static int[] bounds = {1, 5, 10, 20, 50, 100, 250, 500, 1000};
    private final static String[] categories = {
            "no army", "few", "several", "pack", "lots", "horde", "throng", "swarm", "zounds", "legion"
    };

    static String classify(int units) {
        for (int i = 0; i < bounds.length; i++) {
            int bound = bounds[i];
            if (units < bound) {
                return categories[i];
            }
        }
        return categories[categories.length - 1];
    }
}
