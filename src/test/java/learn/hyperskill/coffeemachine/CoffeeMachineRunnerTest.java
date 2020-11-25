package learn.hyperskill.coffeemachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static learn.hyperskill.coffeemachine.CoffeeMachineRunner.ACTION_PROMPT;
import static org.mockito.BDDMockito.*;

@DisplayName("CoffeeMachineRunner должен")
class CoffeeMachineRunnerTest {
    public static final String BUY_PROMPT =
            "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";

    private UI ui;
    private CoffeeMachine machine;
    private CoffeeMachineRunner machineRunner;

    @BeforeEach
    public void setUp() {
        ui = mock(UI.class);
        machine = mock(CoffeeMachine.class);
        machineRunner = new CoffeeMachineRunner(machine, ui);
    }

    @Test
    @DisplayName("вызывать у машины метод покупки")
    public void shouldBuy() {
        given(ui.readString(ACTION_PROMPT))
                .willReturn("buy").willReturn("exit");
        given(ui.readString(BUY_PROMPT))
                .willReturn("1");
        CheckResult check = mock(CheckResult.class);
        given(check.hasEnoughResources()).willReturn(true);
        given(machine.checkResourcesFor(any())).willReturn(check);
        machineRunner.addActions(Action.BUY);
        machineRunner.run();
        verify(machine, atLeastOnce()).buy(any());
    }

    @Test
    @DisplayName("вызывать у машины методы заполнения припасами")
    public void shouldFill() {
        given(ui.readString(ACTION_PROMPT))
                .willReturn("fill").willReturn("exit");
        given(ui.readInt("Write how many ml of water do you want to add:"))
                .willReturn(100);
        given(ui.readInt("Write how many ml of milk do you want to add:"))
                .willReturn(50);
        given(ui.readInt("Write how many grams of coffee beans do you want to add:"))
                .willReturn(10);
        given(ui.readInt("Write how many disposable cups of coffee do you want to add:"))
                .willReturn(3);
        machineRunner.addActions(Action.FILL);
        machineRunner.run();
        verify(machine, atLeastOnce()).addWater(100);
        verify(machine, atLeastOnce()).addMilk(50);
        verify(machine, atLeastOnce()).addBeans(10);
        verify(machine, atLeastOnce()).addCups(3);
    }

    @Test
    @DisplayName("позволять забрать деньги")
    public void shouldAllowToTakeMoney() {
        given(ui.readString(ACTION_PROMPT))
                .willReturn("take").willReturn("exit");
        machineRunner.addActions(Action.TAKE);
        machineRunner.run();
        verify(machine, atLeastOnce()).takeMoney();
    }

    @Test
    @DisplayName("выводить состояние машины")
    public void shouldPrintRemaining() {
        given(ui.readString(ACTION_PROMPT)).willReturn("remaining").willReturn("exit");
        machineRunner.addActions(Action.REMAINING);
        machineRunner.run();
        verify(machine, atLeastOnce()).stateToString();
    }
}
