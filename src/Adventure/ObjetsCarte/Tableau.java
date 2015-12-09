package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Cree une instance de Tableau
 */
public class Tableau extends ObjetCarte implements Fixe {

    /**
     * Assigne l'image qui correspond au Tableau
     */
    @Override
    public void assigneImage() {
        image = Images.TABLEAU;
    }
}
