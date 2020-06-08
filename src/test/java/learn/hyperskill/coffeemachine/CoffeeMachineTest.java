package learn.hyperskill.coffeemachine;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CoffeeMachineTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
        String input = "25" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        String expected = String.join(NL,
                "Write how many cups of coffee you will need:",
                "For 25 cups of coffee you will need:",
                "5000 ml of water",
                "1250 ml of milk",
                "375 g of coffee beans",
                ""
        );
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }
}
