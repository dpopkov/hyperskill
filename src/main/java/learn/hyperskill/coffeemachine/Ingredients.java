package learn.hyperskill.coffeemachine;

public class Supplies {
    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;

    public Supplies(int water, int milk, int beans, int cups) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }

    public int water() {
        return water;
    }

    public int milk() {
        return milk;
    }

    public int beans() {
        return beans;
    }

    public int cups() {
        return cups;
    }

    public void takeFor(Recipe recipe, int amount) {
        // todo: implement and check (use exception)
    }

    public int numCupsHasEnoughFor(Recipe recipe) {
        int cupsWater = water / recipe.getWater();
        int cupsMilk = milk / recipe.getMilk();
        int cupsBeans = beans / recipe.getCoffeeBeans();
        return Math.min(cupsWater, Math.min(cupsMilk, cupsBeans));
    }
}
