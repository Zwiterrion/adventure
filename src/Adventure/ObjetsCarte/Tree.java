package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Tree
 */
public class Tree extends ObjetCarte implements Fixe {

    /**
     * Appelle l'image qui correspond au Tree
     */
    @Override
    public void assigneImage() {
        image = Images.TREE;
    }
}
