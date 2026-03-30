package org.example.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.Controller.GameController;
import org.example.Controller.GameState;

public class MainGUI extends StackPane {

    private HudGUI hudGUI;
    private GameGUI gameGUI;

    public MainGUI(GameController gameController){
        VBox layout = new VBox(80);


        hudGUI = new HudGUI(gameController);
        gameGUI = new GameGUI(gameController);

        layout.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(gameGUI, Priority.ALWAYS);

        layout.getChildren().addAll(hudGUI,gameGUI);

        this.getChildren().add(layout);

        gameGUI.startNewGame();
    }

}
