package learn.hyperskill.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int numCups = in.nextInt();
        Recipe recipe = new Recipe();
        int water = recipe.water() * numCups;
        int milk = recipe.milk() * numCups;
        int beans = recipe.coffeeBeans() * numCups;
        System.out.printf("For %d cups of coffee you will need:%n", numCups);
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", beans);
    }
}
