package org.example.entities;

public class Field {
    int x;
    int y;
    public boolean revealed = false;
    public int neighBombs = 0;
    private boolean flagged;

    public Field(int x, int y){
        if(x<0 || y<0){
            throw new IllegalArgumentException("x or y cannot be less than 0");
        }
        this.x = x;
        this.y = y;
    }

    public void reveal(){
        if(!revealed || !isFlagged()){
            revealed = true;
        }
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}
