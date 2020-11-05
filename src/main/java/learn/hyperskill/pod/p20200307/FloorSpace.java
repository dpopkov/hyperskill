package learn.hyperskill.pod.p20200307;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Residents of the country of Malevia often experiment with the plan of their rooms.
 * Rooms can be triangular, rectangular, and round.
 * Write a program that calculates the floorage of the rooms.
 *
 * Input data format
 * The type of the room shape and the relevant parameters.
 *
 * Output data format
 * The area of the resulting room.
 */
public class FloorSpace {

    public double process(List<String> input) {
        Shape shape = Shape.of(input.get(0));
        double[] params = new double[input.size() - 1];
        for (int i = 1; i < input.size(); i++) {
            params[i - 1] = Double.parseDouble(input.get(i));
        }
        return shape.area(params);
    }

    public void run(Scanner in) {
        List<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        double result = process(lines);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FloorSpace calculator = new FloorSpace();
        calculator.run(in);
    }
}
