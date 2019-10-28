package learn.hyperskill.practice.arrays;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LongestAscendingTest {

    @Test
    public void testSequenceLength() {
        int[] a = {1, 2, 3, 2, 1, 2, 3, 4};
        int r = LongestAscending.sequenceLength(a);
        assertThat(r, is(4));
    }

    @Test
    public void testSequenceLengthUsingProblemData() {
        int[] a = {1, 2, 4, 1, 2, 3, 5, 7, 4, 3};
        int r = LongestAscending.sequenceLength(a);
        assertThat(r, is(5));
    }
}
