package learn.hyperskill.practice.loops;

import org.junit.Test;

import static learn.hyperskill.practice.loops.SmallestNumberForFactorial.findSmallest;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SmallestNumberForFactorialTest {

    @Test
    public void testFindSmallest() {
        long m = 6188989133L;
        long n = findSmallest(m);
        assertThat(n, is(13L));
    }
}
