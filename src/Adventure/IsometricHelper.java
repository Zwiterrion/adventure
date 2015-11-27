package Adventure;


/**
 * IsometricHelper est une classe possedant une seule methode statique qui
 *  calcule a partir d'un point en deux dimensions un point pour la vue isometrique.
 */
public class IsometricHelper {

    /**
     * Convertit un point 2D en point isometrique
     * @param p
     *      Position 2D de la carte
     * @return
     *      Position convertit pour la vue isometrique
     */
    public static Position point2DToIso(Position p) {

        Position e = new Position(p.x, p.y);

        e.x *= Monde.TILE_SIZE / 2;
        e.y *= Monde.TILE_SIZE / 2;

        Position point = Position.mul(e, new Position(1, -1));

        point = new Position((point.x - point.y), ((point.x + point.y) / 2));

        point = Position.mul(point, new Position(1, -1));

        point.y += 160;

        return point;

    }
}
