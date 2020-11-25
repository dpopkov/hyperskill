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
        useWater(recipe.getWater());
        useMilk(recipe.getMilk());
        useCoffeeBeans(recipe.getCoffeeBeans());
        useCup();
        earnMoney(recipe.getPrice());
    }

    @Override
    public CheckResult checkResourcesFor(Recipe recipe) {
        String messagePrefix = "Sorry, not enough ";
        if (recipe.getWater() > water) {
            return CheckResult.negative(messagePrefix + "water!");
        } else if (recipe.getMilk() > milk) {
            return CheckResult.negative(messagePrefix + "milk!");
        } else if (recipe.getCoffeeBeans() > coffeeBeans) {
            return CheckResult.negative(messagePrefix + "coffee beans!");
        } else if (1 > cups) {
            return CheckResult.negative(messagePrefix + "cups!");
        }
        return CheckResult.positive();
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

    @Override
    public MachineState getState() {
        return new MachineState(water, milk, coffeeBeans, cups, money);
    }
}
