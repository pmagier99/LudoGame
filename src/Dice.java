public class Dice {

    public Dice(){
    }

    public int rollDice(){
        return (int) (Math.floor(Math.random()*(7-1) + 1));
    }


}