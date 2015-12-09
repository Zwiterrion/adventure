package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

/**
 * Cree une instance de Bombe
 */
public class Bombe extends ObjetCarte implements Ramassable, Fixe {

    /**
     * Assigne l'image qui correspond au Bombe en fonction de la direction
     */
    @Override
    public void assigneImage() {
        image = Images.CLEF;
    }

}
