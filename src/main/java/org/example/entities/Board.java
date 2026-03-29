package org.example.entities;

import org.example.Controller.GameController;

import java.util.*;

public class Board {
    private int amountOfFieldsX = 18;
    private int amountOfFieldsY = 18;
    private Field[][] fields = new Field[amountOfFieldsX][amountOfFieldsY];

    public Board(){

        //Initialize board
        for(int i=0; i<amountOfFieldsX; i++){
            for(int j=0; j<amountOfFieldsY; j++){
                try{
                    fields[i][j] = new Field(i,j);
                }catch(IllegalArgumentException err){
                    System.out.println(err.getMessage());
                }
            }
        }

        initializeBombs(fields,(int) Math.abs(amountOfFieldsX*amountOfFieldsY)/8);
        initializeFieldValues(fields);
    }

    public int getAmountOfFieldsX() {
        return amountOfFieldsX;
    }

    public void setAmountOfFieldsX(int amountOfFieldsX) {
        this.amountOfFieldsX = amountOfFieldsX;
    }

    public int getAmountOfFieldsY() {
        return amountOfFieldsY;
    }

    public void setAmountOfFieldsY(int amountOfFieldsY) {
        this.amountOfFieldsY = amountOfFieldsY;
    }

    public void setField(Field field, int x, int y) {
        this.fields[x][y] = field;
    }

    public Field[][] getFields() {
        return fields;
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    public void initializeBombs(Field[][] fields, int amountOfBombs){
        for(var i=0; i<amountOfBombs; i++){
            int randomX = (int) Math.floor(Math.random()*fields.length);
            int randomY = (int) Math.floor(Math.random()*fields[0].length);
            BombField newBomb = new BombField(randomX, randomY);
            fields[randomX][randomY]= newBomb;
        }
    }

    /** Sets the value of each field to the amount of neighbouring bombs
     *
     * @param fields
     */
    public void initializeFieldValues(Field[][] fields){
        for(var i=0; i<fields.length; i++){
            for(var j=0; j<fields[i].length; j++){
                var totalNeighBombs = 0;
                Stack<Field> neighbours = getFieldNeighbours(fields[i][j]);

                for(var n =0; n<neighbours.size(); n++){
                    if((neighbours.get(n) instanceof BombField)){
                        totalNeighBombs+=1;
                    }
                }
                fields[i][j].setNeighBombs(totalNeighBombs);
            }
        }
    }

    /** Returns single neighbour in the given direction
     *
     * @param field
     * @param offX offset X from field
     * @param offY offset Y from field
     * @return
     */
    public Field getFieldNeighbour(Field field, int offX, int offY){

        int targetFieldX = field.x+offX;
        int targetFieldY = field.y+offY;
        if(targetFieldX<0 || targetFieldX>=amountOfFieldsX || targetFieldY<0 || targetFieldY>=amountOfFieldsY){
            return null;
        }
        return fields[targetFieldX][targetFieldY];
    }

    /** Returns a Stack of all neighbours from a given field
     *
     * @param field
     * @return
     */
    public Stack<Field> getFieldNeighbours(Field field){

        Stack<Field> neighbours = new Stack<Field>();

        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){

                //Skip field location
                if(i==0 && j==0){
                    continue;
                }

                var neigh = getFieldNeighbour(field, i, j);

                if(neigh!=null){
                    neighbours.add(neigh);
                }
            }
        }

        return neighbours;
    }

    /** Reveal fields using BFS search.
     *
     * @param field
     * @return -1 if hit a bomb. Otherwise the number of revealed fields
     */
    public int revealField(Field field){

        int revealed = 0;

        if(field.isRevealed() || field.isFlagged()){
            return 0;
        }

        //Reveal
        field.reveal();

        //Hit a bomb
        if(field instanceof BombField){
            return -1;
        }

        Queue<Field> queue = new ArrayDeque<Field>();
        queue.add(field);
        revealed++;


        while (!queue.isEmpty()){
            Field field1 = queue.poll();

            if(field1.getNeighBombs()>0 || field1.isFlagged()){
                continue;
            }

            for(Field neigh: getFieldNeighbours(field1)){
                if(neigh.isRevealed() || neigh.isFlagged()) continue;

                neigh.reveal();
                revealed++;
                queue.add(neigh);
            }
        }
        return revealed;
    }

    public void revealBombs(){
        for(var i=0; i<amountOfFieldsX; i++){
            for(var j=0; j<amountOfFieldsY; j++){
                if(fields[i][j] instanceof BombField){
                    try{
                        fields[i][j].reveal();
                    } catch (IllegalStateException e) {
                        continue;
                    }
                }
            }
        }
    }

    public void flagField(Field field){
        if(field.isFlagged()){
            field.setFlagged(false);
            return;
        }
        field.setFlagged(true);
    }


    /** Prints the field structure in the terminal
     * 1 = bomb, 0 = normal field
     */
    public void print(){
        String boardString = "";
        for(var i=0; i<amountOfFieldsY; i++){
            for(var j=0; j<amountOfFieldsX; j++){
                var instance = fields[i][j];
                if(instance instanceof BombField){
                    boardString+="1";
                }else{
                    boardString+="0";
                }

            }
            boardString+=System.lineSeparator();
        }
        System.out.println(boardString);
    }


}
