package org.example.GUI;

import javafx.scene.control.Button;
import org.example.entities.Field;

public class FieldGUI extends Button {

    boolean isRevealed;
    int size;
    int revealed = 0;

    public FieldGUI(boolean isRevealed){
        this.isRevealed=isRevealed;
    }


}
