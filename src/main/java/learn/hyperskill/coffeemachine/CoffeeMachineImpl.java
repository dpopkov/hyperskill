package learn.hyperskill.coffeemachine;

import java.util.Map;

public class CoffeeMachineImpl implements ICoffeeMachine {
    private static final String NL = System.lineSeparator();

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

    public CoffeeMachineImpl(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    @Override
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

    @Override
    public String stateToString() {
        MachineState state = new MachineState(water, milk, coffeeBeans, cups, money);
        return state.toString();
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

    @Override
    public void addWater(int amount) {
        water += amount;
    }

    @Override
    public void addMilk(int amount) {
        milk += amount;
    }

    @Override
    public void addBeans(int amount) {
        coffeeBeans += amount;
    }

    @Override
    public void addCups(int amount) {
        cups += amount;
    }

    @Override
    public int takeMoney() {
        int take = money;
        money = 0;
        return take;
    }
}
