package org.example.GUI;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Controller.GameController;
import org.example.Controller.GameState;
import org.example.entities.Board;
import org.example.entities.BombField;
import org.example.entities.Field;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
                                gameController.revealField(board.getField(x,y));
                                update();
                            }else if(event.getButton()==MouseButton.SECONDARY){
                                gameController.flagField(board.getField(x,y));
                                update();
                            }
                        }
                );

                getChildren().add(
                        button
                );
            }
        }


        //Game is lost
        if(gameController.getState()== GameState.HASLOST){
            TextInputDialog scoreDialog = new TextInputDialog();
            scoreDialog.setContentText("What is your name?");
            scoreDialog.setHeaderText("You lost." + "\nRevealed fields: " + gameController.revealedFields + "\nOverall: ");
            scoreDialog.showAndWait();

            if(!scoreDialog.getResult().isBlank()){
                //Save new score here
            }


            ChoiceDialog nextChoice = new ChoiceDialog("Start new game", "Close app");
            nextChoice.setHeaderText("New game?");
            nextChoice.showAndWait();

            String nextChoiceResult = nextChoice.getResult().toString();
            if(nextChoiceResult==null) return;

            switch (nextChoiceResult.toLowerCase()){
                case ("start new game") -> {
                    //TODO Restart game here
                }

                case ("close app") -> {
                    Platform.exit();
                }

            }
        }

    }
}
