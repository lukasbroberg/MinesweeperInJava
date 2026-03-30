package org.example.GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.entities.Field;

public class FieldGUI extends Button {

    boolean isRevealed;
    int size;
    int revealed = 0;

    public FieldGUI(boolean isRevealed){
        this.isRevealed=isRevealed;

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
    }


}
