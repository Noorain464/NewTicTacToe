package winningstrategy;

import models.Board;
import models.Move;

import java.util.HashMap;

public class WinningAlgo {
    HashMap<Integer,HashMap<Character,Integer>> rowmap = new HashMap<>();
    HashMap<Integer,HashMap<Character,Integer>> colmap = new HashMap<>();
    HashMap<Character,Integer> leftdiagonalmap = new HashMap<>();
    HashMap<Character,Integer> rightdiagonalmap = new HashMap<>();

    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getChar();

        if(rowmap.containsKey(row)){
            rowmap.put(row,new HashMap<>());
        }
        HashMap<Character,Integer> currrowmap = rowmap.get(row);
        if(!currrowmap.containsKey(character)){
            currrowmap.put(character,1);
        }
        else{
            currrowmap.put(character,currrowmap.get(character)+1);
        }
        if(currrowmap.get(character)== board.getSize()){
            return true;
        }

        if(colmap.containsKey(col)){
            colmap.put(row,new HashMap<>());
        }
        HashMap<Character,Integer> currcolmap = colmap.get(col);
        if(!currcolmap.containsKey(character)){
            currcolmap.put(character,1);
        }
        else{
            currcolmap.put(character,currcolmap.get(character)+1);
        }
        if(currcolmap.get(character)== board.getSize()){
            return true;
        }
        if(row == col){
            if(!leftdiagonalmap.containsKey(character)){
                leftdiagonalmap.put(character,1);
            }
            else{
                leftdiagonalmap.put(character, leftdiagonalmap.get(character) + 1);
            }
            if(leftdiagonalmap.get(character)== board.getSize()){
                return true;
            }
        }
        if(row + col == board.getSize() - 1){
            if(!rightdiagonalmap.containsKey(character)){
                rightdiagonalmap.put(character,1);
            }
            else{
                rightdiagonalmap.put(character, rightdiagonalmap.get(character) + 1);
            }
            if(rightdiagonalmap.get(character)== board.getSize()){
                return true;
            }
        }
        return false;
    }

}
