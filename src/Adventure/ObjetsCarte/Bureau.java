package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Bureau
 */
public class Bureau extends ObjetCarte implements Fixe {

    /**
     * Construit le Bureau
     * @param d
     *          La direction de l'image
     */
    public Bureau(Direction d) {
        super(d);
    }

    /**
     * Assigne l'image qui correspond au Bureau en fonction de la direction
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.SUD || dir == Direction.NORD)
            image = Images.BUREAU;
        else
            image = Images.BUREAU_BIS;
    }
}
