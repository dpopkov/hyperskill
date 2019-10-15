package learn.hyperskill.practice.conditions;

import org.junit.Test;

import static learn.hyperskill.practice.conditions.CompareIgnoringWhitespaces.equalIgnoringWS;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CompareIgnoringWhitespacesTest {

    @Test
    public void testEqualIgnoringWS() {
        assertThat(equalIgnoringWS("ab", "ab"), is(true));
        assertThat(equalIgnoringWS("ab", "abc"), is(false));
        assertThat(equalIgnoringWS(" ab", "a b"), is(true));
        assertThat(equalIgnoringWS(" ab", "a b "), is(true));
        assertThat(equalIgnoringWS(" ab", "a bc"), is(false));
    }
}
