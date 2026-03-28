package org.example.GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Controller.GameController;
import org.example.entities.Board;
import org.example.entities.BombField;
import org.example.entities.Field;

import javax.swing.*;

public class GameGUI extends GridPane {

    public GameController gameController;
    public Button[][] fieldButtons;

    public GameGUI(GameController gameController){
        this.gameController=gameController;
    }

    public void update(){
        this.getChildren().clear();

        Board board = gameController.board;

        //Update board grid
        for(var i=0; i<board.getAmountOfFieldsX(); i++){
            for(var j=0; j<board.getAmountOfFieldsY(); j++){
                var field = board.getField(i,j);

                Button button = new FieldGUI(field.revealed);
                setRowIndex(button,i);
                setColumnIndex(button,j);
                button.setMaxWidth(35.0);
                button.setMaxHeight(35.0);
                button.setMinWidth(35.0);
                button.setMinHeight(35.0);

                if(field.isFlagged()){
                    button.setText("F");
                }


                if(field.revealed){
                    if(field instanceof BombField){
                        button.setText("B");
                    }else{
                        button.setText(String.valueOf(field.neighBombs));
                    }
                    button.setDisable(true);

                    button.setBorder(new Border(
                            new BorderStroke(
                                    Color.rgb(20, 20, 20),  // top
                                    Color.rgb(20, 20, 20),  // right
                                    Color.rgb(20, 20, 20),  // bottom
                                    Color.rgb(20, 20, 20),  // left
                                    BorderStrokeStyle.SOLID,
                                    BorderStrokeStyle.SOLID,
                                    BorderStrokeStyle.SOLID,
                                    BorderStrokeStyle.SOLID,
                                    CornerRadii.EMPTY,
                                    new BorderWidths(1),
                                    Insets.EMPTY
                            )
                    ));

                }else{
                    button.setBorder(new Border(
                            new BorderStroke(
                                    Color.rgb(255, 255, 255),  // top
                                    Color.rgb(128, 128, 128),  // right
                                    Color.rgb(128, 128, 128),  // bottom
                                    Color.rgb(255, 255, 255),  // left
                                    BorderStrokeStyle.SOLID,
                                    BorderStrokeStyle.SOLID,
                                    BorderStrokeStyle.SOLID,
                                    BorderStrokeStyle.SOLID,
                                    CornerRadii.EMPTY,
                                    new BorderWidths(2),
                                    Insets.EMPTY
                            )
                    ));
                }

                int x = i;
                int y = j;

                button.setOnMousePressed(
                        event-> {
                            if(event.getButton()== MouseButton.PRIMARY){
                                gameController.board.revealField(board.getField(x,y));
                                update();
                            }else if(event.getButton()==MouseButton.SECONDARY){
                                gameController.board.flagField(board.getField(x,y));
                                update();
                            }
                        }
                );

                getChildren().add(
                        button
                );
            }
        }
    }
}
