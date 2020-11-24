package learn.hyperskill.coffeemachine;

public class CoffeeMachineRunner {
    private final CoffeeMachine machine;
    private final UI ui;

    public CoffeeMachineRunner(CoffeeMachine machine, UI ui) {
        this.machine = machine;
        this.ui = ui;
    }

    public void run() {
        ui.println(machine.stateToString());
        ui.println("");
        String action = ui.readString("Write action (buy, fill, take):");
        if ("buy".equals(action)) {
            int id = ui.readInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            machine.buy(Recipes.byId(id));
        } else if ("fill".equals(action)) {
            machine.addWater(ui.readInt("Write how many ml of water do you want to add:"));
            machine.addMilk(ui.readInt("Write how many ml of milk do you want to add:"));
            machine.addBeans(ui.readInt("Write how many grams of coffee beans do you want to add:"));
            machine.addCups(ui.readInt("Write how many disposable cups of coffee do you want to add:"));
        } else if ("take".equals(action)) {
            int money = machine.takeMoney();
            ui.println("I gave you $" + money);
        }
        ui.println("");
        ui.println(machine.stateToString());
    }
}
