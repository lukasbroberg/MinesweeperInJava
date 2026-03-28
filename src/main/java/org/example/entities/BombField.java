package org.example.entities;

public class BombField extends Field{
    public BombField(int x, int y){
        super(x, y);
    }

    @Override
    public void reveal(){
        revealed=true;
    }
}
