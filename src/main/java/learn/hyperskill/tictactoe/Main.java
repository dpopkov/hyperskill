package learn.hyperskill.tictactoe;

public class Main {

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer('X', 'O');
        Game game = new Game(analyzer, System.in, System.out);
        game.run();
    }
}
