package Adventure;

public class Triple {

    private final int type;
    private final Direction dir;
    private final String destination;

    public Triple(int x, Direction y, String destination) {
        this.type = x;
        this.dir = y;
        this.destination = destination;
    }


    public int getType() {
        return type;
    }

    public Direction getDir() {
        return dir;
    }

    public String getDestination() {
        return destination;
    }
}