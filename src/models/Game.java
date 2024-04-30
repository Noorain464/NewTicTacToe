package models;

import exceptions.InvalidMoveException;
import winningstrategy.WinningAlgo;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private WinningAlgo winningAlgo;
    public Game(int dimension,List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.INPROGRESS;
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.winningAlgo = new WinningAlgo();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public void printBoard(){
        this.board.printBoard();
    }
    private boolean validateMove(Move move){
        int row =move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || row > board.getSize() || col < 0 || col > board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }
    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + " move");
        //Move that currentPlayer wants to make
        Move move = currentPlayer.makeMove(board);
        //Game will validate the move
        if(!validateMove(move)){
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell celltoChange = board.getBoard().get(row).get(col);
        celltoChange.setPlayer(currentPlayer);
        celltoChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(celltoChange,currentPlayer);
        moves.add(finalMove);
        nextPlayerIndex = (nextPlayerIndex + 1)%players.size();

        if(winningAlgo.checkWinner(board,finalMove)){
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }
    }
}
