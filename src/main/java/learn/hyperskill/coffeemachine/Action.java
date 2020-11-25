package learn.hyperskill.coffeemachine;

public abstract class Action implements Runnable {
    public static final Action BUY = new Buy();
    public static final Action FILL = new Fill();
    public static final Action TAKE = new Take();
    public static final Action REMAINING = new Remaining();

    private final String name;
    protected UI ui;
    protected CoffeeMachine machine;

    public Action(String name) {
        this.name = name;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public void setMachine(CoffeeMachine machine) {
        this.machine = machine;
    }

    public String name() {
        return name;
    }

    private static class Buy extends Action {
        public static final String BUY_PROMPT =
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";

        private Buy() {
            super("buy");
        }

        @Override
        public void run() {
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
        }
    }

    private static class Fill extends Action {
        private Fill() {
            super("fill");
        }

        @Override
        public void run() {
            machine.addWater(ui.readInt("Write how many ml of water do you want to add:"));
            machine.addMilk(ui.readInt("Write how many ml of milk do you want to add:"));
            machine.addBeans(ui.readInt("Write how many grams of coffee beans do you want to add:"));
            machine.addCups(ui.readInt("Write how many disposable cups of coffee do you want to add:"));
        }
    }

    private static class Take extends Action {
        private Take() {
            super("take");
        }

        @Override
        public void run() {
            int money = machine.takeMoney();
            ui.println("I gave you $" + money);
        }
    }

    private static class Remaining extends Action {
        private Remaining() {
            super("remaining");
        }

        @Override
        public void run() {
            String state = machine.stateToString();
            ui.println(state);
        }
    }
}
