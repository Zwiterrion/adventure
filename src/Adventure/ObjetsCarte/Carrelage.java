package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Carrelage
 */
public class Carrelage extends ObjetCarte implements Fixe {

    /**
     * Appelle l'image qui correspond au Carrelage
     */
    @Override
    public void assigneImage() {
        image = Images.CARRELAGE;
    }
}
