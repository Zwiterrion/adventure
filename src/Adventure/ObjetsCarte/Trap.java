package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Piege;

/**
 * Crée une instance de Trap
 */
public class Trap extends ObjetCarte implements Fixe, Piege {

    /**
     * Assigne l'image qui correspond au Trap
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
        return 10;
    }
}
