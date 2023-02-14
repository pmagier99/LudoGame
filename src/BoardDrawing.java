import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;

/**
 * A class to display drawings of board and pawns
 * that can be updated as with each players' move
 */

public class BoardDrawing extends JComponent{

    ArrayList <Player> players; //list of players participated in game

    public BoardDrawing(ArrayList<Player> players){
        this.players = players;
    }

    /**
     * Override function from JComponent used to draw board and pawns
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){

        //Drawing of board
        Board b = new Board();
        b.paint(g);

        //Loop through each existed players and draw their pawns
        for(Player p : players){
            for(int i = 0; i < 4; i++){
                Pawn pawn = p.pawns[i];

                g.setColor(pawn.c);
                g.fillOval(pawn.x, pawn.y, pawn.pawnSize, pawn.pawnSize);

                g.setColor(Color.BLACK);
                g.drawOval(pawn.x, pawn.y, pawn.pawnSize, pawn.pawnSize);
            }
        }

    }


    /**
     * Public function used to graphically representation of moving a pawn on the board
     * @param pawn - Pawn that is specified to move
     * @param coordinates - array of coordinates of new position for pawn
     */
    public void move(Pawn pawn, int[] coordinates){
        pawn.x = coordinates[0] * pawn.blockSize + (pawn.blockSize - pawn.pawnSize)/2;
        pawn.y = coordinates[1] * pawn.blockSize + (pawn.blockSize - pawn.pawnSize)/2;
        repaint();
    }
}
