package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Cree une instance de Carrelage
 */
public class Carrelage extends ObjetCarte implements Fixe {

    /**
     * Assigne l'image qui correspond au Carrelage en fonction de la direction
     */
    @Override
    public void assigneImage() {
        image = Images.CARRELAGE;
    }
}
