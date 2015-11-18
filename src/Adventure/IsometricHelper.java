package Adventure;

public class IsometricHelper {

    public static Position point2DToIso(Position p) {

        p.x *= World.TILE_SIZE / 2;
        p.y *= World.TILE_SIZE / 2;

        Position point = Position.mul(p, new Position(1, -1));

        point = new Position((point.x - point.y), ((point.x + point.y) / 2));

        point = Position.mul(point, new Position(1, -1));

        point.y += 160;

        return point;

    }
}
