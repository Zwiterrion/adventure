package Adventure;

public class IsometricHelper {

    public static Position point2DToIso(Position p) {

        Position e = new Position(p.x, p.y);

        e.x *= World.TILE_SIZE / 2;
        e.y *= World.TILE_SIZE / 2;

        Position point = Position.mul(e, new Position(1, -1));

        point = new Position((point.x - point.y), ((point.x + point.y) / 2));

        point = Position.mul(point, new Position(1, -1));

        point.y += 160;

        return point;

    }
}
