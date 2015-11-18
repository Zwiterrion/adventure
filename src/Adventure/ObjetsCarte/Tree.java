package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

public class Tree extends ObjetCarte implements Fixe {


    @Override
    public void assignImage() {
        image = Images.TREE;
    }
}
