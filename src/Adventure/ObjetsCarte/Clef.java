package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

/**
 * Crée une instance de Clef
 */
public class Clef extends ObjetCarte implements Ramassable, Fixe {

    /**
     * Appelle l'image qui correspond au Clef
     */
    @Override
    public void assigneImage() {
        image = Images.CLEF;
    }

}
