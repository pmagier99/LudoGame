import java.awt.*;

/**
 * A class to draw a board
 */
public class Board{

    int x; int y;
    int blockSize;

    public Board(){
        this.x = 0; this.y = 0;
        this.blockSize = 40;
    }

    public void paint(Graphics g){
        //path vertical
        int xPath = x+(6*blockSize);
        int yPath = y+blockSize;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 13; j++){
                g.setColor(Color.white);
                g.fillRect(xPath+(i*blockSize), yPath+(j*blockSize), blockSize, blockSize);
                g.setColor(Color.black);
                g.drawRect(xPath+(i*blockSize), yPath+(j*blockSize), blockSize, blockSize);
            }
        }

        //path horizontal
        xPath = x+blockSize;
        yPath = y+(6*blockSize);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 13; j++){
                g.setColor(Color.white);
                g.fillRect(xPath+(j*blockSize), yPath+(i*blockSize), blockSize, blockSize);
                g.setColor(Color.black);
                g.drawRect(xPath+(j*blockSize), yPath+(i*blockSize), blockSize, blockSize);
            }
        }

        //drawing sectors
        drawSector(g, new Player("red"));
        drawSector(g, new Player("yellow"));
        drawSector(g, new Player("blue"));
        drawSector(g, new Player("green"));

        //start&home RED
        g.setColor(Color.red);
        g.fillRect(x+(8*blockSize), y+(3*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(2*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(3*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(4*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(5*blockSize), blockSize, blockSize);

        g.setColor(Color.black);
        g.drawRect(x+(8*blockSize), y+(3*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(2*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(3*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(4*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(5*blockSize), blockSize, blockSize);

        //start&home YELLOW
        g.setColor(Color.yellow);
        g.fillRect(x+(6*blockSize), y+(11*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(12*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(11*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(10*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(9*blockSize), blockSize, blockSize);

        g.setColor(Color.black);
        g.drawRect(x+(6*blockSize), y+(11*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(12*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(11*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(10*blockSize), blockSize, blockSize);
        g.drawRect(x+(7*blockSize), y+(9*blockSize), blockSize, blockSize);

        //start&home BLUE
        g.setColor(Color.blue);
        g.fillRect(x+(3*blockSize), y+(6*blockSize), blockSize, blockSize);
        g.fillRect(x+(2*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(3*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(4*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(5*blockSize), y+(7*blockSize), blockSize, blockSize);

        g.setColor(Color.black);
        g.drawRect(x+(3*blockSize), y+(6*blockSize), blockSize, blockSize);
        g.drawRect(x+(2*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.drawRect(x+(3*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.drawRect(x+(4*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.drawRect(x+(5*blockSize), y+(7*blockSize), blockSize, blockSize);

        //start&home GREEN
        g.setColor(Color.green);
        g.fillRect(x+(11*blockSize), y+(8*blockSize), blockSize, blockSize);
        g.fillRect(x+(12*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(11*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(10*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(9*blockSize), y+(7*blockSize), blockSize, blockSize);

        g.setColor(Color.black);
        g.drawRect(x+(11*blockSize), y+(8*blockSize), blockSize, blockSize);
        g.drawRect(x+(12*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.drawRect(x+(11*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.drawRect(x+(10*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.drawRect(x+(9*blockSize), y+(7*blockSize), blockSize, blockSize);

        //center
        g.setColor(Color.black);
        g.fillRect(x+(7*blockSize), y+(6*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(6*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(8*blockSize), y+(7*blockSize), blockSize, blockSize);
        g.fillRect(x+(7*blockSize), y+(8*blockSize), blockSize, blockSize);


    }

    private void drawSector(Graphics g, Player player){

        g.setColor(player.pawns.get(0).c);
        g.fillRect(player.sectorX, player.sectorY, 6*blockSize,6*blockSize);

        g.setColor(Color.white);
        g.fillRect(player.sectorX+blockSize, player.sectorY+blockSize, 4*blockSize, 4*blockSize);

    }

}
