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
        return x + " : " + y;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Location){
            Location l = (Location)o;
            return l.x == this.x && l.y == this.y;
        }
        return false;
    }


    public static Location add (Location left, Location right) {
        return new Location(left.x + right.x, left.y + right.y);
    }

    public static Location diff (Location left, Location right) {
        return new Location(left.x - right.x, left.y - right.y);
    }

    public static Location mul (Location point, Location scalar) {
        return new Location(point.x * scalar.x, point.y * scalar.y);
    }

    public static Location div (Location point, Location scalar) {
        return new Location(point.x / scalar.x, point.y / scalar.y);
    }
}