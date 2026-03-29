package org.example.GUI.Dialogs;

import javafx.scene.control.ChoiceDialog;
import org.example.Controller.GameController;

public class NewGameDialog {

    private GameController gameController;
    private ChoiceDialog boardSizeDialog = new ChoiceDialog("4x4", "8x8", "12x12", "16x16");
    private ChoiceDialog difficulty = new ChoiceDialog("Easy", "Normal", "Hard");

    public NewGameDialog(GameController gameController){
        this.gameController=gameController;
    }
}
