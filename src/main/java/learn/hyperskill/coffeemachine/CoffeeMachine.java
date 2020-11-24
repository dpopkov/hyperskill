package learn.hyperskill.coffeemachine;

public interface CoffeeMachine {

    void buy(Recipe recipe);

    String stateToString();

    void addWater(int amount);

    void addMilk(int amount);

    void addBeans(int amount);

    void addCups(int amount);

    int takeMoney();

    MachineState getState();
}
