package learn.hyperskill.coffeemachine;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CoffeeMachineTest {

    private static final String NL = System.lineSeparator();
    private static final String PROMPT = String.join(NL,
            "Write how many ml of water the coffee machine has:",
            "> Write how many ml of milk the coffee machine has:",
            "> Write how many grams of coffee beans the coffee machine has:",
            "> Write how many cups of coffee you will need:"
    );

    private ByteArrayOutputStream buffer;

    @Before
    public void setup() {
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
    }

    @Test
    public void testMainYes() {
        prepareInput(String.join(NL, "300", "65", "100", "1", ""));
        String expected = String.join(NL, PROMPT, "> Yes, I can make that amount of coffee", "");
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    @Test
    public void testMainNo() {
        prepareInput(String.join(NL, "500", "250", "200", "10", ""));
        String expected = String.join(NL, PROMPT, "> No, I can make only 2 cup(s) of coffee", "");
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    @Test
    public void testYesAndMore() {
        prepareInput(String.join(NL, "1550", "299", "300", "3", ""));
        String expected = String.join(NL, PROMPT, "> Yes, I can make that amount of coffee (and even 2 more than that)", "");
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    private void prepareInput(String s) {
        System.setIn(new ByteArrayInputStream(s.getBytes()));
    }
}
