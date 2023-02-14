/**
 * Class for creating instance of Player
 */
public class Player implements BoardCoordinates{

    String colour;
    int startField;
    int[][] homeCoordinates;

    Pawn[] pawns = new Pawn[4];

    final int blockSize = 40;


    //Drawing purpose to define where pawns are stored on the board
    int sectorX;
    int sectorY;

    /**
     * Constructor of Player
     * @param colour the colour of player
     */
    public Player(String colour){
        this.colour = colour;
        setStartField();
        setSectoryXY();
        setHome();

        for(int i = 0; i < pawns.length; i++){
            pawns[i] = new Pawn(this, i);
        }
    }


    /**
     * Private function to define a start field based on a colour
     */
    private void setStartField() {
        switch (colour) {
            case "yellow" -> startField = 0;
            case "blue" -> startField = 12;
            case "red" -> startField = 24;
            case "green" -> startField = 36;
        }
    }

    /**
     * Private function to define a sector X and Y
     * to draw it on the board.
     */
    private void setSectoryXY(){
        switch (colour) {
            case "yellow" -> {
                sectorX = 0;
                sectorY = 9*blockSize;
            }
            case "blue" -> {
                sectorX = 0;
                sectorY = 0;
            }
            case "red" -> {
                sectorX = 9*blockSize;
                sectorY = 0;
            }
            case "green" -> {
                sectorX = 9*blockSize;
                sectorY = 9*blockSize;
            }
        }
    }

    private void setHome(){
        switch (colour) {
            case "yellow" -> homeCoordinates = BoardCoordinates.yellowHome;
            case "green" -> homeCoordinates = BoardCoordinates.greenHome;
            case "blue" -> homeCoordinates = BoardCoordinates.blueHome;
            case "red" -> homeCoordinates = BoardCoordinates.redHome;

        }
    }
}
