package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Voiture
 */
public class Voiture extends ObjetCarte implements Fixe {

    /**
     * Construit la Voiture
     * @param dir
     *          La direction de l'image
     */
    public Voiture(Direction dir) {
        super(dir);
    }

    /**
     * Assigne l'image qui corresponde a la Voiture
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.SUD)
            image = Images.VOITURE_ARRIERE;
        else
            image = Images.VOITURE_AVANT;
    }
}
