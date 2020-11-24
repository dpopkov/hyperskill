package learn.hyperskill.coffeemachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.*;

@DisplayName("CoffeeMachineRunner должен")
class CoffeeMachineRunnerTest {
    private final UI ui = mock(UI.class);
    private final CoffeeMachine machine = mock(CoffeeMachine.class);
    private CoffeeMachineRunner machineRunner;

    @Test
    @DisplayName("вызывать у машины метод покупки")
    public void shouldBuy() {
        given(ui.readString("Write action (buy, fill, take):"))
                .willReturn("buy");
        given(ui.readInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:"))
                .willReturn(1);
        machineRunner = new CoffeeMachineRunner(machine, ui);
        machineRunner.run();
        verify(machine, atLeastOnce()).buy(any());
    }

    @Test
    @DisplayName("вызывать у машины методы заполнения припасами")
    public void shouldFill() {
        given(ui.readString("Write action (buy, fill, take):"))
                .willReturn("fill");
        given(ui.readInt("Write how many ml of water do you want to add:"))
                .willReturn(100);
        given(ui.readInt("Write how many ml of milk do you want to add:"))
                .willReturn(50);
        given(ui.readInt("Write how many grams of coffee beans do you want to add:"))
                .willReturn(10);
        given(ui.readInt("Write how many disposable cups of coffee do you want to add:"))
                .willReturn(3);
        machineRunner = new CoffeeMachineRunner(machine, ui);
        machineRunner.run();
        verify(machine, atLeastOnce()).addWater(100);
        verify(machine, atLeastOnce()).addMilk(50);
        verify(machine, atLeastOnce()).addBeans(10);
        verify(machine, atLeastOnce()).addCups(3);
    }

    @Test
    @DisplayName("позволять забрать деньги")
    public void shouldAllowToTakeMoney() {
        given(ui.readString("Write action (buy, fill, take):"))
                .willReturn("take");
        machineRunner = new CoffeeMachineRunner(machine, ui);
        machineRunner.run();
        verify(machine, atLeastOnce()).takeMoney();
    }
}
