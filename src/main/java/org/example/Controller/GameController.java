package org.example.Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.example.entities.Board;
import org.example.entities.Field;


public class GameController {
    public Board board;

    private Enum state = GameState.INTRO;

    public IntegerProperty revealedFields = new SimpleIntegerProperty(0);

    public void startGame(){
        state = GameState.RUNNING;
        board = new Board();
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
        int revealed = this.board.revealField(field);
        if(revealed==-1){
            loseGame();
            return;
        }
        revealedFields.set(revealedFields.getValue()+revealed);
        //TODO: Check for winning here
    }

    public Enum getState() {
        return state;
    }

    public void flagField(Field field){
        this.board.flagField(field);
    }

}
