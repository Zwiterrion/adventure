package Adventure;

/**
 * Created by Etienne on 24/10/2015.
 */
public class LocationDouble {

    public double x;
    public double y;

    public LocationDouble(double x, double y) {
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


    public static LocationDouble add (LocationDouble left, LocationDouble right) {
        return new LocationDouble(left.x + right.x, left.y + right.y);
    }

    public static LocationDouble diff (LocationDouble left, LocationDouble right) {
        return new LocationDouble(left.x - right.x, left.y - right.y);
    }

    public static LocationDouble mul (LocationDouble point, LocationDouble scalar) {
        return new LocationDouble(point.x * scalar.x, point.y * scalar.y);
    }

    public static LocationDouble div (LocationDouble point, LocationDouble scalar) {
        return new LocationDouble(point.x / scalar.x, point.y / scalar.y);
    }
}
