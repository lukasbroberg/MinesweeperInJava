package org.example.Controller;

import org.example.entities.Board;

public class GameController {
    public Board board;

    private Enum state = gameState.INTRO;

    public int revealedFields;

    public void startGame(){
        state = gameState.RUNNING;
        board = new Board();
    }

    public void loseGame(){
        state = gameState.HASLOST;
    }

}
