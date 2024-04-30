package controller;

import exceptions.InvalidMoveException;
import models.Game;
import models.GameState;
import models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players){
        //Validate if 2 player have same symbol or not
        // If same symbol throw some exception
        return new Game(dimension, players);
    }
    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }
    public GameState checkState (Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void printBoard(Game game){
        game.printBoard();
    }
}
