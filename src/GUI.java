import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A class to instantiate a GUI
 */
public class GUI extends JFrame {


    private final int cellSize = 40;
    BoardDrawing pd;

    /**
     * Constructor of GUI
     * @param players List of players that participate in the game
     */
    public GUI(ArrayList<Player> players){

        //Defining pawns and board drawing
        pd = new BoardDrawing(players);
        BoardPanel pp = new BoardPanel();
        add(pp, BorderLayout.CENTER);

        setSize((cellSize*15) * 2,cellSize*15+50);
        setTitle("Ludo Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * A BoardPanel class that extends JPanel, used for storing image from BoardDrawing class
     */
    class BoardPanel extends JPanel{
        BoardPanel(){
            pd.setPreferredSize(new Dimension(cellSize*15, cellSize*15));
            add(pd);
        }
    }
}


