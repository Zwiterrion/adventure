package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Cree une instance de Maison
 */
public class Maison extends ObjetCarte implements Fixe {

    /**
     * Assigne l'image qui correspond a la Maison
     */
    @Override
    public void assigneImage() {
        image = Images.TOURELLE;
    }
}
