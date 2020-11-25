package learn.hyperskill.coffeemachine;

public class CoffeeMachineRunner {
    public static final String ACTION_PROMPT = "Write action (buy, fill, take, remaining, exit):";
    public static final String BUY_PROMPT =
            "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";

    private final CoffeeMachine machine;
    private final UI ui;

    public CoffeeMachineRunner(CoffeeMachine machine, UI ui) {
        this.machine = machine;
        this.ui = ui;
    }

    public void run() {
        while (true) {
            String action = ui.readString(ACTION_PROMPT);
            if ("exit".equals(action)) {
                break;
            }
            ui.println("");
            if ("buy".equals(action)) {
                String ans = ui.readString(BUY_PROMPT);
                if (!"back".equals(ans)){
                    int id = Integer.parseInt(ans);
                    Recipes recipe = Recipes.byId(id);
                    CheckResult check = machine.checkResourcesFor(recipe);
                    ui.println(check.getMessage());
                    if (check.hasEnoughResources()) {
                        machine.buy(recipe);
                    }
                }
            } else if ("fill".equals(action)) {
                machine.addWater(ui.readInt("Write how many ml of water do you want to add:"));
                machine.addMilk(ui.readInt("Write how many ml of milk do you want to add:"));
                machine.addBeans(ui.readInt("Write how many grams of coffee beans do you want to add:"));
                machine.addCups(ui.readInt("Write how many disposable cups of coffee do you want to add:"));
            } else if ("take".equals(action)) {
                int money = machine.takeMoney();
                ui.println("I gave you $" + money);
            } else if ("remaining".equals(action)) {
                String state = machine.stateToString();
                ui.println(state);
            }
            ui.println("");
        }
    }
}
