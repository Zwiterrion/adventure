package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Cree une instance de Tree
 */
public class Tree extends ObjetCarte implements Fixe {

    /**
     * Assigne l'image qui correspond au Tree
     */
    @Override
    public void assigneImage() {
        image = Images.TREE;
    }
}
