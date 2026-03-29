package org.example.entities;

public class BombField extends Field{

    public BombField(int x, int y){
        super(x, y);
        setFlagged(false);
        setRevealed(false);
    }

    @Override
    public void reveal() throws IllegalStateException{

        if(isFlagged() || isRevealed()){
            throw new IllegalStateException("Cannot reveal field");
        }

        revealed = true;
    }

}
