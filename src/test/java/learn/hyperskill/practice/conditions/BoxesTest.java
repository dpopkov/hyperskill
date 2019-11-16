package learn.hyperskill.practice.conditions;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BoxesTest {

    @Test
    public void testCompareEqualBoxes() {
        assertThat(Boxes.compare(1, 2, 3, 1, 2, 3), is("Box 1 = Box 2"));
        assertThat(Boxes.compare(1, 2, 3, 3, 2, 1), is("Box 1 = Box 2"));
    }

    @Test
    public void testCompareFirstCanBePutIntoSecond() {
        assertThat(Boxes.compare(1, 2, 3, 2, 2, 3), is("Box 1 < Box 2"));
        assertThat(Boxes.compare(1, 2, 3, 1, 4, 3), is("Box 1 < Box 2"));
        assertThat(Boxes.compare(1, 2, 3, 1, 2, 6), is("Box 1 < Box 2"));
    }

    @Test
    public void testCompareSecondCanBePutIntoFirst() {
        assertThat(Boxes.compare(2, 2, 3, 1, 2, 3), is("Box 1 > Box 2"));
        assertThat(Boxes.compare(1, 4, 3, 1, 2, 3), is("Box 1 > Box 2"));
        assertThat(Boxes.compare(1, 2, 6, 1, 2, 3), is("Box 1 > Box 2"));
    }

    @Test
    public void testCompareIncomparable() {
        assertThat(Boxes.compare(1, 1, 4, 2, 2, 1), is("Incomparable"));
        assertThat(Boxes.compare(2, 3, 4, 1, 3, 5), is("Incomparable"));
    }
}
