package org.example.GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.entities.BombField;
import org.example.entities.Field;

public class FieldGUI extends Button {

    boolean isRevealed;
    int size;
    int revealed = 0;

    public FieldGUI(Field field){
        this.isRevealed=field.isRevealed();

        if(isRevealed){
            this.setBorder(new Border(
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
                    )
            ));
        }else{
            this.setBorder(new Border(
                        new BorderStroke(
                                Color.rgb(255, 255, 255),  // top
                                Color.rgb(128, 128, 128),  // right
                                Color.rgb(128, 128, 128),  // bottom
                                Color.rgb(255, 255, 255),  // left
                                BorderStrokeStyle.SOLID,
                                BorderStrokeStyle.SOLID,
                                BorderStrokeStyle.SOLID,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                new BorderWidths(2),
                                Insets.EMPTY
                        )
                )
            );
        }


        if(field.isFlagged()){
            this.setText("F");
        }

        if(field.isRevealed()) {
            if (field instanceof BombField) {
                this.setText("B");
                this.setBackground(Background.fill(Color.rgb(255, 0, 0)));
                this.setTextFill(Color.rgb(255, 255, 255));
            } else {
                if (field.getNeighBombs() == 0) {
                    this.setText("");
                } else {
                    this.setText(String.valueOf(field.getNeighBombs()));
                }
                Color color;
                switch (field.getNeighBombs()) {
                    case 1:
                        color = Color.rgb(0, 0, 255);
                        break;
                    case 2:
                        color = Color.rgb(0, 255, 0);
                        break;
                    case 3:
                        color = Color.rgb(255, 0, 0);
                        break;
                    case 4:
                        color = Color.rgb(0, 0, 200);
                        break;
                    default:
                        color = Color.rgb(162, 48, 255);
                        break;
                }
                this.setTextFill(color);
            }
            this.setDisable(true);
            this.setStyle("""
                                 -fx-opacity: 1.0;
                            """);
        }
    }


}
