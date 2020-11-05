package learn.hyperskill.coffeemachine;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CoffeeMachineTest {

    private static final String NL = System.lineSeparator();
    private static final String PROMPT_PREFIX = String.join(NL,
            "The coffee machine has:",
            "400 of water",
            "540 of milk",
            "120 of coffee beans",
            "9 of disposable cups",
            "550 of money",
            "",
            "Write action (buy, fill, take):"
    );

    private ByteArrayOutputStream buffer;

    @Before
    public void setup() {
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
    }

    @Test
    public void testBuyCappuccino() {
        CoffeeMachine expectedState = new CoffeeMachine(null, 200, 440, 108, 8, 556);
        String expected = buildExpected(expectedState, true,
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        prepareInput(String.join(NL, "buy", "3", ""));
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    @Test
    public void testBuyEspresso() {
        CoffeeMachine expectedState = new CoffeeMachine(null, 150, 540, 104, 8, 554);
        String expected = buildExpected(expectedState, true,
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        prepareInput(String.join(NL, "buy", "1", ""));
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    @Test
    public void testFillingTheMachine() {
        CoffeeMachine expectedState = new CoffeeMachine(null, 2400, 1040, 220, 19, 550);
        String expected = buildExpected(expectedState,
                true, "Write how many ml of water do you want to add:",
                "Write how many ml of milk do you want to add:",
                "Write how many grams of coffee beans do you want to add:",
                "Write how many disposable cups of coffee do you want to add:");
        prepareInput(String.join(NL, "fill", "2000", "500", "100", "10", ""));
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    @Test
    public void testTakingMoney() {
        CoffeeMachine expectedState = new CoffeeMachine(null, 400, 540, 120, 9, 0);
        String expected = buildExpected(expectedState, false, "I gave you $550");
        prepareInput(String.join(NL, "take", ""));
        CoffeeMachine.main(null);
        assertEquals(expected, buffer.toString());
    }

    private static String buildExpected(CoffeeMachine expectedState, boolean needsInput, String... machinePrompts) {
        StringBuilder sb = new StringBuilder();
        sb.append(PROMPT_PREFIX).append(NL).append("> ");
        for (String promptItem : machinePrompts) {
            sb.append(promptItem).append(NL);
            if (needsInput) {
                sb.append("> ");
            }
        }
        sb.append(NL).append(expectedState.stateToString()).append(NL);
        return sb.toString();
    }

    private void prepareInput(String s) {
        System.setIn(new ByteArrayInputStream(s.getBytes()));
    }
}
