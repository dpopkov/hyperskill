package learn.hyperskill.coffeemachine;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SuppliesTest {

    @Test
    public void whenConstructedThenHaveInitialAmounts() {
        Supplies supplies = new Supplies(1000, 200, 50, 1);
        assertThat(supplies.water(), is(1000));
        assertThat(supplies.milk(), is(200));
        assertThat(supplies.beans(), is(50));
    }

    @Test
    public void whenAskedNumCupsHasEnoughForRecipeThenCalculatesAmount() {
        Supplies supplies = new Supplies(500, 200, 50, 1);
        int expected = 1;
        int result = supplies.numCupsHasEnoughFor(new Espresso());
        assertThat(result, is(expected));
    }

    @Test
    public void whenTakeSomeAmountThenSuppliesDecreases() {
        Supplies supplies = new Supplies(500, 200, 50, 2);
        supplies.takeFor(new Espresso(), 1);
        assertThat(supplies.water(), is(300));
        assertThat(supplies.milk(), is(150));
        assertThat(supplies.beans(), is(35));
        assertThat(supplies.cups(), is(1));
    }
}
