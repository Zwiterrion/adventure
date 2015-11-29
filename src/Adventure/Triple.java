package Adventure;

/**
 * Instance de Triple, le triplet retourner du fichier xml
 */
public class Triple {

    private final int type;
    private final Direction dir;
    private final String destination;

    /**
     * Construit un tripler
     * @param x
     *      Le type de l'objet = le numero correspondant
     * @param y
     *      La direction de l'objet
     * @param destination
     *      Le nom du fichier xml
     */
    public Triple(int x, Direction y, String destination) {
        this.type = x;
        this.dir = y;
        this.destination = destination;
    }

    /**
     *
     * @return
     *      Le type de l'objet
     */
    public int getType() {
        return type;
    }

    /**
     *
     * @return
     *      La direction de l'objet
     */
    public Direction getDir() {
        return dir;
    }

    /**
     *
     * @return
     *      Le fichier xml
     */
    public String getDestination() {
        return destination;
    }
}