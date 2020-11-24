package learn.hyperskill.coffeemachine;

import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleContext {
    private final PrintStream out;
    private final InputStream in;

    public ConsoleContext(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    public PrintStream getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }
}
