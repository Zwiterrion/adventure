package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Princesse
 */
public class Princesse extends ObjetCarte implements Fixe {

    /**
     * Assigne l'image qui correspond a la Maison
     */
    @Override
    public void assigneImage() {
        image = Images.PRINCESSE;
    }
}
