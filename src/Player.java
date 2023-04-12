import java.util.ArrayList;

/**
 * Class for creating instance of Player
 */
public class Player implements BoardCoordinates{


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    String consoleColour;
    String colour;
    int startField;
    int activePawns = 0;
    int[][] homeCoordinates;
    int homePawns = 0;

    ArrayList<Pawn> pawns = new ArrayList<>();
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
        setSectorXY();
        setHome();
        assignColours();

        for(int i = 0; i < 4; i++){
            pawns.add(new Pawn(this, i));
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
    private void setSectorXY(){
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

    private void assignColours(){
        switch (colour) {
            case "yellow" -> consoleColour = ANSI_YELLOW;
            case "green" -> consoleColour = ANSI_GREEN;
            case "blue" -> consoleColour = ANSI_BLUE;
            case "red" -> consoleColour = ANSI_RED;

        }
    }
}
