package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

/**
 * Crée une instance de Clef
 */
public class Clef extends ObjetCarte implements Ramassable, Fixe {

    /**
     * Assigne l'image qui correspond au Clef en fonction de la direction
     */
    @Override
    public void assigneImage() {
        image = Images.CLEF;
    }

}
