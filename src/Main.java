import controller.GameController;
import exceptions.InvalidMoveException;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
//        Game game = new gameController.startGame();
        int dimension = scanner.nextInt();
        List<Player> players =  List.of(
            new Player("me", new Symbol('X'), PlayerType.HUMAN),
                new BOT("sc",new Symbol('O'),PlayerType.BOT,BOTDifficulty.EASY)
        );
        Game game = gameController.startGame(dimension,players);
//        gameController.printBoard(game);

        while(game.getGameState().equals(GameState.INPROGRESS)){
            gameController.printBoard(game);

            gameController.makeMove(game);
        }
        if(!gameController.checkState(game).equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("Game draw");
        }
        else{
            System.out.println("Player " + gameController.getWinner(game).getName() + " is winner");
        }
    }
}