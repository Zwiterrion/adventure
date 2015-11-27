package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Tableau
 */
public class Tableau extends ObjetCarte implements Fixe {

    /**
     * Appelle l'image qui correspond au Tableau
     */
    @Override
    public void assigneImage() {
        image = Images.TABLEAU;
    }
}
