package learn.hyperskill.coffeemachine;

import java.io.PrintStream;
import java.util.Scanner;

public class CoffeeMachine {
    private static final String NL = System.lineSeparator();

    private final Scanner scanner;
    private final PrintStream out;
    private final Supplies supplies;
    private int money;

    public CoffeeMachine(Scanner scanner, PrintStream out, Supplies supplies) {
        this.supplies = supplies;
        this.scanner = scanner;
        this.out = out;
        money = 550;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int water = request(in, "Write how many ml of water the coffee machine has:");
        int milk = request(in, "Write how many ml of milk the coffee machine has:");
        int beans = request(in, "Write how many grams of coffee beans the coffee machine has:");

        Supplies supplies = new Supplies(water, milk, beans, 1000);
        CoffeeMachine coffeeMachine = new CoffeeMachine(in, System.out, supplies);
        coffeeMachine.start();
    }

    public void start() {
        out.println();
    }

    public String info() {
        return "The coffee machine has:" + NL +
                supplies.water() + " of water" + NL +
                supplies.milk() + " of milk" + NL +
                supplies.beans() + " of coffee beans" + NL +
                supplies.cups() + " of disposable cups" + NL +
                money + " of money" + NL;
    }

    public void buy(Recipe recipe, int amount) {
        int water = recipe.water();
        int milk = recipe.milk();
        int beans = recipe.coffeeBeans();
        // todo
    }

    private static int request(Scanner in, String prompts) {
        System.out.println(prompts);
        System.out.print("> ");
        return in.nextInt();
    }
}
