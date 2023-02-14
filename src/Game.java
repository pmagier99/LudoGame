import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final String[] playersColour = {"red", "yellow", "blue", "green"};
    private final int NumberOfFields = 52;
    Scanner scanner;

    ArrayList<Player> players;
    String[] board;
    Dice dice;

    boolean gameStatus;

    public Game(int numberOfPlayers, Scanner scanner){

        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(playersColour[i]));
        }
        board = new String[NumberOfFields];
        dice = new Dice();
        this.scanner = scanner;
        gameStatus = true;
    }


//    public void rollDice(Player p){
//        int[] diceResult = dice.rollDice();
//
//        if(diceResult[0] == 6 || diceResult[1] == 6){
//            //if dice show 6 then either move or add pawn
//
//            if(p.activePawns == 0){
//                addPawn(p);
//            }else{
//                //decide either to move or add pawn
//                System.out.println("Do you want to move pawn or add pawn? ");
//                String decision = scanner.nextLine();
//
//                switch (decision) {
//                    case "move" -> movePawn(p, diceResult);
//                    case "add" -> addPawn(p);
//                }
//            }
//        }else if(p.activePawns != 0){
//            //if there are active pawns then move
//            movePawn(p,diceResult);
//        }else{
//            System.out.println("You dont have active pawns, you lose your turn.");
//        }
//
//    }
//
//    public void movePawn(Player p, int[] dice){
//        System.out.println("Select pawn to move [0-4]");
//        Pawn selectedPawn = p.pawns[Integer.parseInt(scanner.nextLine())];
//
//        if(selectedPawn.active){
//
//            if(board[selectedPawn.position + dice[0] + dice[1]] != "") { //field is occupied
//                //TO DO: recognise which pawn occupies the spot and remove it.
//            }
//
//            selectedPawn.position += (dice[0] + dice[1]);
//
//        }else{
//            System.out.println("This pawn is inactive");
//            movePawn(p, dice);
//        }
//
//    }
//
//    public void addPawn(Player p){
//        System.out.println("Select pawn to add [0-4]"); //TO DO: show which are available to add
//        Pawn selectedPawn = p.pawns[Integer.parseInt(scanner.nextLine())];
//
//        selectedPawn.addPawn(p.startField);
//        p.activePawns++;
//
//    }
}
