public class Player {

    String colour;
    Pawn[] pawns = new Pawn[4];

    public Player(String colour) {
        this.colour = colour;

        for (int i = 0; i < pawns.length; i++) {
            pawns[i] = new Pawn(colour);
        }

    }
}
