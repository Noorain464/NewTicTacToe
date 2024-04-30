package models;

import java.util.List;

public class BOT extends Player {
    private BOTDifficulty difficulty;

    public BOT(String name, Symbol symbol, PlayerType playerType, BOTDifficulty difficulty) {
        super(name, symbol, playerType);
        this.difficulty = difficulty;
    }
    @Override
    public Move makeMove(Board board) {
        //Find the first empty cell and make the move
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                     return new Move(cell,this);
                }
            }
        }
        return null;
    }
}
