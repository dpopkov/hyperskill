package learn.hyperskill.cinema;

public class Hall {
    private static final String NL = System.lineSeparator();

    private final int numRows;
    private final int numSeatsPerRow;

    public Hall(int numRows, int numSeatsPerRow) {
        this.numRows = numRows;
        this.numSeatsPerRow = numSeatsPerRow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int c = 0; c < numSeatsPerRow; c++) {
            sb.append(" ").append(c + 1);
        }
        for (int r = 0; r < numRows; r++) {
            sb.append(NL).append(r + 1);
            for (int c = 0; c < numSeatsPerRow; c++) {
                sb.append(" S");
            }
        }
        return sb.toString();
    }
}
