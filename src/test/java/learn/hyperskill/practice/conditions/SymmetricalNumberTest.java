package learn.hyperskill.practice.conditions;

import org.junit.Test;

import static learn.hyperskill.practice.conditions.SymmetricalNumber.checkSymmetry;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SymmetricalNumberTest {

    @Test
    public void testCheckSymmetry() {
        assertThat(checkSymmetry("2002"), is(1));
        assertThat(checkSymmetry("2008"), is(not(1)));
        assertThat(checkSymmetry("2080"), is(not(1)));
        assertThat(checkSymmetry("208"), is(not(1)));
        assertThat(checkSymmetry("220"), is(1));
    }
}
