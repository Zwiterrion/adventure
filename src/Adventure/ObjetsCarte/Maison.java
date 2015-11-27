package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Maison
 */
public class Maison extends ObjetCarte implements Fixe {

    /**
     * Appelle l'image qui correspond a la Maison
     */
    @Override
    public void assigneImage() {
        image = Images.TOURELLE;
    }
}
