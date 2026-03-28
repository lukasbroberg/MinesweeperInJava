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
import org.example.GUI.MainGUI;
import org.example.entities.Board;

import javafx.stage.*;

public class Main extends Application {

    private Stage stage;

    private Pane root;

    private MainGUI mainGUI;

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

        //Initialize game:
        //TODO this should be changed to a menu press:
        this.gameController = new GameController();
        gameController.startGame();

        mainGUI = new MainGUI(gameController);

        this.root.getChildren().add(mainGUI);
    }

    public static void main(String[] args) {
        launch(args);
    }


}

