package learn.hyperskill.coffeemachine;

import org.junit.Test;

import static org.junit.Assert.*;

public class EspressoTest {
    private final Espresso espresso = new Espresso();

    @Test
    public void testWater() {
        assertEquals(200, espresso.water());
    }

    @Test
    public void testMilk() {
        assertEquals(50, espresso.milk());
    }

    @Test
    public void testCoffeeBeans() {
        assertEquals(15, espresso.coffeeBeans());
    }

    @Test
    public void testCost() {
        assertEquals(4, espresso.cost());
    }
}
