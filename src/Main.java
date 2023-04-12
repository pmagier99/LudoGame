
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 4;

        Game game = new Game(numberOfPlayers);
        GUI gui = new GUI(game.players);

        game.setUpInputsAndOutputs(gui);

        scanner.nextLine();
        while(game.gameStatus){
            int i;
            for(i = 0; i < numberOfPlayers; i++){
                Thread.sleep(200);
                if(!game.gameStatus) break;
                game.rollDice(game.players.get(i));

            }
        }



        }
    }