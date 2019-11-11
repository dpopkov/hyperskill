package learn.hyperskill.practice.conditions;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SimpleEquationTest {
    public static final String NL = System.lineSeparator();

    private final InputStream savedIn = System.in;
    private final PrintStream savedOut = System.out;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @Before
    public void setOutput() {
        System.setOut(new PrintStream(buffer));
    }

    @After
    public void restore() {
        System.setOut(savedOut);
        System.setIn(savedIn);
    }

    @Test
    public void testXIsPositiveRight() {
        String input = "5 + x = 15";
        String expected = "10" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SimpleEquation.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }

    @Test
    public void testOperandIsNegativeRight() {
        String input = "x - 8 = 10";
        String expected = "18" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SimpleEquation.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }

    @Test
    public void testXIsPositiveLeft() {
        String input = "10 = 12 + x";
        String expected = "-2" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SimpleEquation.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }

    @Test
    public void testXIsResultOnLeft() {
        String input = "x = 12 + 45";
        String expected = "57" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SimpleEquation.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }

    @Test
    public void testXIsResultOnRight() {
        String input = "12 - 45 = x";
        String expected = "-33" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SimpleEquation.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }
}
