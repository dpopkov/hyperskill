package learn.hyperskill.coffeemachine;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class IngredientsTest {

    @Test
    public void whenConstructedThenHaveInitialAmounts() {
        Ingredients ingredients = new Ingredients(1000, 200, 50);
        assertThat(ingredients.water(), is(1000));
        assertThat(ingredients.milk(), is(200));
        assertThat(ingredients.beans(), is(50));
    }

    @Test
    public void whenAskedNumCupsHasEnoughForRecipeThenCalculatesAmount() {
        Ingredients ingredients = new Ingredients(500, 200, 50);
        int expected = 2;
        int result = ingredients.numCupsHasEnoughFor(new Recipe());
        assertThat(result, is(expected));
    }
}
