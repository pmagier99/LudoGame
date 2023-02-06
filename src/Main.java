import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());

        GUI gui = new GUI(40, numberOfPlayers);

        Game game = new Game(numberOfPlayers, scanner);

        //loop until any of player complete the game
        while (game.gameStatus){

            //loop through player to let them move
            for(int i = 0; i<game.players.length; i++){
                System.out.println("Player " + game.players[i].colour + " throws dice." );
                game.rollDice(game.players[i]);

            }



        }


    }
}