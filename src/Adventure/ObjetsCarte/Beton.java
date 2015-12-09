package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 *Cree une instance de Beton
 */
public class Beton extends ObjetCarte implements Fixe {

    /**
     * Assigne l'image qui correspond au Beton
     */
    @Override
    public void assigneImage() {
        image = Images.BETON;
    }
}
