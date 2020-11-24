package learn.hyperskill.coffeemachine;

public enum Recipes implements Recipe {
    ESPRESSO(1,"espresso", 250, 0, 16, 4),
    LATTE(2, "latte", 350, 75, 20, 7),
    CAPPUCCINO(3,"cappuccino", 200, 100, 12, 6);

    private final int id;
    private final String name;
    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int price;

    Recipes(int id, String name, int water, int milk, int coffeeBeans, int price) {
        this.id = id;
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
    }

    public static Recipes byId(int id) {
        for (Recipes r : values()) {
            if (r.id == id) {
                return r;
            }
        }
        throw new IllegalArgumentException("Cannot find recipe with id " + id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWater() {
        return water;
    }

    @Override
    public int getMilk() {
        return milk;
    }

    @Override
    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
