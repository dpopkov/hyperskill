package learn.hyperskill.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PriceCalculator должен")
class PriceCalculatorTest {

    private final PriceCalculator calculator = new PriceCalculator();

    @DisplayName("считать общую стоимость для зала с заданным числом мест")
    @ParameterizedTest
    @CsvSource({
            "200, 4, 5",
            "648, 8, 9",
            "560, 9, 7"
    })
    void shouldCalculateTotalPrice(int expected, int numRows, int numSeatsPerRow) {
        assertEquals(expected, calculator.calculateForHall(numRows, numSeatsPerRow));
    }
}
