package learn.hyperskill.cinema2;

public class Room {
    private static final String NL = System.lineSeparator();

    private final int rows;
    private final int seats;

    public Room(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
    }

    public String displayAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 1; i <= seats; i++) {
            sb.append(" ").append(i);
        }
        sb.append(NL);
        String oneRow = " S".repeat(Math.max(0, seats));
        for (int i = 1; i <= rows; i++) {
            sb.append(i).append(oneRow).append(NL);
        }
        return sb.toString();
    }
}
