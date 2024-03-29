import java.awt.*;
/**
 * Class for creating instance of Pawn
 */
public class Pawn{

    String id;
    String colour;
    int startField;
    int currentField;
    Player player;
    int completePath;

    //Drawing properties
    final int blockSize = 40;
    final int pawnSize = (4*blockSize) / 5;
    int x; int y;
    Color c;

    //InGame flags
    boolean inHome = false;
    boolean ableToMove = false;

    /**
     * Constructor of pawn
     * @param player Player that this pawn belong to
     * @param id ID of pawn (0-3)
     */
    public Pawn(Player player, int id) {
        this.id = player.colour+id;
        this.colour = player.colour;
        this.startField = player.startField;
        this.player = player;
        this.completePath = 0;

        setDefaultXY(id);
        setColor();
    }

    /**
     * Public function to set X and Y of pawn
     * in order to draw in appropriate place on board
     * @param x new value of x
     * @param y new value of y
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Private function to set a default X and Y of pawn
     * @param id id of pawn
     */
    public void setDefaultXY(int id){

        int x = player.sectorX+blockSize;
        int y = player.sectorY+blockSize;

        if (id == 0) setXY(x + pawnSize, y + pawnSize); //top-left pawn
        if (id == 1) setXY(x + pawnSize, y + (3 * pawnSize)); //bottom-left pawn
        if (id == 2) setXY(x + (3 * pawnSize), y + pawnSize); //top-right pawn
        if (id == 3) setXY(x + (3 * pawnSize), y + (3 * pawnSize)); //bottom-right pawn

    }

    /**
     * Private function to set a Graphical colour of pawn
     */
    private void setColor(){
        switch (colour){
            case "blue" -> c = Color.BLUE;
            case "yellow" -> c = Color.YELLOW;
            case "green" -> c = Color.GREEN;
            case "red" -> c = Color.RED;
        }
    }


    public int getID(){
        return Integer.parseInt(id.substring(id.length()-1));
    }

}
