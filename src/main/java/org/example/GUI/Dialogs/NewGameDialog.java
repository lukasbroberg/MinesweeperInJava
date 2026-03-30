package org.example.GUI.Dialogs;

import javafx.scene.control.ChoiceDialog;
import org.example.Controller.GameController;

public class NewGameDialog {

    private GameController gameController;
    private ChoiceDialog boardSizeDialog = new ChoiceDialog("4x4", "8x8", "12x12", "16x16");
    private ChoiceDialog difficultyDialog = new ChoiceDialog("Easy", "Normal", "Hard");

    private StartGameCallBack startGame;

    public String sizeChoice;
    public String difficultyChoice;

    public NewGameDialog(GameController gameController, StartGameCallBack startGame){
        this.gameController=gameController;
        this.startGame=startGame;
    }

    public void show(){
        boardSizeDialog.setHeaderText("Choose board size");
        boardSizeDialog.showAndWait();

        String sizeResult = boardSizeDialog.getResult().toString();

        difficultyDialog.setHeaderText("Choose difficulty");
        difficultyDialog.showAndWait();

        String difficultyResult = difficultyDialog.getResult().toString();

        if(difficultyResult.isBlank() || sizeResult.isBlank()){
            //Throw exception here
        }

        int difficultyFactor = 4; // default
        int sizeFactor = 4; //default

        switch (sizeResult.toLowerCase()){
            case "4x4":
                sizeFactor=4;
                break;

            case "8x8":
                sizeFactor=8;
                break;

            case "12x12":
                sizeFactor=12;
                break;

            case "16x16":
                sizeFactor=16;
                break;
        }

        switch (difficultyResult.toLowerCase()){
            case "easy":
                difficultyFactor=8;
                break;

            case "normal":
                difficultyFactor=4;
                break;

            case "hard":
                difficultyFactor=2;
                break;
        }

        startGame.start(sizeFactor, sizeFactor, difficultyFactor);

    }
}
