package org.example.GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HudGUI extends HBox {
    private Label scoreLabel = new Label("Hello");
    private Label scoreText = new Label("0");
    private Label revealedFieldsLabel = new Label("revealed fields");
    private Label revealedFieldsText = new Label("0");

    private VBox scoreBox = new VBox(scoreLabel,scoreText);
    private VBox revealedFieldsBox = new VBox(revealedFieldsLabel, revealedFieldsText);

    public HudGUI(){
        this.getChildren().addAll(scoreBox,revealedFieldsBox);

        this.revealedFieldsText.setBorder(new Border(
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
                ))
        );

        this.scoreText.setBorder(new Border(
                new BorderStroke(
                        Color.rgb(255, 255, 255),  // top
                        Color.rgb(20, 20, 20),  // right
                        Color.rgb(20, 20, 20),  // bottom
                        Color.rgb(255, 255, 255),  // left
                        BorderStrokeStyle.SOLID,
                        BorderStrokeStyle.SOLID,
                        BorderStrokeStyle.SOLID,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(1),
                        Insets.EMPTY
                ))
        );


    }
}
