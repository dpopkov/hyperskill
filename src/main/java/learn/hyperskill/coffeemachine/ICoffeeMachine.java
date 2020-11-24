package learn.hyperskill.coffeemachine;

public interface ICoffeeMachine {

    void buy(int recipeId);

    String stateToString();

    void addWater(int amount);

    void addMilk(int amount);

    void addBeans(int amount);

    void addCups(int amount);

    int takeMoney();
}
