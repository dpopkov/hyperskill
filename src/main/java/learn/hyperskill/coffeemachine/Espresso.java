package learn.hyperskill.coffeemachine;

@SuppressWarnings("SameReturnValue")
public class Espresso implements Recipe {
    @Override
    public int water() {
        return 200;
    }

    @Override
    public int milk() {
        return 50;
    }

    @Override
    public int coffeeBeans() {
        return 15;
    }

    @Override
    public int cost() {
        return 4;
    }
}
