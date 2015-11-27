package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Deplacable;

/**
 * Crée une instance de Maison
 */
public class MurDeplacable extends Mur implements Deplacable {

    /**
     * Construit le Herbe
     * @param d
     *          La direction de l'image
     */
    public MurDeplacable(Direction d) {
        super(d);
    }

    /**
     * Assigne l'image qui correspond a la Maison
     */
    @Override
    public void assigneImage() {
        image = Images.MUR_BOUGEABLE;
    }

}
