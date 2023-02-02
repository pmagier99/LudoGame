public class Pawn {

    String colour;
    boolean active;
    boolean inHome;
    int position;
    String ID;

    public Pawn(String colour, String ID, int position){
        this.ID = colour + ID;
        this.colour = colour;
        active = false; inHome = false;
        this.position = position;
    }

    public void addPawn(int position){
        this.active = true;
        this.position = position;
    }
}
