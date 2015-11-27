package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

/**
 * Crée une instance de Vie
 */
public class Vie extends ObjetCarte implements Ramassable, Fixe {

    /**
     * Assigne l'image qui corresponde a la Vie
     */
    @Override
    public void assigneImage() {
        image = Images.VIE;
    }

    /**
     *
     * @return
     *      Le nombre de points a ajouter au heros
     */
    @Override
    public int quantite() {
        return 40;
    }
}
