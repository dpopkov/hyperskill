package learn.hyperskill.coffeemachine;

public class Recipe {
    private final String name;
    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int price;

    public Recipe(String name, int water, int milk, int coffeeBeans, int price) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getPrice() {
        return price;
    }
}
