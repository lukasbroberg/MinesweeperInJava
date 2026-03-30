package org.example.Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.example.entities.Board;
import org.example.entities.BombField;
import org.example.entities.Field;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    public Board board;

    private Enum state = GameState.INTRO;

    public IntegerProperty revealedFieldsCounter = new SimpleIntegerProperty(0);
    public IntegerProperty amountOfBombsLeftCounter = new SimpleIntegerProperty(0);

    public List<String> difficulty = List.of("easy", "normal", "hard");

    public void startGame(int amountOfFieldsX, int amountOfFieldsY, int difficultyFactor){
        this.revealedFieldsCounter.set(0);
        int amountOfBombs = (int) Math.abs(amountOfFieldsX*amountOfFieldsX)/difficultyFactor;
        board = new Board(amountOfFieldsX,amountOfFieldsY, amountOfBombs);
        state = GameState.RUNNING;
        amountOfBombsLeftCounter.set(board.bombFieldList.size());
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

        //Check for first reveal bomb:
        if(this.revealedFieldsCounter.getValue()==0 && field instanceof BombField){
            int x = field.getX();
            int y = field.getY();

            this.board.createBomb(field.getX(),field.getY()); // Create duplicate Bomb to move the bomb.
            this.board.setField(new Field(x, y),x,y);
        }

        int revealed = this.board.revealField(field);



        //Check for losing here
        if(revealed==-1){
            loseGame();
            return;
        }

        revealedFieldsCounter.set(revealedFieldsCounter.getValue()+revealed);

        //Check for winning here
        if(revealedFieldsCounter.getValue()==(board.totalAmountOfFields-board.bombFieldList.size())){
            winGame();
        }
    }

    public Enum getState() {
        return state;
    }

    public void flagField(Field field){
        this.board.flagField(field);
        amountOfBombsLeftCounter.set(amountOfBombsLeftCounter.getValue()-1);
    }

}
