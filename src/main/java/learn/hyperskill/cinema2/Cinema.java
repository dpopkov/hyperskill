package learn.hyperskill.cinema2;

public class Cinema {
    public static void main(String[] args) {
        Room room = new Room(7, 8);
        System.out.println("Cinema:");
        System.out.println(room.displayAsString());
    }
}
