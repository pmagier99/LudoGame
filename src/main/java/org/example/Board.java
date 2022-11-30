package org.example;

public class Board {


    int[][] bases;
    int[] board;

    /**
     * Creating a board with number of field 52,
     * and number of base same as number of players.
     * @param numberOfPlayers - number of players that are in the game.
     */
    public Board(int numberOfPlayers, int numberOfField){
        bases = new int[numberOfPlayers][4];
        board = new int[numberOfField];
    }

}
