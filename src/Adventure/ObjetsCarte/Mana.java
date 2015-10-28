package Adventure.ObjetsCarte;

import Adventure.Images;

public class Mana extends ObjetCarte {

    private int value = 100;

    @Override
    public void assignImage() {
        image = Images.MANA;
    }

}
