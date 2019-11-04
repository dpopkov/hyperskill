package learn.hyperskill.practice.arrays;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SumOfNeighboursTest {

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
    public void testMain3X3() {
        String input = "9 5 3\n" +
                "0 7 -1\n" +
                "-5 2 9\n" +
                "end";
        String expected = "3 21 22 " + NL
                + "10 6 19 " + NL
                + "20 16 -1 " + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SumOfNeighbours.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }

    @Test
    public void testMainOne() {
        String input = "1\nend";
        String expected = "4 " + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SumOfNeighbours.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }

    @Test
    public void testMainOneLIne() {
        String input = "1 2 3 4\nend";
        String expected = "8 8 12 12 " + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SumOfNeighbours.main(null);
        assertThat(buffer.toString(), Matchers.is(expected));
    }
}
