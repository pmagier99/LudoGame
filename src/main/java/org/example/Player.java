package org.example;

public class Player {
    String colour;
    int positionOnBoard;
    int pawnsInBase = 0;
    int pawns = 4;
    int pawnsOnBoard = 0;


    public Player(String colour, int positionOnBoard){
        this.colour = colour;
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * adding a pawn to final base
     * there must not be more than 4 pawns in final base
     */
    public void addPawnToBase(){
        if(pawnsInBase > 4){
            pawnsInBase++;
            pawnsOnBoard--;
        }
    }

    /**
     * adding a pawn on board
     * there must not be more than 4 pawns on board
     */
    public void addPawnOnBoard(){
        if(pawns > 0){
            pawns--;
            pawnsOnBoard++;
        }
    }

}
