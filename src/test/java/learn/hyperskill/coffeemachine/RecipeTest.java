package learn.hyperskill.coffeemachine;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {
    private final Recipe recipe = new Recipe();

    @Test
    public void testWater() {
        assertEquals(200, recipe.water());
    }

    @Test
    public void testMilk() {
        assertEquals(50, recipe.milk());
    }

    @Test
    public void testCoffeeBeans() {
        assertEquals(15, recipe.coffeeBeans());
    }
}
