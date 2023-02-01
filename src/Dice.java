public class Dice {

    public Dice(){

    }

    public int[] rollDice(){
        int[] diceResult = new int[2];

        diceResult[0] = (int) (Math.floor(Math.random()*(6-1) + 1));
        diceResult[1] = (int) (Math.floor(Math.random()*(6-1) + 1));

        return diceResult;
    }


}
