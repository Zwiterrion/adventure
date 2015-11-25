package Adventure;

public class Tuple {

    public final int type;
    public final Direction dir;
    public final String destination;

    public Tuple(int x, Direction y, String destination) {
        this.type = x;
        this.dir = y;
        this.destination = destination;
    }
}