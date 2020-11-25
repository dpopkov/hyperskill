package learn.hyperskill.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hall должен")
class HallTest {
    private static final String NL = System.lineSeparator();

    @Test
    @DisplayName("давать строковое представление зала")
    void shouldGiveStringRepresentation() {
        String expected = String.join(NL,
                "  1 2 3 4 5 6 7 8",
                "1 S S S S S S S S",
                "2 S S S S S S S S",
                "3 S S S S S S S S",
                "4 S S S S S S S S",
                "5 S S S S S S S S",
                "6 S S S S S S S S",
                "7 S S S S S S S S");
        Hall hall = new Hall(7, 8);
        assertEquals(expected, hall.toString());
    }
}
