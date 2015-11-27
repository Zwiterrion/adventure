package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 *Crée une instance de Beton
 */
public class Beton extends ObjetCarte implements Fixe {

    /**
     * Appelle l'image qui correspond au Beton
     */
    @Override
    public void assigneImage() {
        image = Images.BETON;
    }
}
