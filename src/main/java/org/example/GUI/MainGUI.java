package org.example.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Controller.GameController;
import org.example.Controller.GameState;

public class MainGUI extends StackPane {

    private HudGUI hudGUI;
    private GameGUI gameGUI;

    public MainGUI(GameController gameController, Stage mainStage){
        VBox layout = new VBox();

        hudGUI = new HudGUI(gameController);
        gameGUI = new GameGUI(gameController, mainStage);

        layout.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(gameGUI, Priority.ALWAYS);
        hudGUI.setMaxWidth(Double.MAX_VALUE);
        hudGUI.setAlignment(Pos.CENTER);



        layout.getChildren().addAll(hudGUI,gameGUI);

        this.getChildren().add(layout);

        gameGUI.startNewGame();
    }

}
