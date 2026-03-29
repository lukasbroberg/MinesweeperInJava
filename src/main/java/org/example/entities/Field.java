package org.example.entities;

public class Field {
    int x;
    int y;
    protected boolean revealed = false;
    private int neighBombs = 0;
    private boolean flagged;

    public Field(int x, int y){
        if(x<0 || y<0){
            throw new IllegalArgumentException("x or y cannot be less than 0");
        }
        this.x = x;
        this.y = y;
    }

    public void reveal() throws IllegalStateException{

        /*if(isFlagged() || isRevealed()){
            throw new IllegalStateException("Cannot reveal field");
        }*/

        revealed = true;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public int getNeighBombs() {
        return neighBombs;
    }

    public void setNeighBombs(int neighBombs) {
        this.neighBombs = neighBombs;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}
