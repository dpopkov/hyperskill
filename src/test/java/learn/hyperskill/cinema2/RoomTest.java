package learn.hyperskill.cinema2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static final String NL = System.lineSeparator();

    @Test
    void testDisplayAsString() {
        Room room = new Room(7, 8);
        String actual = room.displayAsString();
        String expected = ""
            + "  1 2 3 4 5 6 7 8" + NL
            + "1 S S S S S S S S" + NL
            + "2 S S S S S S S S" + NL
            + "3 S S S S S S S S" + NL
            + "4 S S S S S S S S" + NL
            + "5 S S S S S S S S" + NL
            + "6 S S S S S S S S" + NL
            + "7 S S S S S S S S" + NL;
        assertEquals(expected, actual);
    }
}
