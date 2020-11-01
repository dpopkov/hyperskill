package learn.hyperskill.pod.p20201101boxes;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    @Test
    public void testCompareTo() {
        Box a = new Box(1, 2,3);
        Box b = new Box(5, 6,4);
        assertEquals(-3, a.compareTo(b));
        assertEquals(3, b.compareTo(a));
    }

    @Test
    public void testSimpleCanBePut() {
        Box a = new Box(1, 2,3);
        Box b = new Box(5, 6,4);
        assertTrue(a.canBePutInto(b));
        assertFalse(b.canBePutInto(a));
    }

    @Test
    public void testRotatedCanBePut() {
        Box a = new Box(2, 9,4);
        Box b = new Box(3, 8,1);
        assertFalse(a.canBePutInto(b));
        assertTrue(b.canBePutInto(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBothCanNotBePut() {
        Box a = new Box(1, 3,7);
        Box b = new Box(2, 8,3);
        a.canBePutInto(b);
    }
}
