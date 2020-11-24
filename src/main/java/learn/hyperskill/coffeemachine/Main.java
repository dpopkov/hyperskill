package learn.hyperskill.coffeemachine;

public class Main {
    public static void main(String[] args) {
        UI ui = new ConsoleUI(new ConsoleContext(System.out, System.in));
        CoffeeMachine machine = new CoffeeMachineImpl(400, 540, 120, 9, 550);
        CoffeeMachineRunner runner = new CoffeeMachineRunner(machine, ui);
        runner.run();
    }
}
