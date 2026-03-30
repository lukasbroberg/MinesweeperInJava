package org.example.Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.example.entities.Board;
import org.example.entities.Field;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    public Board board;

    private Enum state = GameState.INTRO;

    public IntegerProperty revealedFields = new SimpleIntegerProperty(0);

    public List<String> difficulty = List.of("easy", "normal", "hard");

    public void startGame(int amountOfFieldsX, int amountOfFieldsY, int difficultyFactor){
        this.revealedFields.set(0);
        int amountOfBombs = (int) Math.abs(amountOfFieldsX*amountOfFieldsX)/difficultyFactor;
        board = new Board(amountOfFieldsX,amountOfFieldsY, amountOfBombs);
        state = GameState.RUNNING;
    }

    public void winGame(){
        state = GameState.HASWON;
    }

    public void loseGame(){
        state = GameState.HASLOST;
        this.board.revealBombs();
    }

    /** revealField in Game Controller changes gameState based on the field
     *
     * @param field
     */
    public void revealField(Field field){
        if(state==GameState.HASLOST){
            return;
        }

        int revealed = this.board.revealField(field);

        //Check for losing here
        if(revealed==-1){
            loseGame();
            return;
        }

        revealedFields.set(revealedFields.getValue()+revealed);

        //Check for winning here
        if(revealedFields.getValue()==(board.totalAmountOfFields-board.bombFieldList.size())){
            winGame();
        }
    }

    public Enum getState() {
        return state;
    }

    public void flagField(Field field){
        this.board.flagField(field);
    }

}
