package learn.hyperskill.practice.loops;

import org.junit.Test;

import static learn.hyperskill.practice.loops.LuckyNumbers.isLucky;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LuckyNumbersTest {

    @Test
    public void testIsLuckyNumbers() {
        assertThat(isLucky(12344321), is(true));
        assertThat(isLucky(125322), is(false));
        assertThat(isLucky(121212121212L), is(true));
        assertThat(isLucky(121212000009L), is(true));
        assertThat(isLucky(121212000008L), is(false));
    }

    @Test
    public void testIsLuckyString() {
        assertThat(isLucky("12344321"), is(true));
        assertThat(isLucky("125322"), is(false));
        assertThat(isLucky("121212121212"), is(true));
        assertThat(isLucky("121212000009"), is(true));
        assertThat(isLucky("121212000008"), is(false));
        assertThat(isLucky("342347923472983472354721"), is(false));
    }
}
