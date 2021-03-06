package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

/**
 * Cree une instance de Mana
 */
public class Mana extends ObjetCarte implements Ramassable, Fixe {

    /**
     * Assigne l'image qui correspond a la Mana
     */
    @Override
    public void assigneImage() {
        image = Images.MANA;
    }
}
