package Adventure;


public class Position {

    public int x;
    public int y;

    /**
     * Constructeur permettant de créer une Position (x,y)
     *
     * @param x : coordonées en x
     * @param y : coordonées en y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie si oui ou non la position, passée en argument, et égale à l'instance de cette classe
     *
     * @param o : Deuxième Position passée en paramètre
     * @return
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
     * @param a : position a
     * @param b : position b
     * @return
     */
    public static Position add(Position a, Position b) {
        return new Position(a.x + b.x, a.y + b.y);
    }

    /**
     * Renvoie la différence de deux positions passées en paramètre
     *
     * @param a : position a
     * @param b : position b
     * @return
     */
    public static Position diff(Position a, Position b) {
        return new Position(a.x - b.x, a.y - b.y);
    }

    /**
     * Renvoie la multiplication de deux positions
     *
     * @param point  : Première position
     * @param scalar : Deuxième position
     * @return
     */
    public static Position mul(Position point, Position scalar) {
        return new Position(point.x * scalar.x, point.y * scalar.y);
    }

    @Override
    public String toString() {
        return x + " : " + y;
    }
}