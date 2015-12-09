package Adventure.ObjetsCarte;

import Adventure.Direction;

import java.awt.*;

/**
 * Cree un objet de la carte de jeu
 */
public abstract class ObjetCarte {

    protected Image image;
    protected Direction dir = Direction.TOUTES;

    /**
     * Construit l'objet
     */
    public ObjetCarte() {
        assigneImage();
    }

    /**
     * Construit l'objet avec une direction donnee
     * @param d
     *        La direction de l'objet
     */
    public ObjetCarte(Direction d) {
        super();
        setDir(d);
    }

    /**
     * Change la direction
     * @param dir
     *          La direction
     */
    public void setDir(Direction dir) {
        this.dir = dir;
        assigneImage();
    }

    /**
     * Assigne l'image correspondante a chaque objet
     */
    public abstract void assigneImage();

    /**
     *
     * @return
     *      Retourne l'image
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @return
     *      Retoune le nom de la classe
     */
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
