package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Piege;

/**
 * Cree une instance de PiegeSol
 */
public class PiegeSol extends ObjetCarte implements Fixe, Piege {

    /**
     * Assigne l'image qui correspond au PiegeSol
     */
    @Override
    public void assigneImage() {
        image = Images.TRAP;
    }

    /**
     *
     * @return
     *      Retourne le nombre de points a infliger
     */
    @Override
    public int degat() {
        return 20;
    }
}
