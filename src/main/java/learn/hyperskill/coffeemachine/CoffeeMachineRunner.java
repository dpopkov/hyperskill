package learn.hyperskill.coffeemachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoffeeMachineRunner {
    public static final String ACTION_PROMPT = "Write action (buy, fill, take, remaining, exit):";

    private final CoffeeMachine machine;
    private final UI ui;
    private final List<Action> actions = new ArrayList<>();

    public CoffeeMachineRunner(CoffeeMachine machine, UI ui) {
        this.machine = machine;
        this.ui = ui;
    }

    public void addActions(Action... actions) {
        for (Action a : actions) {
            a.setUi(ui);
            a.setMachine(machine);
            this.actions.add(a);
        }
    }

    public void run() {
        if (actions.isEmpty()) {
            throw new IllegalStateException("Actions are not initialized yet");
        }
        while (true) {
            String action = ui.readString(ACTION_PROMPT);
            if ("exit".equals(action)) {
                break;
            }
            ui.println("");
            actionByName(action).ifPresentOrElse(Runnable::run,
                    () -> ui.println("No such action: " + action));
            ui.println("");
        }
    }

    private Optional<Action> actionByName(String actionName) {
        for (Action a : actions) {
            if (a.name().equals(actionName)) {
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}
