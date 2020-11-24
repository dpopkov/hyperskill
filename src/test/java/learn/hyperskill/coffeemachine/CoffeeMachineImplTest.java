package learn.hyperskill.coffeemachine;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@DisplayName("CoffeeMachineImpl должен")
class CoffeeMachineImplTest {

    @Test
    @DisplayName("тратить запасы при покупке")
    void shouldSpendProvisionWhenBuy() {
        CoffeeMachine machine = new CoffeeMachineImpl(100, 50, 5, 3, 20);
        Recipe recipe = mock(Recipe.class);
        given(recipe.getWater()).willReturn(45);
        given(recipe.getMilk()).willReturn(30);
        given(recipe.getCoffeeBeans()).willReturn(2);
        MachineState expected = new MachineState(55, 20, 3, 2, 20);
        machine.buy(recipe);
        assertThat(machine.getState(), is(expected));
    }

    @Test
    @DisplayName("получать деньги при покупке")
    void shouldGainMoneyWhenBuy() {
        CoffeeMachine machine = new CoffeeMachineImpl(100, 50, 5, 3, 20);
        Recipe recipe = mock(Recipe.class);
        given(recipe.getPrice()).willReturn(15);
        MachineState expected = new MachineState(100, 50, 5, 2, 35);
        machine.buy(recipe);
        assertThat(machine.getState(), is(expected));
    }
}
