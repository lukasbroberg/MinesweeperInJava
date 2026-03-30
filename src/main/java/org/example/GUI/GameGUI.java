package org.example.GUI;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Controller.GameController;
import org.example.Controller.GameState;
import org.example.GUI.Dialogs.NewGameDialog;
import org.example.GUI.Dialogs.NextChoiceDialog;
import org.example.entities.Board;
import org.example.entities.BombField;
import org.example.entities.Field;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameGUI extends GridPane {

    public GameController gameController;
    public Button[][] fieldButtons;
    private Stage mainStage;



    public GameGUI(GameController gameController, Stage mainStage){
        this.gameController=gameController;
        this.mainStage=mainStage;

        this.setBackground(Background.fill(Color.rgb(225,225,225)));
        this.setPadding(new Insets(25,25,25,20));
    }


    public void update(){

        this.getChildren().clear();

        Board board = gameController.board;

        //Update board grid
        for(var i=0; i<board.getAmountOfFieldsX(); i++){
            for(var j=0; j<board.getAmountOfFieldsY(); j++){
                var field = board.getField(i,j);

                Button button = new FieldGUI(field);
                setRowIndex(button,i);
                setColumnIndex(button,j);
                button.setMaxWidth(35.0);
                button.setMaxHeight(35.0);
                button.setMinWidth(35.0);
                button.setMinHeight(35.0);

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
            Alert scoreDialog = new Alert(Alert.AlertType.INFORMATION);
            scoreDialog.setContentText("You lost");
            scoreDialog.setHeaderText("You lost." + "\nRevealed fields: " + gameController.revealedFieldsCounter.getValue());
            scoreDialog.showAndWait();

            NextChoiceDialog nextChoiceDialog = new NextChoiceDialog(
                    gameController,
                    () -> {
                            startNewGame();
                        },
                    () -> {Platform.exit();}
            );
            nextChoiceDialog.show();
        }

        if(gameController.getState()==GameState.HASWON){
            Alert wonDialog = new Alert(Alert.AlertType.INFORMATION);
            wonDialog.setContentText("You won");
            wonDialog.setHeaderText("You won!" + "\nRevealed fields: " + gameController.revealedFieldsCounter.getValue());
            wonDialog.showAndWait();

            NextChoiceDialog nextChoiceDialog = new NextChoiceDialog(
                    gameController,
                    () -> {
                            startNewGame();
                        },
                    () -> {Platform.exit();}
            );
            nextChoiceDialog.show();

        }
    }

    public void startNewGame(){
        NewGameDialog newGameDialog = new NewGameDialog(
                gameController,
                (amountOfFieldsX,amountOfFieldsY, difficulty) -> {
                    gameController.startGame(amountOfFieldsX,amountOfFieldsY, difficulty);
                    update();
                }
        );
        newGameDialog.show();

        mainStage.sizeToScene();

    }
}
