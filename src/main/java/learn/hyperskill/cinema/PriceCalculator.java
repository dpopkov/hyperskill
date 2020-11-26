package learn.hyperskill.cinema;

public class PriceCalculator {

    public static final int FRONT_SEAT_PRICE = 10;
    public static final int BACK_SEAT_PRICE = 8;

    public int calculateForHall(int numRows, int numSeatsPerRow) {
        int numSeats = numRows * numSeatsPerRow;
        if (numSeats <= 60) {
            return numSeats * FRONT_SEAT_PRICE;
        }
        int numFrontRows = numRows / 2;
        int numBackRows = numRows - numFrontRows;
        return numSeatsPerRow * (numFrontRows * FRONT_SEAT_PRICE + numBackRows * BACK_SEAT_PRICE);
    }
}
