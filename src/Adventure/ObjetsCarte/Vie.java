package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

/**
 * Crée une instance de Vie
 */
public class Vie extends ObjetCarte implements Ramassable, Fixe {

    /**
     * Appelle l'image qui corresponde a la Vie
     */
    @Override
    public void assigneImage() {
        image = Images.VIE;
    }

    /**
     *
     * @return
     *      le nombre de points a incrementer
     */
    @Override
    public int quantite() {
        return 40;
    }
}
