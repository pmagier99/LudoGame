import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());

        Game game = new Game(numberOfPlayers, scanner);
        GUI gui = new GUI(game.players);



        //loop until any of player complete the game
//        while (game.gameStatus){
//
//            //loop through player to let them move
//            for(int i = 0; i<game.players.size(); i++){
//                System.out.println("Player " + game.players.get(i).colour + " throws dice." );
////                game.rollDice(game.players.get(i));
//
//            }
//
//        }
    }
}