package Adventure;

public class Triple {

    public final int type;
    public final Direction dir;
    public final String destination;

    public Triple(int x, Direction y, String destination) {
        this.type = x;
        this.dir = y;
        this.destination = destination;
    }
}