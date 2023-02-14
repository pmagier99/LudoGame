public class Dice {

    public Dice(){

    }

    public int[] rollDice(){
        int[] diceResult = new int[2];

        diceResult[0] = (int) (Math.floor(Math.random()*(7-1) + 1));
        diceResult[1] = (int) (Math.floor(Math.random()*(7-1) + 1));

        System.out.println("Dice 1: " + diceResult[0]);
        System.out.println("Dice 2: " + diceResult[1]);

        return diceResult;
    }


}