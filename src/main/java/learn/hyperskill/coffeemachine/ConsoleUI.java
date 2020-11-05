package learn.hyperskill.coffeemachine;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private final Scanner in = new Scanner(System.in);

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        return in.nextInt();
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        return in.nextLine();
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }
}
