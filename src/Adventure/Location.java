package Adventure;

public class Location {

    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "-" + y;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Location){
            Location l = (Location)o;
            return l.x == this.x && l.y == this.y;
        }
        return false;
    }
}