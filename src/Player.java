public class Player {

    String colour;
    Pawn[] pawns = new Pawn[4];
    int activePawns = 0;
    int startField;

    public Player(String colour) {
        this.colour = colour;
        setStartField();
        for (int i = 0; i < pawns.length; i++) {
            pawns[i] = new Pawn(colour, Integer.toString(i), startField);
        }

    }

    //setting a start field based on player's colour
    private void setStartField(){
        switch (colour) {
            case "yellow" -> startField = 0;
            case "blue" -> startField = 13;
            case "red" -> startField = 26;
            case "green" -> startField = 39;
        }
    }
}
