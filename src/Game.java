
import java.util.*;

/**
 * Class to create a game of Ludo
 */
public class Game implements BoardCoordinates{

    public static final String RESET = "\033[0m";
    private final String[] playersColour = {"yellow", "red", "blue", "green"};

    ArrayList<Player> players;
    String[] board;
    int[][] boardCoordinates = BoardCoordinates.bc;

    String[] yellowHome = new String[]{"", "", "", ""};
    String[] blueHome = new String[]{"", "", "", ""};
    String[] redHome = new String[]{"", "", "", ""};
    String[] greenHome = new String[]{"", "", "", ""};

    Dice dice;
    GUI gui;

    boolean gameStatus;

    List<String[]> gameData;


    /**
     * Constructor of Game class,
     * it fills the board with empty strings, add given number of players to players Arrays
     * @param numberOfPlayers - number of players that will participate in the game.
     */
    public Game(int numberOfPlayers){

        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(playersColour[i]));
        }
        board = new String[boardCoordinates.length];

        Arrays.fill(board, "");
        dice = new Dice();
        gameStatus = true;
    }

    /**
     * Public function to display interface
     * @param gui - GUI class
     */
    public void setUpInputsAndOutputs(GUI gui){
        this.gui = gui;
    }

    /**
     * Public function to roll dice for given player, then it randomly decide what moves should be
     * @param p - Player that needs to make his move.
     */
    public void rollDice(Player p){
        int diceResult = dice.rollDice();
        System.out.println(p.consoleColour + "["+p.colour+"]"+ RESET+"Throws " + diceResult);

        if(diceResult == 6){
            //if dice show 6 then either move or add pawn
            if(p.activePawns == 0){
                addPawn(p);

            }else if(p.activePawns == 4){
                movePawn(p, diceResult);
            }else{
                //decide either to move or add pawn

                int random_int = (int)(Math.random() * 1 + 0);
                switch (random_int) {
                    case 0 -> movePawn(p, diceResult);
                    case 1 -> addPawn(p);
                }


            }
        }else if(p.activePawns != 0){
            //if there are active pawns then move
            movePawn(p,diceResult);
        }else{
            System.out.println(p.consoleColour + "["+p.colour+"]"+ RESET +"You dont have active pawns, you lose your turn.");
        }

    }

    /**
     * Public function to proceed with a move of pawn for given player.
     * @param p - player that needs to make his move
     * @param dice - number of rolled dice.
     */
    public void movePawn(Player p, int dice){

        //get random pawn from active pawns
        Pawn playerPawn = getRandomActivePawn(p);

        //clear current field
        board[playerPawn.currentField] = board[playerPawn.currentField].replace(playerPawn.id + ".", "");

        //identify next field
        int nextFieldIndex = 0;
        int homeSlot = playerPawn.completePath + dice - 46; //returns number between 0 and 3;

        if(playerPawn.completePath + dice > 45 && playerPawn.completePath + dice <= 49){
            //in range of home

            if(Objects.equals(playerPawn.colour, "yellow") && Objects.equals(yellowHome[homeSlot], "")){
                gui.pd.move(playerPawn, BoardCoordinates.yellowHome[homeSlot]);
                yellowHome[homeSlot] = playerPawn.id;

            }else if(Objects.equals(playerPawn.colour, "blue") && Objects.equals(blueHome[homeSlot], "")){
                gui.pd.move(playerPawn, BoardCoordinates.blueHome[homeSlot]);
                blueHome[homeSlot] = playerPawn.id;

            }else if(Objects.equals(playerPawn.colour, "red") && Objects.equals(redHome[homeSlot], "")){
                gui.pd.move(playerPawn, BoardCoordinates.redHome[homeSlot]);
                redHome[homeSlot] = playerPawn.id;

            }else if(Objects.equals(playerPawn.colour, "green") && Objects.equals(greenHome[homeSlot], "")){
                gui.pd.move(playerPawn, BoardCoordinates.greenHome[homeSlot]);
                greenHome[homeSlot] = playerPawn.id;

            }else{
                board[playerPawn.currentField] += playerPawn.id + ".";
                sendMessage("Cannot enter home!", p);
                return;
            }


            sendMessage("Enters home!", p);

            playerPawn.completePath += (dice);

            playerPawn.ableToMove = false;
            playerPawn.inHome = true;
            p.homePawns++;
            p.activePawns--;
            setGameStatus(p);
            return;

        }else if(playerPawn.completePath + dice > 45) {
            //in range of home but too many dice rolled
            board[playerPawn.currentField] += playerPawn.id + ".";
            sendMessage("Cannot enter home!", p);
            return;
        }else{
            //not in range of home
            nextFieldIndex = (playerPawn.currentField + dice > boardCoordinates.length - 1) ? playerPawn.currentField + dice - boardCoordinates.length  : playerPawn.currentField + dice ;
        }

        String nextField = board[nextFieldIndex];



        //check if next field is occupied or not
        if(Objects.equals(nextField, "")){
            //field is empty
            board[nextFieldIndex] = playerPawn.id + ".";
            sendMessage("Has moved pawn by " + (dice) + " squares.", p);
        }else{
            //field is occupied
            Pawn[] pawns = identifyPawn(nextField);

            if(Objects.equals(pawns[0].colour, playerPawn.colour)){
                //the next field is occupied by the same colour
                board[nextFieldIndex] += playerPawn.id + ".";
                sendMessage("Has created a shield", p);
            }else if(pawns.length > 1){
                //shield is created
                board[nextFieldIndex] += playerPawn.id + ".";
                sendMessage("Cannot strike pawn because of shield", p);
            }else{
                //there is only pawn
                strikePawn(pawns[0]);
                board[nextFieldIndex] = playerPawn.id + ".";
                sendMessage("Has struck a "+ pawns[0].colour +"'s pawn", p);
            }
        }

        playerPawn.currentField = nextFieldIndex;
        playerPawn.completePath += (dice);
        gui.pd.move(playerPawn, boardCoordinates[nextFieldIndex]);
        setGameStatus(p);


    }

    /**
     * Public function to add a Pawn for given Player.
     * @param p - player that will get a new pawn to the board.
     */
    public void addPawn(Player p){

        //Check if startfield for given player is occupied or not
        if(Objects.equals(board[p.startField], "") || board[p.startField].contains(p.colour)){
            System.out.println(p.consoleColour + "["+p.colour+"]"+ RESET+"Put new pawn to the board!");
        }else{

            sendMessage("Has struck a "+ identifyPawn(board[p.startField])[0].colour +"'s pawn", p);
            strikePawn(identifyPawn(board[p.startField])[0]);
            board[p.startField] = "";
        }

        Pawn selectedPawn;
        selectedPawn = getRandomInactivePawn(p);

        selectedPawn.ableToMove = true;
        board[p.startField] += selectedPawn.id+".";
        gui.pd.move(selectedPawn, boardCoordinates[p.startField]);
        selectedPawn.currentField = p.startField;
        p.activePawns++;


    }

    /**
     * Public function to remove an opponent pawn.
     * @param pawn - pawn that is to remove from board
     */
    public void strikePawn(Pawn pawn){

        int id = Integer.parseInt(pawn.id.substring(pawn.id.length()-1));
        gui.pd.delete(pawn, id);
        pawn.completePath = 0;
        pawn.ableToMove = false;
        pawn.player.activePawns--;


    }

    /**
     * Public function to identify what pawns are on given field.
     * @param pawnID string of pawnsID on given field.
     * @return array of Pawns that occupies give field
     */
    public Pawn[] identifyPawn(String pawnID){
        String[] pawns = pawnID.split("\\.");
        Pawn[] pawnsArray = new Pawn[pawns.length];

        for(int i = 0; i < pawns.length; i++){
            int pawnNo = Integer.parseInt(pawns[i].substring(pawns[i].length() - 1));
            String pawnColour = pawns[i].substring(0, pawns[i].length() - 1);

            int colourIndex;
            switch (pawnColour){
                case "yellow" -> colourIndex = 0;
                case "red" -> colourIndex = 1;
                case "blue" -> colourIndex = 2;
                case "green" -> colourIndex = 3;
                default -> colourIndex = -1;
            }

            Player playerToStrike = players.get(colourIndex);

            for(int j = 0; j < playerToStrike.pawns.size(); j++){
                if(playerToStrike.pawns.get(j).getID() == pawnNo){
                    pawnsArray[i] = playerToStrike.pawns.get(j);
                    break;
                }
            }

        }

        return pawnsArray;
    }


    /**
     * Set the game status once either of players reach number of home pawns equals to 4
     * @param p player that is to check for winning
     */
    private void setGameStatus(Player p){
        if(p.homePawns == 4){
            gameStatus = false;
            sendMessage("Won the game!",p);
        }
    }

    /**
     * Private function to print out a message to console about the current event.
     * @param message message to print out
     * @param p which player made a given event.
     */
    private void sendMessage(String message, Player p){
        System.out.println(p.consoleColour + "["+p.colour+"]" + RESET + message);
    }

    /**
     * Private function to get a random active pawn to move it by the player.
     * @param player player that needs to make his move
     * @return a Pawn that will be moved
     */
    private Pawn getRandomActivePawn(Player player){
        ArrayList<Pawn> arr = new ArrayList<>();

        for(int i = 0; i< player.pawns.size(); i++){
            if(player.pawns.get(i).ableToMove) arr.add(player.pawns.get(i));
        }

        int random_int = (int)(Math.random() * arr.size() + 0);

        return arr.get(random_int);

    }

    /**
     * Private function to get a random inactive pawn to add to the board.
     * @param player player that needs to make his move
     * @return a Pawn that will be added
     */
    private Pawn getRandomInactivePawn(Player player){
        ArrayList<Pawn> arr = new ArrayList<>();

        for(int i = 0; i< player.pawns.size(); i++){
            if(!player.pawns.get(i).ableToMove && !player.pawns.get(i).inHome) arr.add(player.pawns.get(i));
        }

        int random_int = (int)(Math.random() * arr.size() + 0);

        return arr.get(random_int);


    }
}

