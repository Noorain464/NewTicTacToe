package models;

public class BOT extends Player {
    private BOTDifficulty difficulty;

    public BOT(String name, Symbol symbol, PlayerType playerType, BOTDifficulty difficulty) {
        super(name, symbol, playerType);
        this.difficulty = difficulty;
    }
}
