import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    int x; int y; int size;
    int sectorSize;
    int cellInside;
    int[] blue;
    int[] red;
    int[] yellow;
    int[] green;

    ArrayList<int[]> players = new ArrayList<>();

    public Board(int x, int y, int size, int noplayers){
        this.x = x;
        this.y = y;
        this.size = size;

        sectorSize = 4*size;
        cellInside = sectorSize / 5;

        blue = new int[]{x, y};
        red = new int[]{x+9*size, y};
        yellow = new int[]{x, y+9*size};
        green = new int[]{x+9*size, y+9*size};

        switch (noplayers){
            case 2 -> {
                players.add(red);
                players.add(yellow);
            }
            case 3 -> {
                players.add(red);
                players.add(yellow);
                players.add(blue);
            }
            case 4 -> {
                players.add(red);
                players.add(yellow);
                players.add(blue);
                players.add(green);
            }
            default -> System.out.println("Wrong number of players;");
        }


    }

    @Override
    public void paint(Graphics g){

        //path vertical
        int xpath = x+(6*size);
        int ypath = y+size;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 13; j++){
                g.setColor(Color.white);
                g.fillRect(xpath+(i*size), ypath+(j*size), size, size);
                g.setColor(Color.black);
                g.drawRect(xpath+(i*size), ypath+(j*size), size, size);
            }
        }

        //path horizontal
        xpath = x+size;
        ypath = y+(6*size);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 13; j++){
                g.setColor(Color.white);
                g.fillRect(xpath+(j*size), ypath+(i*size), size, size);
                g.setColor(Color.BLACK);
                g.drawRect(xpath+(j*size), ypath+(i*size), size, size);
            }
        }

        //sector BLUE
        g.setColor(Color.BLUE);
        drawSector(g, blue);

        //pawns BLUE
        g.setColor(Color.BLUE);
        drawPawns(g, blue);

        //start&home BLUE
        g.setColor(Color.blue);
        g.fillRect(x+(2*size), y+(6*size), size, size);
        g.fillRect(x+(2*size), y+(7*size), size, size);
        g.fillRect(x+(3*size), y+(7*size), size, size);
        g.fillRect(x+(4*size), y+(7*size), size, size);
        g.fillRect(x+(5*size), y+(7*size), size, size);

        g.setColor(Color.black);
        g.drawRect(x+(2*size), y+(6*size), size, size);
        g.drawRect(x+(2*size), y+(7*size), size, size);
        g.drawRect(x+(3*size), y+(7*size), size, size);
        g.drawRect(x+(4*size), y+(7*size), size, size);
        g.drawRect(x+(5*size), y+(7*size), size, size);

        //sector RED
        g.setColor(Color.RED);
        drawSector(g, red);

        //pawns RED
        g.setColor(Color.RED);
        drawPawns(g, red);

        //start&home RED
        g.setColor(Color.red);
        g.fillRect(x+(8*size), y+(2*size), size, size);
        g.fillRect(x+(7*size), y+(2*size), size, size);
        g.fillRect(x+(7*size), y+(3*size), size, size);
        g.fillRect(x+(7*size), y+(4*size), size, size);
        g.fillRect(x+(7*size), y+(5*size), size, size);

        g.setColor(Color.black);
        g.drawRect(x+(8*size), y+(2*size), size, size);
        g.drawRect(x+(7*size), y+(2*size), size, size);
        g.drawRect(x+(7*size), y+(3*size), size, size);
        g.drawRect(x+(7*size), y+(4*size), size, size);
        g.drawRect(x+(7*size), y+(5*size), size, size);

        //sector YELLOW
        g.setColor(Color.YELLOW);
        drawSector(g, yellow);

        //pawns YELLOW
        g.setColor(Color.YELLOW);
        drawPawns(g, yellow);

        //start&home YELLOW
        g.setColor(Color.yellow);
        g.fillRect(x+(6*size), y+(12*size), size, size);
        g.fillRect(x+(7*size), y+(12*size), size, size);
        g.fillRect(x+(7*size), y+(11*size), size, size);
        g.fillRect(x+(7*size), y+(10*size), size, size);
        g.fillRect(x+(7*size), y+(9*size), size, size);

        g.setColor(Color.black);
        g.drawRect(x+(6*size), y+(12*size), size, size);
        g.drawRect(x+(7*size), y+(12*size), size, size);
        g.drawRect(x+(7*size), y+(11*size), size, size);
        g.drawRect(x+(7*size), y+(10*size), size, size);
        g.drawRect(x+(7*size), y+(9*size), size, size);

        //sector GREEN
        g.setColor(Color.GREEN);
        drawSector(g, green);

        //pawns GREEN
        g.setColor(Color.GREEN);
        drawPawns(g, green);

        //start&home GREEN
        g.setColor(Color.green);
        g.fillRect(x+(12*size), y+(8*size), size, size);
        g.fillRect(x+(12*size), y+(7*size), size, size);
        g.fillRect(x+(11*size), y+(7*size), size, size);
        g.fillRect(x+(10*size), y+(7*size), size, size);
        g.fillRect(x+(9*size), y+(7*size), size, size);

        g.setColor(Color.black);
        g.drawRect(x+(12*size), y+(8*size), size, size);
        g.drawRect(x+(12*size), y+(7*size), size, size);
        g.drawRect(x+(11*size), y+(7*size), size, size);
        g.drawRect(x+(10*size), y+(7*size), size, size);
        g.drawRect(x+(9*size), y+(7*size), size, size);

        //center
        g.setColor(Color.black);
        g.fillRect(x+(7*size), y+(6*size), size, size);
        g.fillRect(x+(7*size), y+(7*size), size, size);
        g.fillRect(x+(6*size), y+(7*size), size, size);
        g.fillRect(x+(8*size), y+(7*size), size, size);
        g.fillRect(x+(7*size), y+(8*size), size, size);

    }

    private void drawSector(Graphics g, int[] colour){
        g.fillRect(colour[0], colour[1], 6*size,6*size);
        g.setColor(Color.WHITE);
        g.fillRect(colour[0]+size, colour[1]+size, 4*size, 4*size);
    }

    private void drawPawns(Graphics g, int[] colour){
        if(!players.contains(colour)){
            return;
        }
        int x = colour[0]+size;
        int y = colour[1]+size;
        g.fillOval(x+cellInside, y+cellInside, cellInside, cellInside);
        g.fillOval(x+(3*cellInside), y+cellInside, cellInside, cellInside);
        g.fillOval(x+cellInside, y+(3*cellInside), cellInside, cellInside);
        g.fillOval(x+(3*cellInside), y+(3*cellInside), cellInside, cellInside);
        g.setColor(Color.black);
        g.drawOval(x+cellInside, y+cellInside, cellInside, cellInside);
        g.drawOval(x+(3*cellInside), y+cellInside, cellInside, cellInside);
        g.drawOval(x+cellInside, y+(3*cellInside), cellInside, cellInside);
        g.drawOval(x+(3*cellInside), y+(3*cellInside), cellInside, cellInside);
    }

    public void movePawn(Graphics g){

    }


}
