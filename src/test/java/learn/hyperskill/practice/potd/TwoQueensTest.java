package learn.hyperskill.practice.potd;

import org.junit.Test;

import static learn.hyperskill.practice.potd.TwoQueens.hitEachOther;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TwoQueensTest {

    @Test
    public void testHitEachOther() {
        assertThat(hitEachOther(1, 2, 1, 7), is(true));
        assertThat(hitEachOther(1, 7, 4, 7), is(true));
        assertThat(hitEachOther(2, 1, 6, 5), is(true));
        assertThat(hitEachOther(2, 8, 8, 2), is(true));
        assertThat(hitEachOther(3, 2, 4, 7), is(false));
    }
}
