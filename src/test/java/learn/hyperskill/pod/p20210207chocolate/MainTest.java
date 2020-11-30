package learn.hyperskill.pod.p20210207chocolate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @CsvSource({"4,2,2", "4,2,4", "4,2,6", "7,4,21"})
    void testPossible(int n, int m, int k) {
        assertTrue(Main.possibleToBreak(n, m, k));
    }

    @ParameterizedTest
    @CsvSource({"4,2,3", "4,2,1", "2,10,7"})
    void testImpossible(int n, int m, int k) {
        assertFalse(Main.possibleToBreak(n, m, k));
    }
}
