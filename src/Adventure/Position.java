package Adventure;


public class Position {

    public int x;
    public int y;

    /**
     * Constructeur permettant de créer une Position (x,y)
     *
     * @param x
     *          Coordonées en x
     * @param y
     *          Coordonées en y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie si oui ou non la position, passée en argument, et égale à l'instance de cette classe
     *
     * @param o
     *          Deuxième Position passée en paramètre
     * @return
     *      Un booléen si les positions sont equivalentes
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position l = (Position) o;
            return l.x == this.x && l.y == this.y;
        }
        return false;
    }


    /**
     * Renvoie l'addition de deux positions passées en paramètre
     *
     * @param a
     *          Position a
     * @param b
     *          Position b
     * @return
     *      L'addition de deux positions
     */
    public static Position add(Position a, Position b) {
        return new Position(a.x + b.x, a.y + b.y);
    }

    /**
     * Renvoie la différence de deux positions passées en paramètre
     *
     * @param a
     *          Position a
     * @param b
     *          Position b
     * @return
     *      La différence de deux positions
     */
    public static Position diff(Position a, Position b) {
        return new Position(a.x - b.x, a.y - b.y);
    }

    /**
     * Renvoie la multiplication de deux positions
     *
     * @param point
     *              Première position
     * @param scalar
     *              Deuxième position
     * @return
     *      La multiplication de deux positions
     */
    public static Position mul(Position point, Position scalar) {
        return new Position(point.x * scalar.x, point.y * scalar.y);
    }

}