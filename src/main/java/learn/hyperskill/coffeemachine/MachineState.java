package learn.hyperskill.coffeemachine;

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
}
