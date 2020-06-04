package learn.hyperskill.practice.methods;

import org.junit.Test;

import static learn.hyperskill.practice.methods.CompositeNumbers.*;
import static org.junit.Assert.*;

public class CompositeNumbersTest {

    @Test
    public void whenIsNotCompositeThenFalse() {
        assertFalse(isComposite(1));
        assertFalse(isComposite(2));
        assertFalse(isComposite(7));
    }

    @Test
    public void whenIsCompositeThenTrue() {
        assertTrue(isComposite(4));
        assertTrue(isComposite(15));
        assertTrue(isComposite(69));
    }
}
