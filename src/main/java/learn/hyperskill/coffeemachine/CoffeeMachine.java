package learn.hyperskill.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int water = request(in, "Write how many ml of water the coffee machine has:");
        int milk = request(in, "Write how many ml of milk the coffee machine has:");
        int beans = request(in, "Write how many grams of coffee beans the coffee machine has:");
        int needNumCups = request(in, "Write how many cups of coffee you will need:");
        Ingredients ingredients = new Ingredients(water, milk, beans);
        int realNumCups = ingredients.numCupsHasEnoughFor(new Recipe());
        System.out.println(new MessageProducer().message(needNumCups, realNumCups));
    }

    private static int request(Scanner in, String prompts) {
        System.out.println(prompts);
        System.out.print("> ");
        return in.nextInt();
    }
}
