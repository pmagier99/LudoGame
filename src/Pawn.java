public class Pawn {

    String colour;
    boolean active;
    boolean inHome;
    int position;

    public Pawn(String colour){
        this.colour = colour;
        active = false; inHome = false;
        setPosition();
    }

    //setting a start position for each pawn based on its colour
    private void setPosition(){
        switch (colour) {
            case "yellow" -> position = 0;
            case "blue" -> position = 13;
            case "red" -> position = 26;
            case "green" -> position = 39;
        }
    }

}
