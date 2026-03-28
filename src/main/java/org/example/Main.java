package org.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.example.Controller.GameController;
import org.example.GUI.GameGUI;
import org.example.GUI.HudGUI;
import org.example.entities.Board;

import javafx.stage.*;

public class Main extends Application {

    private Stage stage;

    private Pane root;

    private GameGUI gameGUI;

    private HudGUI hudGUI;

    private GameController gameController;

    /** Initializes window and application
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{

        //Initialize window
        this.stage=stage;

        root = new Pane();

        Scene scene = new Scene(this.root,800,800);

        this.stage.setTitle("Minesweeper");
        this.stage.setScene(scene);
        this.stage.show();

        //Initialize HUD
        this.hudGUI = new HudGUI();

        //Initialize game:
        this.gameController = new GameController();
        gameController.startGame();


        gameGUI = new GameGUI(gameController);
        gameGUI.update();

        VBox vbox = new VBox(hudGUI, gameGUI);

        this.root.getChildren().add(vbox);
    }

    /** Initializes GUI on window
     *
     */
    public void addGUI(){

    }

    public static void main(String[] args) {
        launch(args);
    }


}

