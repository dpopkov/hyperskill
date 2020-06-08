package learn.hyperskill.tictactoe;

public enum State {
    IMPOSSIBLE("Impossible"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    NOT_FINISHED("Game not finished"),
    DRAW("Draw");

    State(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
