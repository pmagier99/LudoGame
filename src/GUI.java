import javax.swing.*;

public class GUI extends JFrame{

    Board board;
    public GUI(int size, int players){
        board = new Board(20,20, size, players);
        setBounds(0, 0, (size*15) * 2,size*15+50);
        setTitle("Ludo Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);

    }
}