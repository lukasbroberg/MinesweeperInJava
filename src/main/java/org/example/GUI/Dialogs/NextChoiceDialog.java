package org.example.GUI.Dialogs;

import javafx.application.Platform;
import javafx.scene.control.ChoiceDialog;
import org.example.Controller.GameController;

public class NextChoiceDialog {

    private GameController gameController;
    private Runnable onNewGame;
    private Runnable onEndGame;

    public NextChoiceDialog(GameController gameController, Runnable onNewGame, Runnable onEndGame){
        this.gameController=gameController;
        this.onEndGame=onEndGame;
        this.onNewGame=onNewGame;
    }

    public void show(){

        ChoiceDialog nextChoice = new ChoiceDialog("Start new game", "Close app");
                nextChoice.setHeaderText("New game?");
                nextChoice.showAndWait();

        String nextChoiceResult = nextChoice.getResult().toString();
                if(nextChoiceResult==null) return;

                switch (nextChoiceResult.toLowerCase()){
            case ("start new game") -> {
                onNewGame.run();
                /*gameController.startGame();
                update();*/
            }

            case ("close app") -> {
                onEndGame.run();
                //Platform.exit();
            }
        }
    }

}
