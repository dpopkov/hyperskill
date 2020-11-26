package learn.hyperskill.cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriceCalculator calculator = new PriceCalculator();
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seatsPerRow = scanner.nextInt();
        int total = calculator.calculateForHall(rows, seatsPerRow);
        System.out.println("Total income:");
        System.out.println("$" + total);
    }
}
