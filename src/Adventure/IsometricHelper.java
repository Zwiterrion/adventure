package Adventure;

public class IsometricHelper {

    public static Location point2DToIso(Location p) {

        p.x *= World.TILE_SIZE/2;
        p.y *= World.TILE_SIZE/2;

        Location point = Location.mul(p, new Location(1, -1));

        point = new Location((point.x - point.y), ((point.x + point.y) / 2));

        point = Location.mul(point,new Location(1, -1));

        return point;

    }

/*    public static Location pointIsoTo2D(Location p ){


        Location point = Location.mul(p ,new Location(1, -1));

        point = new Location(((2 * point.y + point.x) / 2), ((2 * point.y - point.x) / 2));

        point = Location.mul(point,new Location(1, -1));

        return point;

    }*/

}
