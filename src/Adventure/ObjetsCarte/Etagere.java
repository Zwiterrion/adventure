package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance d 'Etagere
 */
public class Etagere extends ObjetCarte implements Fixe {

    /**
     * Construit le Herbe
     * @param d
     *          La direction de l'image
     */
    public Etagere(Direction d) {
        super(d);
    }

    /**
     * Appelle l'image qui correspond au Etagere
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.SUD || dir == Direction.NORD)
            image = Images.ETAGERE;
        else if (dir == Direction.EST || dir == Direction.OUEST)
            image = Images.ETAGERE_BIS;
        else
            image = Images.ETAGERE_ANGLE;
    }
}
