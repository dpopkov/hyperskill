package learn.hyperskill.coffeemachine;

import java.util.Objects;

public class MachineState {
    private static final String NL = System.lineSeparator();

    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int cups;
    private final int money;

    public MachineState(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public String toString() {
        return "The coffee machine has:" + NL +
                water + " of water" + NL +
                milk + " of milk" + NL +
                coffeeBeans + " of coffee beans" + NL +
                cups + " of disposable cups" + NL +
                money + " of money";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineState that = (MachineState) o;
        return water == that.water &&
                milk == that.milk &&
                coffeeBeans == that.coffeeBeans &&
                cups == that.cups &&
                money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(water, milk, coffeeBeans, cups, money);
    }
}
