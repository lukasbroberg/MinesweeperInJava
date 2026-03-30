package org.example;

import org.example.Controller.GameController;
import org.example.entities.Board;
import org.example.entities.BombField;
import org.example.entities.Field;

import java.util.Stack;

public class IsolatedEnvironment {
    public static void main(String[] args){
        //Initialize game:

        //Setup board
        Board board = new Board(3,3, 0);

        board.setAmountOfFieldsX(3);
        board.setAmountOfFieldsY(3);

        board.setField(new BombField(0,0), 0, 0);
        board.setField(new BombField(1,0), 1, 0);
        board.setField(new BombField(2,0), 2, 0);
        board.setField(new BombField(0,1), 0, 1);
        board.setField(new BombField(0,2), 0, 2);
        board.setField(new BombField(2,1), 2, 1);
        board.setField(new BombField(2,2), 2, 2);
        board.setField(new BombField(1,2), 1, 2);

        Field middleField = new Field(1,1);
        board.setField(middleField,1,1);

        board.initializeFieldValues(board.getFields());

        System.out.println("---");
        board.getFieldNeighbours(middleField);

        System.out.println(middleField.getNeighBombs());

    }
}
