package learn.hyperskill.coffeemachine;

public class Ingredients {
    private final int water;
    private final int milk;
    private final int beans;

    public Ingredients(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
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

    public int numCupsHasEnoughFor(Recipe recipe) {
        int cupsWater = water / recipe.water();
        int cupsMilk = milk / recipe.milk();
        int cupsBeans = beans / recipe.coffeeBeans();
        return Math.min(cupsWater, Math.min(cupsMilk, cupsBeans));
    }
}
