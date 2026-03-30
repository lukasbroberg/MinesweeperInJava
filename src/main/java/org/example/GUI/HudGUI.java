package org.example.GUI;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.Controller.GameController;

public class HudGUI extends HBox {

    private GameController gameController;

    private Label amountOfBombsLabel = new Label("Bombs");
    private Label amountOfBombsText = new Label("0");
    private Label revealedFieldsLabel = new Label("revealed fields");
    private Label revealedFieldsText = new Label("0");

    private VBox amountOfBombsBox = new VBox(amountOfBombsLabel,amountOfBombsText);
    private VBox revealedFieldsBox = new VBox(revealedFieldsLabel, revealedFieldsText);

    private Border border = new Border(
                new BorderStroke(
                    Color.rgb(128, 128, 128),  // top
                    Color.rgb(255, 255, 255),  // right
                    Color.rgb(255, 255, 255),  // bottom
                    Color.rgb(128, 128, 128),  // left
                    BorderStrokeStyle.SOLID,
                    BorderStrokeStyle.SOLID,
                    BorderStrokeStyle.SOLID,
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    new BorderWidths(2),
                    Insets.EMPTY
                )
    );


    public HudGUI(GameController gameController){
        this.gameController=gameController;

        this.getChildren().addAll(amountOfBombsBox,revealedFieldsBox);

        this.revealedFieldsText.textProperty().bind(Bindings.format("%d",gameController.revealedFieldsCounter));
        this.amountOfBombsText.textProperty().bind(Bindings.format("%d",gameController.amountOfBombsLeftCounter));

        this.revealedFieldsText.setBorder(border);
        this.amountOfBombsText.setBorder(border);

        this.revealedFieldsText.setBackground(Background.fill(Color.rgb(210,210,210)));
        this.amountOfBombsText.setBackground(Background.fill(Color.rgb(210,210,210)));




        this.revealedFieldsBox.setMaxWidth(Double.MAX_VALUE);
        this.amountOfBombsBox.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(revealedFieldsBox, Priority.ALWAYS);
        HBox.setHgrow(amountOfBombsBox, Priority.ALWAYS);

        this.setAlignment(Pos.CENTER);
        revealedFieldsBox.setAlignment(Pos.CENTER);
        amountOfBombsBox.setAlignment(Pos.CENTER);

        this.revealedFieldsText.setMaxWidth(80.0);
        this.amountOfBombsText.setMaxWidth(80.0);

        this.setBackground(Background.fill(Color.rgb(225,225,225)));



    }
}
