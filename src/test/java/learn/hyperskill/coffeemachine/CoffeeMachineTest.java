package learn.hyperskill.coffeemachine;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.Matchers.*;
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
    public void whenHasSuppliesThenPrintsCorrectInfo() {
        Supplies supplies = new Supplies(100, 70, 50, 20);
        CoffeeMachine coffeeMachine = new CoffeeMachine(null, null, supplies);
        String expected = String.join(NL, "The coffee machine has:",
                "100 of water",
                "70 of milk",
                "50 of coffee beans",
                "20 of disposable cups",
                "550 of money",
                "");
        String result = coffeeMachine.info();
        assertThat(result, is(expected));
    }
    // 2) Read action

    // 3) Act
    @Test
    public void whenBuyEspressoThenSubtractSuppliesAndMoney() {
        Supplies supplies = new Supplies(300, 70, 50, 20);
        CoffeeMachine coffeeMachine = new CoffeeMachine(null, null, supplies);
        coffeeMachine.buy(new Espresso(), 1);
        String expected = String.join(NL, "The coffee machine has:",
                "100 of water",
                "20 of milk",
                "35 of coffee beans",
                "19 of disposable cups",
                "546 of money",
                "");
        String result = coffeeMachine.info();
        assertThat(result, is(expected));
    }

    // 4) Print info

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
