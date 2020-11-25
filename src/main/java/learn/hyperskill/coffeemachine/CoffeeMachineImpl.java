package learn.hyperskill.coffeemachine;

public class CoffeeMachineImpl implements CoffeeMachine {
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
    public void buy(Recipe recipe) {
        consumeWater(recipe.getWater());
        consumeMilk(recipe.getMilk());
        consumeCoffeeBeans(recipe.getCoffeeBeans());
        consumeCup();
        earnMoney(recipe.getPrice());
    }

    @Override
    public CheckResult checkResourcesFor(Recipe recipe) {
        String messageFormat = "Sorry, not enough %s!";
        if (recipe.getWater() > water) {
            return CheckResult.negative(messageFormat, "water");
        } else if (recipe.getMilk() > milk) {
            return CheckResult.negative(messageFormat, "milk");
        } else if (recipe.getCoffeeBeans() > coffeeBeans) {
            return CheckResult.negative(messageFormat, "coffee beans");
        } else if (1 > cups) {
            return CheckResult.negative(messageFormat, "cups");
        }
        return CheckResult.positive();
    }

    @Override
    public String stateToString() {
        MachineState state = new MachineState(water, milk, coffeeBeans, cups, money);
        return state.toString();
    }

    private void consumeWater(int amount) {
        water -= amount;
    }

    private void consumeMilk(int amount) {
        milk -= amount;
    }

    private void consumeCoffeeBeans(int amount) {
        coffeeBeans -= amount;
    }

    private void consumeCup() {
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

    @Override
    public MachineState getState() {
        return new MachineState(water, milk, coffeeBeans, cups, money);
    }
}
