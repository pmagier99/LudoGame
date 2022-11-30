package org.example;

public class Dice {

    public int[] dice = new int[2];

    public Dice(){
        dice[0] = rollDice();
        dice[1] = rollDice();
    }

    private int rollDice(){
        return 1 + (int) Math.floor(Math.random()*6);
    }

    public int[] getDice(){
        return dice;
    }

}
