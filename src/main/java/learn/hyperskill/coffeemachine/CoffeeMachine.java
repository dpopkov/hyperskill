package learn.hyperskill.coffeemachine;

import java.util.Map;

public class CoffeeMachine {
    private static final String NL = System.lineSeparator();

    private final UI ui;
    private final Map<Integer, Recipe> recipes = Map.of(
            1, new Recipe("espresso", 250, 0, 16, 4),
            2, new Recipe("latte", 350, 75, 20, 7),
            3, new Recipe("cappuccino", 200, 100, 12, 6)
    );
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(UI ui, int water, int milk, int coffeeBeans, int cups, int money) {
        this.ui = ui;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void buy(int recipeId) {
        Recipe recipe = recipes.get(recipeId);
        if (recipe == null) {
            throw new IllegalArgumentException("Can not find a recipe with id " + recipeId);
        }
        useWater(recipe.getWater());
        useMilk(recipe.getMilk());
        useCoffeeBeans(recipe.getCoffeeBeans());
        useCup();
        earnMoney(recipe.getPrice());
    }

    public String stateToString() {
        return "The coffee machine has:" + NL +
                water + " of water" + NL +
                milk + " of milk" + NL +
                coffeeBeans + " of coffee beans" + NL +
                cups + " of disposable cups" + NL +
                money + " of money";
    }

    private void useWater(int amount) {
        water -= amount;
    }

    private void useMilk(int amount) {
        milk -= amount;
    }

    private void useCoffeeBeans(int amount) {
        coffeeBeans -= amount;
    }

    private void useCup() {
        cups--;
    }

    private void earnMoney(int amount) {
        money += amount;
    }

    public void addWater(int amount) {
        water += amount;
    }

    public void addMilk(int amount) {
        milk += amount;
    }

    public void addBeans(int amount) {
        coffeeBeans += amount;
    }

    public void addCups(int amount) {
        cups += amount;
    }

    private int takeMoney() {
        int take = money;
        money = 0;
        return take;
    }

    public void run() {
        String action = ui.readString("Write action (buy, fill, take):");
        if ("buy".equals(action)) {
            buy(ui.readInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:"));
        } else if ("fill".equals(action)) {
            addWater(ui.readInt("Write how many ml of water do you want to add:"));
            addMilk(ui.readInt("Write how many ml of milk do you want to add:"));
            addBeans(ui.readInt("Write how many grams of coffee beans do you want to add:"));
            addCups(ui.readInt("Write how many disposable cups of coffee do you want to add:"));
        } else if ("take".equals(action)) {
            ui.println("I gave you $" + takeMoney());
        }
    }

    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        CoffeeMachine machine = new CoffeeMachine(ui,400, 540, 120, 9, 550);
        System.out.println(machine.stateToString());
        System.out.println();
        machine.run();
        System.out.println();
        System.out.println(machine.stateToString());
    }
}
