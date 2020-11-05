package learn.hyperskill.pod.p20200307;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class FloorSpaceTest {

    public static final String NL = System.lineSeparator();

    @Test
    public void process() {
        List<String> input = List.of("rectangle", "4", "10");
        double result = new FloorSpace().process(input);
        assertEquals(40.0, result, 1e-14);
    }

    @Test
    public void testMain() {
        String input = "circle" + NL + "5" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        FloorSpace.main(null);
        assertEquals("78.5" + NL, buffer.toString());
    }
}
